/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 21/05/2022
* Ultima alteracao.: 21/05/2022
* Nome.............: GlobalVariables
* Funcao...........: Este codigo tem a funcao de fazer criar atributos
                    globais para que as threads possam manipular.
*************************************************************** */
package utils;

import java.util.concurrent.Semaphore;

public class GlobalVariables {
    public static Semaphore seatsMutex = new Semaphore(1);
    public static Semaphore queueMutex = new Semaphore(1);
    public static Semaphore hairCutting = new Semaphore(0);
    public static Semaphore goToSleep = new Semaphore(0);
    public static Semaphore goToWork = new Semaphore(0);

    public static Semaphore[][] cornersMutex = new Semaphore[6][6];
    public static Semaphore[][] latiMutex = new Semaphore[6][6];
    public static Semaphore[][] longMutex = new Semaphore[6][6];
    public static Semaphore[] specialMutex = new Semaphore[30];
}

