/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 07/04/2022
* Ultima alteracao.: 09/04/2022
* Nome.............: ConsumerThread
* Funcao...........: Esta classe tem a funcao de criar a Thread Consumidor.
                    Esta thread manipulara o objeto veiculo e fara com que
                    os veiculos saiam do Buffer (as vagas de estacionamento).
*************************************************************** */
package model;

import controller.MainController;
import javafx.application.Platform;
import utils.BufferManager;

public class ConsumerThread extends Thread{

  private MainController control;
  private long outputVelocity;

  public ConsumerThread(MainController control){ // 13s pra chegar na vaga
    this.control = control;
  }

/* ***************************************************************
* Metodo: run
* Funcao: Esta funcao inicia a thread e implementa os semaforos
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void run(){
    int toExit;
    while(true){
      Platform.runLater(() -> {
        outputVelocity = control.getOutputVelocity();
      });
      try {
        Thread.sleep(outputVelocity*1000);
      } catch (InterruptedException e) {}

      try {
        BufferManager.semaphoreFull.acquire();
        BufferManager.mutexBuffer.acquire();
        toExit = BufferManager.nextToExit.poll();
        Vehicles car = (Vehicles)BufferManager.buffer[toExit];
        BufferManager.buffer[toExit] = null;
        BufferManager.mutexBuffer.release();
        BufferManager.semaphoreEmpty.release();
        car.removeCarOnScene();
      } catch (Exception e) {
        System.out.println(e.getMessage()); 
      }
    }
  }
}