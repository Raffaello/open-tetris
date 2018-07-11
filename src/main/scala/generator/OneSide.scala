package generator

import scala.language.implicitConversions

object OneSide extends Generator {
  protected implicit def transformation(polyomino: OneSide.Polyomino): List[OneSide.Polyomino] = rotations(polyomino)
}
