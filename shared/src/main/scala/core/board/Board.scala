package core.board

import breeze.linalg.DenseMatrix
import core.settings

class Board {

  val rows = settings.board.getInt("rows")
  val cols = settings.board.getInt("cols")

  val grid: DenseMatrix[Int] = DenseMatrix.zeros(rows, cols)
}
