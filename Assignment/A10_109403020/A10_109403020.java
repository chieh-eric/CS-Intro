/* Assignment 10
 Name : 王廷傑
 ID : 109403020
 Course : 2023-CE1002
 */
package A10_109403020;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class A10_109403020 extends Application {
 public void start(Stage primaryStage) throws Exception{
Parent root = FXMLLoader.load(getClass().getResource("A10_109403020.fxml"));
primaryStage.setTitle("A10_109403020");
primaryStage.setScene(new Scene(root, 700,400 ));
primaryStage.show();}
public static void main(String[] args) {
launch(args);}
}
