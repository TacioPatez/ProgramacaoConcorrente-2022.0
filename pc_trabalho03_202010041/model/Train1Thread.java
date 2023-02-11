/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 27/03/2022
* Ultima alteracao.: 27/03/2022
* Nome.............: Train1Thread
* Funcao...........: Esta classe tem a funcao de criar a Thread do trem1
                    Esta thread manipulara as imagens referentes ao trem1,
                    aplicando a exclusão mutua, modificando a velocidade 
                    com que o trem se mexe na tela, etc.
*************************************************************** */
package model;

import controller.MainController;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class Train1Thread extends Thread{
  private MainController control;
  private int speed;
  private int pX; // posicao X
  private int pY; //posicao Y
  private ImageView train;

  public Train1Thread(MainController control){
    this.control = control;
    this.train = control.getImageView_Train1();
    this.speed = 1;
  }

/* ***************************************************************
* Metodo: run
* Funcao: Esta funcao inicia a thread e implementa a exclusao mutua
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void run(){
    
    while(true){
      pX=0; // posicao inicial
      pY=0; // posicao inicial
      Platform.runLater( () -> train.setX(pX));
      Platform.runLater( () -> train.setY(pY));

    moveXtoRight(200);
    rotate(180);
    moveYtoDown(80);
    //Inicio Regiao Critica
    bridgeVerify();
    control.setBridge(false);
    control.setOpacityStop2(1);
    moveYtoDown(150);
    rotate(90);
    moveXtoRight(500);
    rotate(0);
    moveYtoUp(0);
    rotate(90);
    //Fim Regiao Critica
    control.setBridge(true);
    control.setOpacityStop2(0);
    moveXtoRight(800);
    }  
  }

/* ***************************************************************
* Metodo: moveXtoRight
* Funcao: faz o trem sem mover para a direita.
* Parametros: ponto de parada na coordenada x.
* Retorno: sem retorno
*************************************************************** */
  public void moveXtoRight(int stopX){
    while(pX != stopX){
      try {
        Thread.sleep(speed);
      } catch (InterruptedException e) {}
      
      pX++;
      Platform.runLater( () -> train.setX(pX));
    }
  }

/* ***************************************************************
* Metodo: moveYtoDown
* Funcao: faz o trem sem mover para baixo
* Parametros: ponto de parada na coordenada y.
* Retorno: sem retorno
*************************************************************** */
  public void moveYtoDown(int stopY){
    while(pY != stopY){
      try {
        Thread.sleep(speed);
      } catch (InterruptedException e) {}
      
      pY++;
      Platform.runLater( () -> train.setY(pY));
    }
  }

/* ***************************************************************
* Metodo: moveYtoUp
* Funcao: faz o trem sem mover para cima
* Parametros: ponto de parada na coordenada y.
* Retorno: sem retorno
*************************************************************** */
  public void moveYtoUp(int stopY){
    while(pY != stopY){
      try {
        Thread.sleep(speed);
      } catch (InterruptedException e) {}
      
      pY--;
      Platform.runLater( () -> train.setY(pY));
    }
  }

/* ***************************************************************
* Metodo: rotate
* Funcao: faz o trem rotacionar
* Parametros: angulo da imagem
* Retorno: sem retorno
*************************************************************** */  
  public void rotate(int number){
    Platform.runLater( () -> train.setRotate(number));
  }

/* ***************************************************************
* Metodo: bridgeVerify
* Funcao: verifica se o trem pode usar a ponte
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void bridgeVerify(){
    while(control.isBridge() == false){
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {}
    }
  }

/* ***************************************************************
* Metodo: increaseVelocity
* Funcao: aumenta a velocidade do trem
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void increaseVelocity(){
    if(speed > 5){
      speed -= 5;
    }
  }

/* ***************************************************************
* Metodo: decreaseVelocity
* Funcao: diminui a velocidade do trem
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void decreaseVelocity(){
    if(speed <= 45){
      speed += 5;
    }
  }
}