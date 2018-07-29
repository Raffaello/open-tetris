import core.settings
import scalafx.application
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.{Canvas, GraphicsContext}
import scalafx.scene.paint.Color

object PolyominoesDrawingTest extends JFXApp {

  val canvas = new Canvas(
    settings.video.getInt("width"),
    settings.video.getInt("height")
  )

  val gc = canvas.graphicsContext2D

  /**
    * Monomio example incomplete
    *
    * @param gc
    * @param color
    * @param x
    * @param y
    * @param w
    * @param h
    */
  def rectangle(gc: GraphicsContext, color: Color, x: Double, y: Double, w: Double, h: Double) = {

    gc.setFill(color)
    gc.fillRect(x, y, w, h)
    gc.setFill(color.interpolate(Color.White, 0.5).opacity(0.5))
    gc.fillRect(x, y, w, h / 10)
    gc.setFill(color.darker.opacity(0.5))
    gc.fillRect(x + w - w / 10, y, w / 10, h)
    gc.setFill(color.darker.darker.opacity(0.5))
    gc.fillRect(x, y + h - h / 10, w, h / 10)
    gc.setLineWidth(w / 20)
    gc.strokeRect(x, y, w, h)
  }


  def tetronimoT(gc: GraphicsContext, color: Color, x: Double, y: Double, w: Double, h: Double) = {
    rectangle(gc, color, x, y, w, h)
    rectangle(gc, color, x + w, y, w, h)
    rectangle(gc, color, x + w + w, y, w, h)
    rectangle(gc, color, x + w, y + h, w, h)
  }

  stage = new application.JFXApp.PrimaryStage {
    title.value = "open-tetris: monomio"
    width = settings.video.getInt("width")
    height = settings.video.getInt("height")
    scene = new Scene {
      fill = Color.Grey
      content = canvas
    }
  }

  // monomio
  rectangle(gc, Color.Red, 50, 50, 50, 50)

  // domino
  val (x, y, w, h) = (50, 100, 50, 50)
  rectangle(gc, Color.Yellow, x, y, w, h)
  rectangle(gc, Color.Yellow, x + w, y, w, h)

  //tetronimoT
  tetronimoT(gc, Color.Green, 50, 200, 50, 50)
}
