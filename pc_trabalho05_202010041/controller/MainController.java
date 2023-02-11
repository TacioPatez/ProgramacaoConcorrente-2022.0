/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 20/04/2022
* Ultima alteracao.: 23/04/2022
* Nome.............: MainController
* Funcao...........: Este codigo tem a funcao de fazer a interacao entre
                    a interface grafica e os codigos, alem de atribuir
                    funcoes/eventos para os buttons, labels, sliders, etc.
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
import model.Filosofos;

public class MainController implements Initializable, Runnable{

  @FXML
  private Button button_AwayAction;

  @FXML
  private Button button_CJAction;

  @FXML
  private Button button_DileraAction;

  @FXML
  private Button button_JPAction;

  @FXML
  private Button button_PitonAction;

  @FXML
  private ImageView imageView_AwayEating;

  @FXML
  private ImageView imageView_AwayHungry;

  @FXML
  private ImageView imageView_AwayThinking;

  @FXML
  private ImageView imageView_CJEating;

  @FXML
  private ImageView imageView_CJHungry;

  @FXML
  private ImageView imageView_CJThinking;

  @FXML
  private ImageView imageView_DileraEating;

  @FXML
  private ImageView imageView_DileraHungry;

  @FXML
  private ImageView imageView_DileraThinking;

  @FXML
  private ImageView imageView_JPEating;

  @FXML
  private ImageView imageView_JPHungry;

  @FXML
  private ImageView imageView_JPThinking;

  @FXML
  private ImageView imageView_PitonEating;

  @FXML
  private ImageView imageView_PitonHungry;

  @FXML
  private ImageView imageView_PitonThinking;

  @FXML
  private Label label_Fila1;

  @FXML
  private Label label_Fila2;

  @FXML
  private Label label_Fila3;

  @FXML
  private Label label_Fila4;

  @FXML
  private TextField textfield_AwayComendo;

  @FXML
  private TextField textfield_AwayPensando;

  @FXML
  private TextField textfield_CJComendo;

  @FXML
  private TextField textfield_CJPensando;

  @FXML
  private TextField textfield_DileraComendo;

  @FXML
  private TextField textfield_DileraPensando;

  @FXML
  private TextField textfield_JPComendo;

  @FXML
  private TextField textfield_JPPensando;

  @FXML
  private TextField textfield_PitonComendo;

  @FXML
  private TextField textfield_PitonPensando;

  private Filosofos away;
  private Filosofos dilera;
  private Filosofos jp;
  private Filosofos cj;
  private Filosofos piton;

  @FXML
  void awayTime(ActionEvent event) {
    away.setTimeEating(Long.parseLong(textfield_AwayComendo.getText()));
    away.setTimeThinking(Long.parseLong(textfield_AwayPensando.getText()));
  }

  @FXML
  void cjTime(ActionEvent event) {
    cj.setTimeEating(Long.parseLong(textfield_CJComendo.getText()));
    cj.setTimeThinking(Long.parseLong(textfield_CJPensando.getText()));
  }

  @FXML
  void dileraTime(ActionEvent event) {
    dilera.setTimeEating(Long.parseLong(textfield_DileraComendo.getText()));
    dilera.setTimeThinking(Long.parseLong(textfield_DileraPensando.getText()));
  }

  @FXML
  void jpTime(ActionEvent event) {
    jp.setTimeEating(Long.parseLong(textfield_JPComendo.getText()));
    jp.setTimeThinking(Long.parseLong(textfield_JPPensando.getText()));
  }

  @FXML
  void pitonTime(ActionEvent event) {
    piton.setTimeEating(Long.parseLong(textfield_PitonComendo.getText()));
    piton.setTimeThinking(Long.parseLong(textfield_PitonPensando.getText()));
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    away = new Filosofos(this, "Away", imageView_AwayEating, imageView_AwayThinking,
                                  imageView_AwayHungry, 1);
    dilera = new Filosofos(this, "Dilera", imageView_DileraEating, imageView_DileraThinking,
                                  imageView_DileraHungry, 2);
    jp = new Filosofos(this, "Juao Paulo", imageView_JPEating, imageView_JPThinking,
                                  imageView_JPHungry, 3);
    cj = new Filosofos(this, "Carl Jhonson", imageView_CJEating, imageView_CJThinking,
                                  imageView_CJHungry, 4);
    piton = new Filosofos(this, "Piton", imageView_PitonEating, imageView_PitonThinking,
                                  imageView_PitonHungry, 5);
    run();
  }

/* ***************************************************************
* Metodo: run
* Funcao: Esta funcao inicia as threads
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void run(){
    away.start();
    dilera.start();
    jp.start();
    cj.start();
    piton.start();
  }

  // GETS N' SETS

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
