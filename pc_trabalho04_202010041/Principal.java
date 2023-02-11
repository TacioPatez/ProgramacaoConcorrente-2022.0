/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 07/04/2022
* Ultima alteracao.: 09/04/2022
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
import model.Vehicles;
import model.ProducerThread;
import model.ConsumerThread;
import model.NewVehicles;
import utils.BufferManager;
import controller.MainController;

public class Principal extends Application{
  public static void main(String[] args) throws Exception{
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLMain.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setTitle("Parking Lot");
    primaryStage.setScene(scene);
    primaryStage.getIcons().add(new Image("/img/vehicle4.png"));
    primaryStage.setResizable(false);
    primaryStage.show();
    
    primaryStage.setOnCloseRequest(Event -> {
      System.exit(0);
    });
  }
}