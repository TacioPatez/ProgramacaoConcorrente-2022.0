/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 27/03/2022
* Ultima alteracao.: 27/03/2022
* Nome.............: MainController
* Funcao...........: Manipula os objetos da Thread e implementa
                    alguns metodos das threads.
*************************************************************** */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import model.Train1Thread;
import model.Train2Thread;


public class MainController implements Initializable, Runnable {

  @FXML
  private ImageView imageView_Stop1;

  @FXML
  private ImageView imageView_Stop2;

  @FXML
  private ImageView imageView_Train1;

  @FXML
  private ImageView imageView_Train2;

  @FXML
  private Button button_PlusTrain1;

  @FXML
  private Button button_PlusTrain2;

  @FXML
  private Button button_MinusTrain1;

  @FXML
  private Button button_MinusTrain2;


  private boolean bridge = true; // ponte livre?
  private Train1Thread t1;
  private Train2Thread t2;

/* ***************************************************************
* Metodo: initialize
* Funcao: Esta Funcao instancia as threads e cria eventos.
* Parametros: padrao do java
* Retorno: sem retorno
*************************************************************** */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    t1 = new Train1Thread(this); // cria a Thread do trem 1
    t2 = new Train2Thread(this); // cria a Thread do trem 2
    run(); // instancia a funcao run 

    button_PlusTrain1.setOnMouseClicked(Event ->{
      t1.increaseVelocity(); // Evento - aumenta velocidade do trem 1
    });

    button_PlusTrain2.setOnMouseClicked(Event ->{
      t2.increaseVelocity(); // Evento - aumenta velocidade do trem 2
    });

    button_MinusTrain1.setOnMouseClicked(Event ->{
      t1.decreaseVelocity(); // Evento - diminui velocidade do trem 1
    });

    button_MinusTrain2.setOnMouseClicked(Event ->{
      t2.decreaseVelocity(); // Evento - diminui velocidade do trem 2
    });
  }

/* ***************************************************************
* Metodo: run
* Funcao: Esta Funcao executa as threads.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  @Override
  public void run(){
      t1.start();
      t2.start();
  }

  //gets n sets
  public ImageView getImageView_Stop1() {
    return imageView_Stop1;
  }

  public ImageView getImageView_Stop2() {
    return imageView_Stop2;
  }

  public ImageView getImageView_Train1() {
    return imageView_Train1;
  }

  public ImageView getImageView_Train2() {
    return imageView_Train2;
  }

  public boolean isBridge() {
    return bridge; // se a ponte esta livre
  }

  public void setBridge(boolean bridge) {
    this.bridge = bridge; // define se a ponte esta livre
  }

  public void setOpacityStop1(int number){
    Platform.runLater( () -> imageView_Stop1.setOpacity(number));
  }

  public void setOpacityStop2(int number){
    Platform.runLater( () -> imageView_Stop2.setOpacity(number));
  }

}
