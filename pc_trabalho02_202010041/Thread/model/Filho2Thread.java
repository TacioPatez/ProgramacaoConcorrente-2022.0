/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 10/03/2022
* Ultima alteracao.: 10/03/2022
* Nome.............: Filho2Thread
* Funcao...........: Esta classe tem a funcao de criar o objeto Filho2
                    que cria uma nova Thread. Esta thread no GUI irá alterar
                    a idade do segundo filho, manipular as imagens referentes ao mesmo e
                    instaciar novas Threads referente aos seus filhos.
*************************************************************** */

package model;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Filho2Thread extends Thread {

    private ArrayList informations = new ArrayList();
    private ImageView foto = null;
    private Label nome;
    private TextField idade;
    private ImageView morto;
    private int age = 0;

    public Filho2Thread(ArrayList informations) { // atribui os objetos do ArrayList nas variaveis correspondentes.
        this.informations = informations;

        foto = (ImageView) informations.get(8);
        nome = (Label) informations.get(9);
        idade = (TextField) informations.get(10);
        morto = (ImageView) informations.get(11);

        Platform.runLater(() -> {
            foto.setOpacity(1);
            nome.setOpacity(1);
            idade.setOpacity(1);
        });
    }

/* ***************************************************************
* Metodo: Run
* Funcao: Esta Funcao inicia a Thread Filho2, a cada 1 segundo, ela altera
        a idade de Filho2 por meio de uma estrutura de repetição.
        A cada fim da estrutura de repetoção, e instanciado um filho ou
        e indicado que ele morreu.
* Parametros: nenhum
* Retorno: sem retorno
*************************************************************** */
    public void run() {
        for (age = 0; age < 20; age++) {
            Platform.runLater(() -> {
                idade.setText(String.valueOf(age));
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }

        Neto2Thread neto2 = new Neto2Thread(informations);
        neto2.start();

        for (; age <= 55; age++) {
            Platform.runLater(() -> {
                idade.setText(String.valueOf(age));
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }

        Platform.runLater(() -> {
            morto.setOpacity(1);
        });
    }
}
