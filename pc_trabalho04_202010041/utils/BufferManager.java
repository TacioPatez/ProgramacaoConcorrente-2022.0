/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 07/04/2022
* Ultima alteracao.: 09/04/2022
* Nome.............: BufferManager
* Funcao...........: Este codigo tem a funcao de fazer criar atributos
                    globais para que as threads possam manipular.
*************************************************************** */
package utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

import model.Vehicles;

public class BufferManager {
  private static final int BUFFER_SIZE = 10;  
  public static Semaphore semaphoreEmpty = new Semaphore(BUFFER_SIZE);
  public static Semaphore semaphoreFull = new Semaphore(0);
  public static Semaphore mutexBuffer = new Semaphore(1);
  public static Queue<Vehicles> queue = new LinkedList<Vehicles>();
  public static Semaphore mutexQueue = new Semaphore(1);
  public static Semaphore ableProducer = new Semaphore(0);
  public static Queue<Integer> nextToExit = new LinkedList<Integer>();
  public static Object[] buffer = new Object[BUFFER_SIZE];


}
