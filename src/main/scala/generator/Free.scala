package generator

import scala.language.implicitConversions

/**
  * @see [[https://wiki.haskell.org/The_Monad.Reader/Issue5/Generating_Polyominoes]]
  */
object Free extends Generator {
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
