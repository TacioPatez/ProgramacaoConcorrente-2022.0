/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 01/05/2022
* Ultima alteracao.: 06/05/2022
* Nome.............: Barbeiro
* Funcao...........: Esta classe tem a funcao de criar o Objeto/Thread Barbeiro
                    Esta Thread modifica a posicao, para que o Barbeiro se 
                    mexa na tela, etc.
*************************************************************** */
package model;

import controller.MainController;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import utils.GlobalVariables;

public class Barbeiro extends Thread {
  private MainController control;
  private ImageView personagem = new ImageView();

  public Barbeiro(MainController control){
    this.control = control;
    startBarbeiro();
  }

/* ***************************************************************
* Metodo: run
* Funcao: Esta funcao inicia a thread e implementa os semaforos
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void run(){
    while(true){
      try {
        GlobalVariables.goToWork.acquire();
        moveToWork();

        GlobalVariables.goToSleep.acquire();
        moveToSleep();

      } catch (InterruptedException e) {}
    }
  }

/* ***************************************************************
* Metodo: startBarbeiro
* Funcao: Esta funcao deixa a imagem do barbeiro no ponto inicial.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void startBarbeiro(){
    AnchorPane ap = control.getAnchorPane();
    Image image = new Image("/img/barbeiro/dormindo.png");
    personagem.setImage(image);
    ap.getChildren().add(personagem);
    personagem.setX(200.0);
    personagem.setY(335.0);
  }

/* ***************************************************************
* Metodo: moveToWork
* Funcao: Esta funcao move a imagem do barbeiro para de tras da
        poltrona.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void moveToWork(){
    setPersonagemRotation("frente");
    
    for(Double i = personagem.getY(); i <= 400.0; i++){
      final Double y = i;
      Platform.runLater(() -> {
        personagem.setY(y);
      });

      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {}
    }

    setPersonagemRotation("esquerda");

    for(Double i = personagem.getX(); i >= 75.0; i--){
      final Double x = i;
      Platform.runLater(() -> {
        personagem.setX(x);
      });

      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {}
    }

    setPersonagemRotation("maquina");
  }

/* ***************************************************************
* Metodo: moveToSleep
* Funcao: Esta funcao move a imagem do barbeiro para a cadeira.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void moveToSleep(){
    setPersonagemRotation("direita");

    for(Double i = 75.0 ; i <= 200.0; i++){
      final Double x = i;
      Platform.runLater(() -> {
        personagem.setX(x);
      });

      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {}
    }

    setPersonagemRotation("costa");

    for(Double i = 400.0; i >= 335.0; i--){
      final Double y = i;
      Platform.runLater(() -> {
        personagem.setY(y);
      });

      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {}
    }

    setPersonagemRotation("dormindo");
  }

/* ***************************************************************
* Metodo: setPersonagemRotation
* Funcao: Esta funcao modifica a imagem.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void setPersonagemRotation(String rotate){
    Image image = new Image("/img/barbeiro/"+rotate+".png");
    Platform.runLater(() -> {
    personagem.setImage(image);
    });
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e1) {}
  }

  public ImageView getImageViewBarbeiro(){
    return personagem;
  }
}
