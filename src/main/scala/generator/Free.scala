package generator

import generator.Utils.{
  Point, Polyomino, monominos, reflect, rotate90, rotate180, rotate270, contiguous,
  translateToOrigin
}

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/**
  * @see [[https://wiki.haskell.org/The_Monad.Reader/Issue5/Generating_Polyominoes]]
  * @deprecated doesn't return lower rank and is not tail recursive and not one-side
  */
object Free {

  //  val rotations = Array[Point => Point](rotate90, rotate180, rotate270)
  def rotationsAndReflections(polyomino: Polyomino): List[Polyomino] = {
    val refPol = polyomino.map(reflect)
    List(
      polyomino,
      polyomino.map(rotate90),
      polyomino.map(rotate180),
      polyomino.map(rotate270),
      refPol,
      refPol.map(rotate90), // === pol
      refPol.map(rotate180),
      refPol.map(rotate270),
    )
  }

  def canonical(polyomino: Polyomino): Polyomino = {
    import Ordering.Implicits._

    rotationsAndReflections(polyomino)
      .map(translateToOrigin)
      .map(poly => poly.sorted).min
  }

  def newPoints(polyomino: Polyomino): List[Point] = {
    polyomino.flatMap(contiguous).filterNot(polyomino.contains(_)).distinct
  }

  def newPolyominos(polyomino: Polyomino): List[Polyomino] = {
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
