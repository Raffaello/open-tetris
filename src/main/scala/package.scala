package object generator {

  private[generator] type Point = (Int, Int)
  private[generator] type Polyomino = List[Point]

  private[generator] val monomino: Polyomino = List((0, 0))
  private[generator] val monominos: List[Polyomino] = List(monomino)

  def save(fname: String, polyominoes: List[Polyomino]) = ???

  def load(fname: String): List[Polyomino] = ???
}
