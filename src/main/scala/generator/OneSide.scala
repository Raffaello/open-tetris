package generator

object OneSide extends Generator {

  import scala.language.implicitConversions

  protected implicit def transformation(polyomino: OneSide.Polyomino): List[OneSide.Polyomino] = rotations(polyomino)
}
