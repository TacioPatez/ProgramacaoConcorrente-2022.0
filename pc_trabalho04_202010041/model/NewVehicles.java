/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 07/04/2022
* Ultima alteracao.: 09/04/2022
* Nome.............: NewVehicles
* Funcao...........: Esta classe tem a funcao de criar a Thread New Vehicles.
                    Esta thread ira adicionar veiculos na fila de acordo com oq
                    foi determinado pelo usuario.
*************************************************************** */
package model;

import java.util.Queue;

import controller.MainController;
import javafx.application.Platform;
import utils.BufferManager;

public class NewVehicles extends Thread {
  private MainController control;
  private long inputVelocity;
  protected Queue<Vehicles> queue;
  private Vehicles car;

  public NewVehicles(MainController control){
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
  while(true){
    Platform.runLater(() -> {
      inputVelocity = control.getInputVelocity();
    });
    try {
      Thread.sleep(inputVelocity*1000);
      car = new Vehicles(control);
      BufferManager.mutexQueue.acquire();
      BufferManager.queue.add(car);
      BufferManager.ableProducer.release();
      BufferManager.mutexQueue.release();
      Platform.runLater(() -> {
        control.getVeiculosNaFila().setText(String.valueOf(BufferManager.queue.size()));
      });
    } catch (InterruptedException e) {}


  }
  }
}
