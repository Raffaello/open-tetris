package generator

import org.scalatest.{FlatSpec, Matchers}
import Utils.{minima, translateToOrigin}

class UtilsSpec extends FlatSpec with Matchers {

  "minima" should "be correct" in {
    minima(List((-1,1), (0,1), (0,0), (0,-1))) should be ((-1,-1))
  }

  "tranaslateToOrigin" should "be correct" in {
    translateToOrigin(List((-1,1), (0,1), (0,0), (0,-1))) should
      be (List((0,2), (1,2), (1,1), (1,0)))
  }
}
