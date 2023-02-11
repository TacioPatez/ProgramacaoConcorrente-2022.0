/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 01/05/2022
* Ultima alteracao.: 06/05/2022
* Nome.............: Cliente
* Funcao...........: Esta classe tem a funcao de criar o Objeto/Thread Cliente
                    Esta Thread modifica a posicao, para que o Cliente se 
                    mexa na tela, etc.
*************************************************************** */
package model;

import java.util.Random;
import java.util.concurrent.Semaphore;

import controller.MainController;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import utils.GlobalVariables;

public class Cliente extends Thread {
  private MainController control;
  private int tipoCliente;
  private String name;
  private ImageView personagem = new ImageView();
  private ImageView texto = new ImageView();
  private ImageView textoBarbeiro = new ImageView();
  protected Semaphore myTurn = new Semaphore(0);

  public Cliente(MainController control){
    this.control = control;
  }

/* ***************************************************************
* Metodo: run
* Funcao: Esta funcao inicia a thread e implementa os semaforos
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void run(){
    int vacancy = -1;
    getTipoCliente();
    setPersonagem();
    putPersonagemOnScene();

    moveToInside();

    try {
      Thread.sleep(500);
      GlobalVariables.seatsMutex.acquire();
      vacancy = checkVacancy();
      GlobalVariables.seatsMutex.release();
    } catch (InterruptedException e) {}

    if(vacancy != -1){
      try {
        GlobalVariables.seatsMutex.acquire();
          GlobalVariables.seats[vacancy] = true;
        GlobalVariables.seatsMutex.release();
      } catch (InterruptedException e1) {}

      setMessagemCliente('p');
      setMessagemBarbeiro('s');
      removeMessageCliente();
      removeMessageBarbeiro();

      moveToSeat(vacancy);
      goToSitOnSeat();
      try {
          GlobalVariables.queueMutex.acquire();
            GlobalVariables.queue.add(this);
            GlobalVariables.hairCutting.release();
            refreshWaitingQueue();
            Corte.refreshSemaphores();
          GlobalVariables.queueMutex.release();

        myTurn.acquire();

        GlobalVariables.seatsMutex.acquire();
        GlobalVariables.queueMutex.acquire();
          GlobalVariables.seats[vacancy] = false;
          refreshWaitingQueue();
        GlobalVariables.queueMutex.release();
        GlobalVariables.seatsMutex.release();
        setMessagemBarbeiro('p');
        removeMessageBarbeiro();
        moveToCouch();
        Corte.startCutting.release();
        Thread.sleep(control.getTempoCortando()*1000);
        moveOutCouch();
      } catch (InterruptedException e) {}

    } else {
      setMessagemCliente('p');
      setMessagemBarbeiro('n');
      removeMessageCliente();
      removeMessageBarbeiro();
      setMessagemCliente('r');
      removeMessageCliente();
    }

    moveToOutside();
    removePersonagemOnScene();
    refreshWaitingQueue();

  }

/* ***************************************************************
* Metodo: setMessagemBarbeiro
* Funcao: Esta funcao cria uma imagem de texto acima da cabeca do
        personagem.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void setMessagemBarbeiro(char message) {
    AnchorPane ap = control.getAnchorPane();
    Image image;
    switch(message){
      case 's':
        image = new Image("/img/barbeiro/Sim.png");
        Platform.runLater(() -> {
          textoBarbeiro.setImage(image);
          ap.getChildren().add(textoBarbeiro);
          textoBarbeiro.setX(control.getImageBarbeiro().getX()-100.0);
          textoBarbeiro.setY(control.getImageBarbeiro().getY()-50.0);
        });
      break;
      case 'n':
        image = new Image("/img/barbeiro/Nao.png");
        Platform.runLater(() -> {
          textoBarbeiro.setImage(image);
          ap.getChildren().add(textoBarbeiro);
          textoBarbeiro.setX(control.getImageBarbeiro().getX()-100.0);
          textoBarbeiro.setY(control.getImageBarbeiro().getY()-50.0);
        });
      break;
      case 'p':
        image = new Image("/img/barbeiro/Proximo.png");
        Platform.runLater(() -> {
          textoBarbeiro.setImage(image);
          ap.getChildren().add(textoBarbeiro);
          textoBarbeiro.setX(control.getImageBarbeiro().getX()-100.0);
          textoBarbeiro.setY(control.getImageBarbeiro().getY()-50.0);
        });
      break;
    }
    
  }

/* ***************************************************************
* Metodo: removeMessageBarbeiro
* Funcao: Esta funcao retira a imagem de texto acima da cabeca do
        personagem.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void removeMessageBarbeiro(){
    AnchorPane ap = control.getAnchorPane();
    try {
      sleep(2000);
    } catch (InterruptedException e) {}
    Platform.runLater(() -> {
      ap.getChildren().remove(textoBarbeiro);
    });
  }

/* ***************************************************************
* Metodo: setMessagemBarbeiro
* Funcao: Esta funcao cria uma imagem de texto acima da cabeca do
        personagem.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void setMessagemCliente(char message) {
    AnchorPane ap = control.getAnchorPane();
    Image imageCliente;
    switch(message){
      case 'p':
        imageCliente = new Image("/img/personagem"+tipoCliente+"/pergunta.png");
        Platform.runLater(() -> {
          texto.setImage(imageCliente);
          ap.getChildren().add(texto);
          texto.setX(personagem.getX()-215.0);
          texto.setY(personagem.getY()-50.0);
        });
      break;
      case 'r':
        imageCliente = new Image("/img/personagem"+tipoCliente+"/resposta.png");
        Platform.runLater(() -> {
          texto.setImage(imageCliente);
          ap.getChildren().add(texto);
          texto.setX(personagem.getX()-215.0);
          texto.setY(personagem.getY()-50.0);
      });
      break;
      }
  }

/* ***************************************************************
* Metodo: removeMessageCliente
* Funcao: Esta funcao cria uma imagem de texto acima da cabeca do
        personagem.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void removeMessageCliente(){
    AnchorPane ap = control.getAnchorPane();
    try {
      sleep(2000);
    } catch (InterruptedException e) {}
    Platform.runLater(() -> {
      ap.getChildren().remove(texto);
    });
  }

/* ***************************************************************
* Metodo: getTipoCliente
* Funcao: Esta funcao seleciona um personagem aleatorio para ser
          criado.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void getTipoCliente(){
    Random r = new Random();
    this.tipoCliente = (r.nextInt(5))+1;

    switch (tipoCliente){
      case 1:
        name = "MATEUS";
      break;
      case 2:
        name = "ELVIX";
      break;
      case 3:
        name = "GEORGE";
      break;
      case 4:
        name = "JORGE";
      break;
      case 5:
        name = "MARCOS";
      break;
      default:
        name = "NULL";
    }
  }

/* ***************************************************************
* Metodo: setPersonagem
* Funcao: Esta funcao seleciona uma imagem ao ImageView
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void setPersonagem(){
    Image image = new Image("/img/personagem"+tipoCliente+"/esquerda.png"); 
    Platform.runLater(() -> {
      personagem.setImage(image);
    });
  }

/* ***************************************************************
* Metodo: setPersonagemRotation
* Funcao: Esta funcao modifica a imagem.
* Parametros: a direcao que se quer "rotacionar".
* Retorno: sem retorno
*************************************************************** */
  public void setPersonagemRotation(String rotate){
    Image image = new Image("/img/personagem"+tipoCliente+"/"+rotate+".png");
    Platform.runLater(() -> {
    personagem.setImage(image);
    });
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e1) {}
  }

