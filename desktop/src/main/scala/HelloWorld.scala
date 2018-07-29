import scalafx.application
import scalafx.application.JFXApp
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.HBox
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text
import core.settings

object HelloWorld extends JFXApp {

  stage = new application.JFXApp.PrimaryStage {
    title.value = "open-tetris: Hello World ScalaFX"
    width = settings.video.getInt("width")
    height = settings.video.getInt("height")
    scene = new Scene {
      fill = Color.Black
      content = new HBox {
        padding = Insets(50, 80, 50, 80)
        children = Seq(
          new Text {
            text = "Open"
            style = "-fx-font: normal bold 50pt sans-serif"
            fill = new LinearGradient(
              endX = 0,
              stops = Stops(Color.Red, Color.DarkRed))
          },
          new Text {
            text = "Tetris"
            style = "-fx-font: italic bold 50pt sans-serif"
            fill = new LinearGradient(
              endX = 0,
              stops = Stops(Color.White, Color.DarkGray)
            )
            effect = new DropShadow {
              color = Color.DarkGray
              radius = 15
              spread = 0.25
            }
          }
        )
      }
    }
  }
}
