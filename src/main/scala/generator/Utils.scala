package generator

object Utils {
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
}
