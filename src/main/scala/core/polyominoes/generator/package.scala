package core.polyominoes

import java.io.{BufferedWriter, File, FileWriter}

import scala.collection.mutable.ListBuffer
import scala.io.Source

package object generator {

  // might be better using case classes instead of type definition?
  private[polyominoes] type Point = (Int, Int)
  private[polyominoes] type Polyomino = List[Point]

  private[polyominoes] val monomino: Polyomino = List((0, 0))
  private[polyominoes] val monominos: List[Polyomino] = List(monomino)

  /**
    * @deprecated redo it
    * @param fname
    * @param polyominoes
    */
  def save(fname: String, polyominoes: List[Polyomino]): Unit = {
    val bw = new BufferedWriter(new FileWriter(new File(fname)))
    val N = polyominoes.length
    bw.write(N)
    polyominoes.foreach{ polyomino =>
      val M = polyomino.length
      bw.write(M)
      polyominoes.foreach(p => bw.write(p.mkString(" ")))
    }

    bw.close()
  }

  /**
    * todo: could use the Loan Patter to auto close the resource
    * todo: FP for handling exceptions
    * @param fname
    * @return
    */
  def load(fname: String): List[Polyomino] = {

    val bs = Source.fromFile(fname)
    val lines = bs.getLines().toArray
    bs.close
    val N = lines(0).toInt
    val polyominoes = new ListBuffer[Polyomino]
    val polyomino = new ListBuffer[Point]
    for(i <- 1 until lines.length) {
      val M = lines(i).toInt
      polyomino.clear()
      for(j <- 0 until M) {
//        val row = lines()
        polyomino += ((1,1))
      }

      polyominoes += polyomino.toList
    }

    polyominoes.toList
  }
}
