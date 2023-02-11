/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 01/05/2022
* Ultima alteracao.: 06/05/2022
* Nome.............: GlobalVariables
* Funcao...........: Este codigo tem a funcao de fazer criar atributos
                    globais para que as threads possam manipular.
*************************************************************** */
package utils;

import model.Cliente;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class GlobalVariables {
    public static final int SEATS_NUMBER = 4;  
    public static ArrayList<Cliente> queue = new ArrayList<Cliente>();
    public static boolean[] seats = new boolean[SEATS_NUMBER];
    public static Semaphore seatsMutex = new Semaphore(1);
    public static Semaphore queueMutex = new Semaphore(1);
    public static Semaphore hairCutting = new Semaphore(0);
    public static Semaphore goToSleep = new Semaphore(0);
    public static Semaphore goToWork = new Semaphore(0);
}

