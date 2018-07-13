package core.polyominoes.generator

import org.scalatest.{FlatSpec, Matchers}

class FreeSpec extends FlatSpec with Matchers {

  "Free core.polyominoes.generator" should "generate Monominos correctly" in {
    Free.rank(1) should be (monominos)
  }

  "Free core.polyominoes.generator" should "generate Dominos correctly" in {
    Free.rank(2) should be (List(List((0,0), (0,1))))
  }

  "Free core.polyominoes.generator" should "generate Pentominoes correctly" in {
    val expected = List[Polyomino](
      List((0,0), (0,1), (1,1), (1,2), (2,1)),
      List((0,0), (0,1), (0,2), (1,0), (1,1)),
      List((0,0), (0,1), (0,2), (0,3), (1,1)),
      List((0,1), (1,0), (1,1), (1,2), (2,1)),
      List((0,0), (0,1), (0,2), (1,1), (2,1)),
      List((0,0), (0,1), (1,1), (1,2), (2,2)),
      List((0,0), (0,1), (0,2), (1,2), (1,3)),
      List((0,0), (0,1), (1,1), (2,1), (2,2)),
      List((0,0), (0,1), (0,2), (1,0), (1,2)),
      List((0,0), (0,1), (0,2), (0,3), (1,0)),
      List((0,0), (0,1), (0,2), (1,0), (2,0)),
      List((0,0), (0,1), (0,2), (0,3), (0,4)))

      Free.rank(5) should be (expected)
  }

  "Free iterator" should "generate until dominos correctly" in {
    Free.accumulativeRank(2) should be(List(monomino, List((0,0),(0,1))))
  }

  "Free iterator" should "generate until pentominoes correctly" in {
    Free.accumulativeRank(5) should have size(12+5+2+1+1)
  }
}
