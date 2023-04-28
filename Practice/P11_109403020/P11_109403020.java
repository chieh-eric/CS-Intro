/* Practice 11
 Name : 王廷傑
 ID : 109403020
 Course : 2023-CE1004
 */
package P11_109403020;
import javafx.scene.control.Label;
import javafx.animation.*;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class P11_109403020 extends Application {

    @Override
    public void start(Stage primaryStage) {
    	//製作一個圓心位於200,100，半徑100，角度60的圓弧
        Arc arc = new Arc(200, 200, 100, 100, 0, 60);
        arc.setType(ArcType.OPEN);
        arc.setFill(Color.TRANSPARENT);
        arc.setStroke(Color.GRAY);
        arc.setStrokeWidth(20);
        //製作學號的label
        Label label = new Label("109403020");
        label.setLayoutX(0);
        label.setLayoutY(0);

        Pane pane = new Pane(arc);
        pane.getChildren().add(label);
        //製作以圓弧中心為點做旋轉
        Rotate rotation = new Rotate();
        rotation.pivotXProperty().bind(arc.centerXProperty());
        rotation.pivotYProperty().bind(arc.centerYProperty());

    
        arc.getTransforms().add(rotation);
        
 

        //設置第一個KeyFrame起始點的第一個旋轉角度為0，透明度為1
        //第二個KeyFrame表示在一秒鐘時間點，旋轉角度為360，透明度為0
        //第三個KeyFrame表示在6秒鐘時間點，旋轉角度為720，透明度為1
        Timeline timeline = new Timeline(
        		new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 0) , new KeyValue(arc.opacityProperty(), 0.1)),
                new KeyFrame(Duration.seconds(2), new KeyValue(rotation.angleProperty(), 360) ,new KeyValue(arc.opacityProperty(), 1)),
                new KeyFrame(Duration.seconds(4), new KeyValue(rotation.angleProperty(),720), new KeyValue(arc.opacityProperty(), 0.1))
        				); 
         //重複無限多次
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        
        
        BorderPane root = new BorderPane(pane, null, null, null, null);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
