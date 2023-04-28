/* Practice 10
 Name : 王廷傑
 ID : 109403020
 Course : 2023-CE1004
 */
package P10_109403020;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;


public class P10_109403020 extends Application {

@Override
public void start(Stage primaryStage) throws Exception{
   Pane pane = new Pane();
   Rectangle r1 = new Rectangle(50, 50, 200, 150);
   r1.setStroke(Color.BLACK);
   r1.setFill(Color.BLUE);
   pane.getChildren().add(r1);
   Scene scene = new Scene(pane, 300, 250);
	primaryStage.setTitle("P10_109403020");
	primaryStage.setScene(scene);
	primaryStage.show();
}

public static void main(String[] args) {
launch(args);
}

}

