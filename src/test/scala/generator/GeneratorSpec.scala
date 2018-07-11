package generator

import org.scalatest.{FlatSpec, Matchers}

class GeneratorSpec extends FlatSpec with Matchers with Generator {

  import scala.language.implicitConversions

  protected implicit def transformation(polyomino: Polyomino): List[Polyomino] = Nil

  "minima" should "be correct" in {
    minima(List((-1, 1), (0, 1), (0, 0), (0, -1))) should be((-1, -1))
  }

  "tranaslateToOrigin" should "be correct" in {
    translateToOrigin(List((-1, 1), (0, 1), (0, 0), (0, -1))) should
      be(List((0, 2), (1, 2), (1, 1), (1, 0)))
  }
}
