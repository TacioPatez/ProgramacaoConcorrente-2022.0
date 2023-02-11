/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 01/05/2022
* Ultima alteracao.: 06/05/2022
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
import model.Barbeiro;
import model.Cliente;
import model.Corte;
import model.NewClientes;
import utils.GlobalVariables;

public class Principal extends Application{
  public static void main(String[] args){
    launch(args);
  }
  
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLMain.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setTitle("Barbeiro Dorminhoco");
    primaryStage.setScene(scene);
    primaryStage.getIcons().add(new Image("/img/barbeiro/icone.png"));
    primaryStage.setResizable(false);
    primaryStage.show();
    
    primaryStage.setOnCloseRequest(Event -> {
      System.exit(0);
    });   
  }
}