/* ***************************************************************
* Metodo: putPersonagemOnScene
* Funcao: Esta funcao adiciona a imagem ao AnchorPane.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void putPersonagemOnScene(){
    AnchorPane ap = control.getAnchorPane();
    Platform.runLater(() -> {
      ap.getChildren().add(1, personagem);
      personagem.setX(670);
      personagem.setY(205);
    });
  }

/* ***************************************************************
* Metodo: removePersonagemOnScene
* Funcao: Esta funcao remove a imagem do AnchorPane.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void removePersonagemOnScene(){
    AnchorPane ap = control.getAnchorPane();
    Platform.runLater(() -> {
      ap.getChildren().remove(personagem);
    });
  }

/* ***************************************************************
* Metodo: moveToInside
* Funcao: Esta funcao move o personagem para dentro da barbearia.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void moveToInside(){
    for(Double i = 670.0; i >= 590.0; i--){ // ir ate a porta
      final Double x = i;
      Platform.runLater(() -> {
        personagem.setX(x);
      });

      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {}

    }

    setPersonagemRotation("frente");
    

    for(Double i = 205.0; i <= 400.0; i++){ // ir ate dentro da barbearia
      final Double y = i;
      Platform.runLater(() -> {
        personagem.setY(y);
      });

      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {}

    }

    setPersonagemRotation("esquerda");
  }

/* ***************************************************************
* Metodo: checkVacancy
* Funcao: Esta funcao verifica se ha cadeiras vazias.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public int checkVacancy() throws InterruptedException{
    for(int i = 0; i < 4; i++){
      if(GlobalVariables.seats[i] == false){
        return i;
      }
    }
    return -1;
  }

/* ***************************************************************
* Metodo: moveToOutside
* Funcao: Esta funcao move o personagem para fora da barbearia.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void moveToOutside(){
    setPersonagemRotation("costa");

    for(Double i = 400.0; i >= 205.0; i--){ // ir ate fora da barbearia
      final Double y = i;
      Platform.runLater(() -> {
        personagem.setY(y);
      });

      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {}

    }

    setPersonagemRotation("esquerda");

    for(Double i = 590.0; i >= -40.0; i--){ // ir embora
      final Double x = i;
      Platform.runLater(() -> {
        personagem.setX(x);
      });

      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {}

    }
  }

/* ***************************************************************
* Metodo: moveToSeat
* Funcao: Esta funcao move o personagem em direcao a cadeira.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void moveToSeat(int vacancy){
    switch(vacancy){
      case 3:
        for(Double i = personagem.getX(); i >= 200.0; i--){
          final Double x = i;
          Platform.runLater(() -> {
            personagem.setX(x);
          });

          try {
            Thread.sleep(20);
          } catch (InterruptedException e) {}
        }
      break;
      case 2:
        for(Double i = personagem.getX(); i >= 265.0; i--){
          final Double x = i;
          Platform.runLater(() -> {
            personagem.setX(x);
          });

          try {
            Thread.sleep(20);
          } catch (InterruptedException e) {}
        }
      break;
      case 1:
      for(Double i = personagem.getX(); i >= 385.0; i--){
        final Double x = i;
        Platform.runLater(() -> {
          personagem.setX(x);
        });

        try {
          Thread.sleep(20);
        } catch (InterruptedException e) {}
      }
      break;
      case 0:
      for(Double i = personagem.getX(); i >= 450.0; i--){
        final Double x = i;
        Platform.runLater(() -> {
          personagem.setX(x);
        });

        try {
          Thread.sleep(20);
        } catch (InterruptedException e) {}
      }
      break;
    }
  }

/* ***************************************************************
* Metodo: goToSitOnSeat
* Funcao: Esta funcao move o personagem para sentar na cadeira.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void goToSitOnSeat(){
    setPersonagemRotation("costa");

    for(Double i = personagem.getY(); i >= 360.0; i--){
      final Double y = i;
      Platform.runLater(() -> {
        personagem.setY(y);
      });

      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {}
    }

    try {
      sleep(1000);
    } catch (InterruptedException e) {}
      
      setPersonagemRotation("frente");

      Platform.runLater(() -> {
        personagem.setY(330);
      });

      try {
        sleep(2000);
      } catch (InterruptedException e) {}
  }

/* ***************************************************************
* Metodo: moveToCouch
* Funcao: Esta funcao move o personagem para sentar na poltrona.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void moveToCouch(){
    for(Double i = personagem.getY(); i <= 415.0; i++){
      final Double y = i;
      Platform.runLater(() -> {
        personagem.setY(y);
      });

      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {}
    }

    setPersonagemRotation("esquerda");

    for(Double i = personagem.getX(); i >= 15.0; i--){
      final Double x = i;
      Platform.runLater(() -> {
        personagem.setX(x);
      });

      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {}
    }
  }

/* ***************************************************************
* Metodo: moveOutCouch
* Funcao: Esta funcao move o personagem para sair da poltrona.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void moveOutCouch(){
    setPersonagemRotation("costa");

    for(Double i = personagem.getY(); i >= 400.0; i--){
      final Double y = i;
      Platform.runLater(() -> {
        personagem.setY(y);
      });

      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {}
    }

    setPersonagemRotation("direita");

    for(Double i = personagem.getX(); i <= 590.0; i++){
      final Double x = i;
      Platform.runLater(() -> {
        personagem.setX(x);
      });

      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {}
    }
  }

/* ***************************************************************
* Metodo: refreshWaitingQueue
* Funcao: Esta funcao atualiza a imagem da fila de espera.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void refreshWaitingQueue(){
    Platform.runLater(() -> {
      
      try{
        control.setLabel_Fila1(GlobalVariables.queue.get(0).getClientName()); 
      } catch(Exception e){
        control.setLabel_Fila1("");
      }

      try{
        control.setLabel_Fila2(GlobalVariables.queue.get(1).getClientName()); 
      } catch(Exception e){
        control.setLabel_Fila2("");
      }

      try{
        control.setLabel_Fila3(GlobalVariables.queue.get(2).getClientName()); 
      } catch(Exception e){
        control.setLabel_Fila3("");
      }

      try{
        control.setLabel_Fila4(GlobalVariables.queue.get(3).getClientName()); 
      } catch(Exception e){
        control.setLabel_Fila4("");
      }
    });
  }

  public String getClientName(){
    return name;
  }
}
