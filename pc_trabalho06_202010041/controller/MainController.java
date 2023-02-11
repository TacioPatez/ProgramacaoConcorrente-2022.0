/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 01/05/2022
* Ultima alteracao.: 06/05/2022
* Nome.............: MainController
* Funcao...........: Manipula os objetos da Thread e implementa
                    alguns metodos das threads.
*************************************************************** */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Barbeiro;
import model.Corte;
import model.NewClientes;

public class MainController implements Initializable, Runnable{

  @FXML
  private AnchorPane anchorPane_Background;

  @FXML
  private Button button_ChegandoAction;

  @FXML
  private Button button_CortandoAction;

  @FXML
  private Label label_Fila1;

  @FXML
  private Label label_Fila2;

  @FXML
  private Label label_Fila3;

  @FXML
  private Label label_Fila4;

  @FXML
  private TextField textfield_TempoChegando;

  @FXML
  private TextField textfield_TempoCortando;

  public  long tempoChegando = 10;
  public  long tempoCortando = 10;
  NewClientes ClientesThread;
  Barbeiro BarbeiroThread;
  Corte corteThread;

  @FXML
  void chegandoTime(ActionEvent event) {
    try{
      tempoChegando = Long.parseLong(textfield_TempoChegando.getText());
    } catch(Exception e){
      System.out.println("[ERROR]");
    } finally {
      System.out.println(tempoChegando);
    }
  }

  @FXML
  void cortandoTime(ActionEvent event) {
    try{
      tempoCortando = Long.parseLong(textfield_TempoCortando.getText());
    } catch(Exception e){
      System.out.println("[ERROR]");
    } finally {
      System.out.println(tempoCortando);
    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
      ClientesThread = new NewClientes(this);
      BarbeiroThread = new Barbeiro(this);
      corteThread = new Corte(this);
      run();
      
  }
  
/* ***************************************************************
* Metodo: run
* Funcao: Esta funcao inicia as threads
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  @Override
  public void run() {
    ClientesThread.start();
    BarbeiroThread.start();
    corteThread.start();
    
  }

    //GETS N SETS
  
  public AnchorPane getAnchorPane() {
    return anchorPane_Background;
  }

  public ImageView getImageBarbeiro() {
    return BarbeiroThread.getImageViewBarbeiro();
  }

  public long getTempoChegando() {
    return tempoChegando;
  }

  public long getTempoCortando() {
    return tempoCortando;
  }

  public void setLabel_Fila1(String label_Fila1) {
    this.label_Fila1.setText(label_Fila1);
  }

  public void setLabel_Fila2(String label_Fila2) {
    this.label_Fila2.setText(label_Fila2);
  }

  public void setLabel_Fila3(String label_Fila3) {
    this.label_Fila3.setText(label_Fila3);
  }

  public void setLabel_Fila4(String label_Fila4) {
    this.label_Fila4.setText(label_Fila4);
  }
  
}
