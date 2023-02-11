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
import java.util.concurrent.Semaphore;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Car10;
import model.Car12;
import model.Car16;
import model.Car2;
import model.Car22;
import model.Car6;
import model.Car7;
import utils.GlobalVariables;

public class MainController implements Initializable, Runnable{
  
  @FXML
  private AnchorPane anchorPane_Background;

  @FXML
  private ImageView button_C10Velocity;

  @FXML
  private ImageView button_C12Velocity;

  @FXML
  private ImageView button_C16Velocity;

  @FXML
  private ImageView button_C22Velocity;

  @FXML
  private ImageView button_C2Velocity;

  @FXML
  private ImageView button_C6Velocity;

  @FXML
  private ImageView button_C7Velocity;

  @FXML
  private TextField textfield_C10Velocity;

  @FXML
  private TextField textfield_C12Velocity;

  @FXML
  private TextField textfield_C16Velocity;

  @FXML
  private TextField textfield_C22Velocity;

  @FXML
  private TextField textfield_C2Velocity;

  @FXML
  private TextField textfield_C6Velocity;

  @FXML
  private TextField textfield_C7Velocity;

  Car2 carro2;
  Car6 carro6;
  Car7 carro7;
  Car10 carro10;
  Car12 carro12;
  Car16 carro16;
  Car22 carro22;

  int c2Velocity = 1;
  int c6Velocity = 1;
  int c7Velocity = 1;
  int c10Velocity = 1;
  int c12Velocity = 1;
  int c16Velocity = 1;
  int c22Velocity = 1;

  /* ***************************************************************
* Metodo: changeVelocity
* Funcao: Esta funcao muda a velocidade dos carros
* Parametros: parametro padrao do java
* Retorno: sem retorno
*************************************************************** */
  @FXML
  void changeVelocity(MouseEvent event) {
    try{
      int c2 = Integer.parseInt(textfield_C2Velocity.getText());
      if(c2 > 0 && c2 <=100){
        c2Velocity = 101-c2;
        carro2.setCarVelocity(c2Velocity);
        System.out.println("OK - " + c2Velocity);
      }
    } catch(Exception e){
      System.out.println("Numero Invalido!");
    }

    try{
      int c6 = Integer.parseInt(textfield_C6Velocity.getText());
      if(c6 > 0 && c6 <=100){
        c6Velocity = 101-c6;
        carro6.setCarVelocity(c6Velocity);
        System.out.println("OK - " + c6Velocity);
      }
    } catch(Exception e){
      System.out.println("Numero Invalido!");
    }

    try{
      int c7 = Integer.parseInt(textfield_C7Velocity.getText());
      if(c7 > 0 && c7 <=100){
        c7Velocity = 101-c7;
        carro7.setCarVelocity(c7Velocity);
        System.out.println("OK - " + c7Velocity);
      }
    } catch(Exception e){
      System.out.println("Numero Invalido!");
    }

    try{
      int c10 = Integer.parseInt(textfield_C10Velocity.getText());
      if(c10 > 0 && c10 <=100){
        c10Velocity = 101-c10;
        carro10.setCarVelocity(c10Velocity);
        System.out.println("OK - " + c10Velocity);
      }
    } catch(Exception e){
      System.out.println("Numero Invalido!");
    }

    try{
      int c12 = Integer.parseInt(textfield_C12Velocity.getText());
      if(c12 > 0 && c12 <=100){
        c12Velocity = 101-c12;
        carro12.setCarVelocity(c12Velocity);
        System.out.println("OK - " + c12Velocity);
      }
    } catch(Exception e){
      System.out.println("Numero Invalido!");
    }

    try{
      int c16 = Integer.parseInt(textfield_C16Velocity.getText());
      if(c16 > 0 && c16 <=100){
        c16Velocity = 101-c16;
        carro16.setCarVelocity(c16Velocity);
        System.out.println("OK - " + c16Velocity);
      }
    } catch(Exception e){
      System.out.println("Numero Invalido!");
    }

    try{
      int c22 = Integer.parseInt(textfield_C22Velocity.getText());
      if(c22 > 0 && c22 <=100){
        c22Velocity = 101-c22;
        carro22.setCarVelocity(c22Velocity);
        System.out.println("OK - " + c22Velocity);
      }
    } catch(Exception e){
      System.out.println("Numero Invalido!");
    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    startsSemaphores();
    carro2 = new Car2(this);
    carro6 = new Car6(this);
    carro7 = new Car7(this);
    carro10 = new Car10(this);
    carro12 = new Car12(this);
    carro16 = new Car16(this);
    carro22 = new Car22(this);
    run();
  }

/* ***************************************************************
* Metodo: run
* Funcao: Esta funcao inicia a thread e implementa os semaforos
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  @Override
  public void run() {
    carro2.start();
    carro6.start();
    carro7.start();
    carro10.start();
    carro12.start();
    carro16.start();
    carro22.start();
  }

/* ***************************************************************
* Metodo: startsSemaphores
* Funcao: Esta funcao instancia os semaforos
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void startsSemaphores(){
    for(int i = 0; i<6; i++){
      for(int j = 0; j<6; j++){
        GlobalVariables.cornersMutex[i][j] = new Semaphore(1);
        GlobalVariables.latiMutex[i][j] = new Semaphore(1);
        GlobalVariables.longMutex[i][j] = new Semaphore(1);
      }
    }

    for(int k = 0; k < 30; k++){
      GlobalVariables.specialMutex[k] = new Semaphore(1);
    }
  }

  //GETS N SETS
  public AnchorPane getAnchorPane() {
    return anchorPane_Background;
  }

}
