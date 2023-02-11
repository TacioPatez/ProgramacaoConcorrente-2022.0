/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 22/04/2022
* Ultima alteracao.: 22/04/2022
* Nome.............: GlobalVariables
* Funcao...........: Este codigo tem a funcao de criar atributos
                    globais para que as threads possam manipular.
*************************************************************** */
package utils;

import model.Filosofos;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class GlobalVariables {
    public static final int FORKS_NUMBER = 5;  
    public static ArrayList<Filosofos> queue = new ArrayList<Filosofos>();
    public static boolean[] forks = new boolean[FORKS_NUMBER];
    public static Semaphore queueMutex = new Semaphore(1);
}
