package generator

/**
  * @see [[https://wiki.haskell.org/The_Monad.Reader/Issue5/Generating_Polyominoes]]
  * @deprecated doesn't return lower rank and is not tail recursive and not one-side
  */
object Free extends Generator {

  import scala.language.implicitConversions

  protected implicit def transformation(polyomino: Polyomino): List[Polyomino] = {
    val refPol = polyomino.map(reflect)

    rotations(polyomino) ++ List(
      refPol,
      refPol.map(rotate90), // === pol
      refPol.map(rotate180),
      refPol.map(rotate270)
    )
  }
}
