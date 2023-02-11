/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 01/05/2022
* Ultima alteracao.: 06/05/2022
* Nome.............: Corte
* Funcao...........: Esta classe tem a funcao de criar a Thread Corte.
                    Esta thread manipulara o objeto cliente e fara com que
                    os clientes sentem na poltrona para cortar o cabelo.
*************************************************************** */
package model;

import java.util.concurrent.Semaphore;

import controller.MainController;
import utils.GlobalVariables;

public class Corte extends Thread{
  private MainController control;
  protected static Semaphore startCutting = new Semaphore(0);

  public Corte (MainController control){
    this.control = control;
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
        GlobalVariables.hairCutting.acquire();
          GlobalVariables.queueMutex.acquire();
            GlobalVariables.queue.get(0).myTurn.release();
          GlobalVariables.queueMutex.release();
            startCutting.acquire();
              Thread.sleep(control.getTempoCortando()*1000);
          GlobalVariables.queueMutex.acquire();
            GlobalVariables.queue.remove(0);
            refreshSemaphores();
          GlobalVariables.queueMutex.release();
          
      } catch (InterruptedException e) {}
    }
  }

/* ***************************************************************
* Metodo: refreshSemaphores
* Funcao: Esta funcao atualiza os semaforos liberando-os caso 
        caso necessario.
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public static void refreshSemaphores(){
    if(GlobalVariables.queue.size() > 0 && GlobalVariables.goToWork.availablePermits() == 0){
      GlobalVariables.goToWork.release();
    } 
    if(GlobalVariables.queue.size() == 0 && GlobalVariables.goToSleep.availablePermits() == 0){
      GlobalVariables.goToSleep.release();
    }
  }
}
