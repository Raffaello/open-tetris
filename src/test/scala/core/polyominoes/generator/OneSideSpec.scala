package core.polyominoes.generator

import core.polyominoes.generator.OneSide.{accumulativeRank, rank}
import org.scalatest.{FlatSpec, Matchers}

class OneSideSpec extends FlatSpec with Matchers {

  "OneSide core.polyominoes.generator" should "generate Dominos correctly" in {
    rank(2) should be(List(List((0, 0), (0, 1))))

  }

  "OneSide iterator" should "generate until dominos correctly" in {
    accumulativeRank(2) should be(List(monomino, List((0, 0), (0, 1))))
  }

  "OneSide iterator" should "generate until pentominoes correctly" in {
    accumulativeRank(5) should have size (18 + 7 + 2 + 1 + 1)
  }
}
