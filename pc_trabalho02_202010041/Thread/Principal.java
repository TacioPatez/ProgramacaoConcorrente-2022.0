/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 07/03/2022
* Ultima alteracao.: 08/03/2022
* Nome.............: Principal
* Funcao...........: Este codigo tem a funcao de fazer com que
                    o GUI feito no FXMLMain seja mostrado na tela
                    e iniciar as threads.
*************************************************************** */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.MainController;
import model.PaiThread;
import model.Filho1Thread;
import model.Filho2Thread;
import model.Filho3Thread;
import model.Neto1Thread;
import model.Neto2Thread;
import model.Bisneto1Thread;

public class Principal extends Application {
public static void main(String[] args) throws Exception{
  launch(args);
}

@Override
public void start(Stage arg0) throws Exception {
  Parent root = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
  Scene scene = new Scene(root);
  arg0.setTitle("Family Genealogy - Thread");
  arg0.setScene(scene);
  arg0.setResizable(false);
  arg0.show();   
}
}