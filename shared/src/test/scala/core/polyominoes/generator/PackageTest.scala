package core.polyominoes.generator

import java.io.File

import org.scalatest.{FlatSpec, Matchers}

class PackageTest extends FlatSpec with Matchers {

  val fname = "/tmp/open-tetris.generator.test"
  val polyominoes = List(List((0, 0), (0, 1)), List((0, 0), (0, 1), (0, 2)))

  "Load & Save polyominoes" should "be correct" in {

    save(fname, polyominoes)
    new File(fname).exists() should be(true)
    load(fname) should be(polyominoes)
  }
}
