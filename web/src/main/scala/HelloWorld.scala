import org.scalajs.dom.html.Canvas
import org.scalajs.dom.raw.CanvasRenderingContext2D

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("HelloWorld")
object HelloWorld {
  @JSExport
  def main(args: Array[String]): Unit = {
    val canvas: Canvas = org.scalajs.dom.document.getElementById("canvas").asInstanceOf[Canvas]
    val ctx = canvas.getContext("2d").asInstanceOf[CanvasRenderingContext2D]

    println("Hello World!")
    ctx.font = "120px serif"

    val gradient = ctx.createLinearGradient(0, 0, 0, canvas.height)
    gradient.addColorStop(0, "white")
    gradient.addColorStop(0.5, "black")
    ctx.fillStyle = gradient
    ctx.fillText("Open Tetris", 50, 150)
  }
}
