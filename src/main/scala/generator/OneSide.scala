package generator

import scala.language.implicitConversions

object OneSide extends Generator {

  protected implicit def transformation(polyomino: Polyomino): List[Polyomino] = rotations(polyomino)
}
