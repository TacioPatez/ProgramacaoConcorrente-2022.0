/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 27/03/2022
* Ultima alteracao.: 27/03/2022
* Nome.............: Principal
* Funcao...........: Este codigo tem a funcao de fazer com que
                    o GUI feito no FXMLMain seja executado.
*************************************************************** */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Train1Thread;
import model.Train2Thread;
import controller.MainController;

public class Principal extends Application{
  public static void main(String[] args) throws Exception{
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLMain.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setTitle("Trens");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
    
    primaryStage.setOnCloseRequest(Event -> {
      System.exit(0);
    });
  }
}