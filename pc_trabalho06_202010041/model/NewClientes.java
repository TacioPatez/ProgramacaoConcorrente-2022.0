/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 07/04/2022
* Ultima alteracao.: 09/04/2022
* Nome.............: NewClients
* Funcao...........: Esta classe tem a funcao de criar a Thread New Clients.
                    Esta thread ira adicionar os clientes na fila de acordo com oq
                    foi determinado pelo usuario.
*************************************************************** */
package model;

import controller.MainController;
import javafx.application.Platform;

public class NewClientes extends Thread {
  private MainController control;
  private long tempoChegando = 10;
  private Cliente client;

  public NewClientes (MainController control){
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
      Platform.runLater(() -> {
        tempoChegando = control.getTempoChegando();
      });
      try {
        Thread.sleep(tempoChegando*1000);
        client = new Cliente(control);
        client.start();
      } catch (InterruptedException e) {}
    } 
  }
}
