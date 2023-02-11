/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 21/04/2022
* Ultima alteracao.: 23/04/2022
* Nome.............: Filosofos
* Funcao...........: Esta classe tem a funcao de criar a Thread/objeto Filosofos.
                    Esta thread manipulara a si proprio e fara com que
                    os filosofos seus estados para pensando, comendo ou com fome.
*************************************************************** */
package model;

import java.util.concurrent.Semaphore;

import controller.MainController;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import utils.GlobalVariables;

public class Filosofos extends Thread{
  protected Semaphore goEat = new Semaphore(0);
  private MainController control;
  private String philosopherName;
  private long timeThinking = 10;
  private long timeEating = 10;
  private int isUsingLeftFork;
  private int isUsingRightFork;
  //////////////////////////// images
  private ImageView eating;
  private ImageView thinking;
  private ImageView hungry;


  public Filosofos(MainController control, String philosopherName, ImageView eating,
                   ImageView thinking, ImageView hungry, int id){

    this.control = control;
    this.philosopherName = philosopherName;
    this.isUsingLeftFork = (id-1)%GlobalVariables.FORKS_NUMBER;
    this.isUsingRightFork = id%GlobalVariables.FORKS_NUMBER;
    this.eating = eating;
    this.thinking = thinking;
    this.hungry = hungry;
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
        Thread.sleep(timeThinking*1000);

        GlobalVariables.queueMutex.acquire();
        toHungry();
        refreshWaitingQueue();
        giveFoodToPhilosopher();
        GlobalVariables.queueMutex.release();

        goEat.acquire(); // pode comer?
        Platform.runLater(() -> {
          hungry.setVisible(false);
          eating.setVisible(true);
        });
        
        Thread.sleep(timeEating*1000); //comendo

        Platform.runLater(() -> {
          eating.setVisible(false);
          thinking.setVisible(true);
        });

        setUsingLeftFork(false);
        setUsingRightFork(false);

        GlobalVariables.queueMutex.acquire();
        giveFoodToPhilosopher();
        GlobalVariables.queueMutex.release();

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

/* ***************************************************************
* Metodo: toHungry
* Funcao: Esta funcao faz com que o filosofo fique no estado de 
        com fome e fique na fila(ArrayList) para comer.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void toHungry(){
    Platform.runLater(() -> {
      thinking.setVisible(false);
      hungry.setVisible(true);
    });

    GlobalVariables.queue.add(this);
  }

/* ***************************************************************
* Metodo: refreshWaitingQueue
* Funcao: Esta funcao faz com que a fila seja atualizada na
         interface grafica.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void refreshWaitingQueue(){
    Platform.runLater(() -> {
      
      try{
        control.setLabel_Fila1(GlobalVariables.queue.get(0).getPhilosopherName()); 
      } catch(Exception e){
        control.setLabel_Fila1("");
      }

      try{
        control.setLabel_Fila2(GlobalVariables.queue.get(1).getPhilosopherName()); 
      } catch(Exception e){
        control.setLabel_Fila2("");
      }

      try{
        control.setLabel_Fila3(GlobalVariables.queue.get(2).getPhilosopherName()); 
      } catch(Exception e){
        control.setLabel_Fila3("");
      }

      try{
        control.setLabel_Fila4(GlobalVariables.queue.get(3).getPhilosopherName()); 
      } catch(Exception e){
        control.setLabel_Fila4("");
      }
    });
  }

/* ***************************************************************
* Metodo: giveFoodToPhilosopher
* Funcao: Esta funcao le a "fila" do primeiro ao utilmo e faz 
        com que o filosofo que atenda aos requisitos saia do 
        estado de com fome e saia da fila para comer.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void giveFoodToPhilosopher(){ 
    for(int i = 0; i<GlobalVariables.queue.size(); i++){
      if(!(GlobalVariables.queue.get(i).isUsingLeftFork() ||  GlobalVariables.queue.get(i).isUsingRightFork())){
        GlobalVariables.queue.get(i).setUsingLeftFork(true);
        GlobalVariables.queue.get(i).setUsingRightFork(true);
        GlobalVariables.queue.get(i).getSemaphore().release();
        GlobalVariables.queue.remove(i);
        refreshWaitingQueue();
        giveFoodToPhilosopher(); // recursividade para nao dar index out of bound
        break;
      }
    }
  }

  //Gets N' Sets
  public String getPhilosopherName() {
    return philosopherName;
  }

  public long getTimeThinking() {
    return timeThinking;
  }

  public void setTimeThinking(long timeThinking) {
    if(timeThinking<=0){
    }else{
      this.timeThinking = timeThinking;
    }
    
  }

  public long getTimeEating() {
    return timeEating;
  }

  public void setTimeEating(long timeEating) {
    if(timeEating<=0){
    }else{
      this.timeEating = timeEating;
    }
  }

  public boolean isUsingLeftFork() {
    return GlobalVariables.forks[this.isUsingLeftFork];
  }

  public void setUsingLeftFork(boolean isUsingLeftFork) {
    GlobalVariables.forks[this.isUsingLeftFork] = isUsingLeftFork;
  }

  public boolean isUsingRightFork() {
    return GlobalVariables.forks[this.isUsingRightFork];
  }

  public void setUsingRightFork(boolean isUsingRightFork) {
    GlobalVariables.forks[this.isUsingRightFork] = isUsingRightFork;
  }  

  public Semaphore getSemaphore(){
    return goEat;
  }
}
