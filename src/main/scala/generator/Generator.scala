package generator

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import scala.language.implicitConversions

trait Generator {
  type Point = (Int, Int)
  type Polyomino = List[Point]

  val monomino: Polyomino = List((0, 0))
  val monominos: List[Polyomino] = List(monomino)

  def rotate90(p: Point): Point = (p._2, -p._1)

  def rotate180(p: Point): Point = (-p._1, -p._2)

  def rotate270(p: Point): Point = (-p._2, p._1)

  def reflect(p: Point): Point = (-p._1, p._2)

  def contiguous(p: Point): List[Point] = List(
    (p._1 - 1, p._2),
    (p._1 + 1, p._2),
    (p._1, p._2 - 1),
    (p._1, p._2 + 1),
  )

  def minima(polyomino: Polyomino): Point = {
    polyomino.reduce((a, b) => (Math.min(a._1, b._1), Math.min(a._2, b._2)))
  }

  def translateToOrigin(polyomino: Polyomino): Polyomino = {
    val m = minima(polyomino)
    polyomino.map(p => (p._1 - m._1, p._2 - m._2))
  }

  protected[this] def rotations(polyomino: Polyomino): List[Polyomino] = {
    List(
      polyomino,
      polyomino.map(rotate90),
      polyomino.map(rotate180),
      polyomino.map(rotate270),
    )
  }

  protected implicit def transformation(polyomino: Polyomino): List[Polyomino]

  private[this] def canonical(polyomino: Polyomino)(implicit transformation: Polyomino => List[Polyomino]): Polyomino = {
    import Ordering.Implicits._

    transformation(polyomino)
      .map(translateToOrigin)
      .map(poly => poly.sorted).min
  }

  private[this] def newPoints(polyomino: Polyomino): List[Point] = {
    polyomino.flatMap(contiguous).filterNot(polyomino.contains(_)).distinct
  }

  private[this] def newPolyominos(polyomino: Polyomino): List[Polyomino] = {
    newPoints(polyomino).map(p => canonical(p :: polyomino)).distinct
  }

  def rank(n: Int): List[Polyomino] = {
    require(n >= 0)
    n match {
      case 0 => Nil
      case 1 => monominos
      case _ => rank(n - 1).flatMap(newPolyominos).distinct
    }
  }

  def accumulativeRank(n: Int): List[Polyomino] = {
    require(n >= 1)

    @tailrec
    def innerLoop(n: Int, acc: ListBuffer[Polyomino]): ListBuffer[Polyomino] = {
      n match {
        case 1 => acc
        case _ => innerLoop(n - 1, acc.flatMap(newPolyominos) ++=: acc)
      }
    }

    val polyominoes = ListBuffer[Polyomino]()
    innerLoop(n, monominos ++=: polyominoes).distinct.toList.reverse
  }
}
