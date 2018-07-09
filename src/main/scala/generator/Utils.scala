package generator

object Utils {
  type Point = (Int, Int)
  type Polyomino = List[Point]

  val monomino: Polyomino = List((0, 0))
  val monominos: List[Polyomino] = List(monomino)
}
