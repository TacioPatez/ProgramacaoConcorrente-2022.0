/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 07/04/2022
* Ultima alteracao.: 09/04/2022
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
import javafx.scene.layout.AnchorPane;
import model.Vehicles;
import model.ProducerThread;
import model.ConsumerThread;
import model.NewVehicles;
import utils.BufferManager;
import controller.MainController;

public class MainController implements Initializable, Runnable{

  @FXML
  private AnchorPane anchorpanefather;

  @FXML
  private Button button_ChegadaVeiculos;

  @FXML
  private Button button_DuracaoVeiculos;

  @FXML
  private Label label_VeiculosNaFila;

  @FXML
  private TextField textfield_ChegadaVeiculos;

  @FXML
  private TextField textfield_DuracaoVeiculos;

  private long inputVelocity = 10;
  private long outputVelocity = 10;
  ConsumerThread producerThread;
  ProducerThread consumerThread;
  NewVehicles newVehiclesThread;

  @FXML
  void ChegadaVeiculos(ActionEvent event) {
    try{
      inputVelocity = Long.parseLong(textfield_ChegadaVeiculos.getText());
    } catch(Exception e){
      System.out.println("[ERROR]");
    } finally {
      System.out.println(inputVelocity);
    }
  }

  @FXML
  void button_DuracaoVeiculos(ActionEvent event) {
    try{
      outputVelocity = Long.parseLong(textfield_DuracaoVeiculos.getText());
    } catch(Exception e){
      System.out.println("[ERROR]");
    } finally {
      System.out.println(outputVelocity);
    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {    
    producerThread = new ConsumerThread(this);
    consumerThread = new ProducerThread(this);
    newVehiclesThread = new NewVehicles(this);
    
    run();
  }

  public AnchorPane getAnchorPane(){
    return anchorpanefather; // retorna o anchor pane pra poder adicionar os veiculos
  }

  public long getInputVelocity(){
    return inputVelocity;
  }

  public long getOutputVelocity(){
    return outputVelocity;
  }

  public Label getVeiculosNaFila(){
    return label_VeiculosNaFila;
  }

  /* ***************************************************************
* Metodo: run
* Funcao: Esta funcao inicia as threads
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  @Override
  public void run() {
    newVehiclesThread.start();
    consumerThread.start();
    producerThread.start();
  }
}
