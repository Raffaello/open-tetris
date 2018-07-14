package core.polyominoes

import java.io._
import java.nio.charset.StandardCharsets

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

    val pw = new PrintWriter(new FileWriter(new File(fname)))
    val N = polyominoes.length

    pw.println(N)
    polyominoes.foreach(polyomino => pw.println(polyomino.mkString(", ")))
    pw.close()
  }

  /**
    * todo: could use the Loan Patter to auto close the resource
    * todo: FP for handling exceptions
    * todo: redo it
    * @param fname
    * @return
    */
  def load(fname: String): List[Polyomino] = {

    val bs = Source.fromFile(fname)
    val lines = bs.getLines().toArray
    bs.close

    val n = lines(0).toInt
    // todo: wrong rex exp (0,0), (0,1) => (0,1) only match
    val r = """^(\((\d+),\s*(\d+)\),?\s*)+""".r
    val polyominoes = new ListBuffer[Polyomino]
    val polyomino = new ListBuffer[Point]

    for (i <- 1 to n) {
      val rowString = lines(i).toString
      val row = r.findAllMatchIn(rowString)

      polyomino.clear()
      while(row.hasNext) {
        val m = row.next()
        assert(m.groupCount == 2)
        polyomino += ((m.group(1).toInt, m.group(2).toInt))
      }

      polyominoes += polyomino.toList
    }

    polyominoes.toList
  }
}
