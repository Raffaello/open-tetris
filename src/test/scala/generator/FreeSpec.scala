package generator

import generator.Free.Polyomino
import org.scalatest.{FlatSpec, Matchers}

class FreeSpec extends FlatSpec with Matchers {

  "minima" should "be correct" in {
    Free.minima(List((-1,1), (0,1), (0,0), (0,-1))) should be ((-1,-1))
  }

  "tranaslateToOrigin" should "be correct" in {
    Free.translateToOrigin(List((1,1), (-1,1))) should be (List((2,0),(0,0)))
    Free.translateToOrigin(List((-1,1), (0,1), (0,0), (0,-1))) should be (List((0,2), (1,2), (1,1), (1,0)))
  }

  "Free generator" should "generate Monominos correctly" in {
    Free.rank(1) should be (List(List((0,0))))
  }

  "Free generator" should "generate Dominos correctly" in {
    Free.rank(2) should be (List(List((0,0), (0,1))))
  }

  "Free generator" should "generate Pentominoes correctly" in {
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

    val tetronimoes = Free.rank(5)
    tetronimoes.foreach(t => println(t.mkString(" ")))
    tetronimoes should be (expected)
  }
}
