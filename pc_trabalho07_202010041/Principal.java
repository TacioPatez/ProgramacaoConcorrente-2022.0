/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 16/05/2022
* Ultima alteracao.: 20/05/2022
* Nome.............: Principal
* Funcao...........: Este codigo tem a funcao de fazer a interacao entre
                    a interface grafica e os codigos, alem de atribuir
                    funcoes/eventos para os buttons, labels, sliders, etc.
*************************************************************** */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import controller.MainController;
import model.Car2;
import model.Car6;
import model.Car7;
import model.Car10;
import model.Car12;
import model.Car16;
import model.Car22;
import utils.GlobalVariables;

public class Principal extends Application{
  public static void main(String[] args){
    launch(args);
  }
  
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLMain.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setTitle("Transito Autonomo");
    primaryStage.setScene(scene);
    primaryStage.getIcons().add(new Image("/img/icon.png"));
    primaryStage.setResizable(false);
    primaryStage.show();
    
    primaryStage.setOnCloseRequest(Event -> {
      System.exit(0);
    });   
  }
}