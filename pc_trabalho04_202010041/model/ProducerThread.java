/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 07/04/2022
* Ultima alteracao.: 09/04/2022
* Nome.............: ProducerThread
* Funcao...........: Esta classe tem a funcao de criar a Thread Produtor.
                    Esta thread manipulara o objeto veiculo e fara com que
                    os veiculos entrem no Buffer (as vagas de estacionamento).
*************************************************************** */
package model;

import java.util.Queue;

import controller.MainController;
import javafx.application.Platform;
import utils.BufferManager;

public class ProducerThread extends Thread{

  private MainController control;
  public Queue<Vehicles> queue;
  private Vehicles car;

  public ProducerThread(MainController control){
    this.control = control;
    this.queue = BufferManager.queue;
  }

/* ***************************************************************
* Metodo: run
* Funcao: Esta funcao inicia a thread e implementa os semaforos
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void run(){
    int vacancy = 0;

    while(true){ 
      try {

        BufferManager.ableProducer.acquire();
          BufferManager.semaphoreEmpty.acquire();
          BufferManager.mutexBuffer.acquire();
          BufferManager.mutexQueue.acquire();
            car = BufferManager.queue.poll(); 
            vacancy = checkVacancy(); 
            BufferManager.buffer[vacancy] = car;
            BufferManager.nextToExit.add(vacancy);

              car.moveToSpace(vacancy);

          BufferManager.mutexQueue.release();

          BufferManager.mutexBuffer.release();
          BufferManager.semaphoreFull.release();

         Platform.runLater(() -> {
          control.getVeiculosNaFila().setText(String.valueOf(BufferManager.queue.size()));
        });
      } catch (Exception e) {
        System.out.println(e.getMessage()); 
      }
        
    }
  }

/* ***************************************************************
* Metodo: checkVacancy
* Funcao: Esta funcao retorna a vaga que esta vazia no buffer.
* Parametros: sem parametros
* Retorno: inteiro
*************************************************************** */
  public int checkVacancy(){
    for(int i = 0; i < 10; i++){
      if(BufferManager.buffer[i] == null){
        return i;
      }
    }
    return -1;
  }

}
