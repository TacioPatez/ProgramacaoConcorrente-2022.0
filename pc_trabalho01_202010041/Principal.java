/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 03/01/2022
* Ultima alteracao.: 01/02/2022
* Nome.............: Principal
* Funcao...........: Este codigo tem a funcao de fazer com que
                    o GUI feito no FXMLMain seja mostrado na tela.
*************************************************************** */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.MainController;
import controller.AtomData;
import controller.GameController;
import model.Atom;

public class Principal extends Application {

  public static void main(String[] args) throws Exception {
    launch(args);
  }

  @Override
  public void start(Stage arg0) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
    Scene scene = new Scene(root);
    arg0.setTitle("Periodic Fascination");
    arg0.setScene(scene);
    arg0.setResizable(false);
    arg0.show();
  }
}
