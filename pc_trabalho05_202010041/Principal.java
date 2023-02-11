/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 20/04/2022
* Ultima alteracao.: 23/04/2022
* Nome.............: Principal
* Funcao...........: Este codigo tem a funcao de inicializar a
                    interface grafica e liga-la ao codigo que 
                    manipulara ela.
*************************************************************** */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import controller.MainController;
import model.Filosofos;
import utils.GlobalVariables;

public class Principal extends Application{
  public static void main(String[] args){
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLMain.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setTitle("Jantar dos Filosofos");
    primaryStage.setScene(scene);
    primaryStage.getIcons().add(new Image("/img/filosofoPiton.png"));
    primaryStage.setResizable(false);
    primaryStage.show();
    
    primaryStage.setOnCloseRequest(Event -> {
      System.exit(0);
    });   
  }
}