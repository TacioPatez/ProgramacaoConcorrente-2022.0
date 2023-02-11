/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 10/03/2022
* Ultima alteracao.: 10/03/2022
* Nome.............: Filho3Thread
* Funcao...........: Esta classe tem a funcao de criar o objeto Filho3
                    que cria uma nova Thread. Esta thread no GUI irá alterar
                    a idade do terceiro filho, manipular as imagens referentes ao mesmo e
                    instaciar novas Threads referente aos seus filhos.
*************************************************************** */

package model;

import java.math.BigDecimal;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Filho3Thread extends Thread {

    private ArrayList informations = new ArrayList();
    private ImageView foto = null;
    private Label nome;
    private TextField idade;
    private ImageView morto;
    private int age = 0;
    private ImageView linhaAntepacado = null;

    public Filho3Thread(ArrayList informations) { // atribui os objetos do ArrayList nas variaveis correspondentes.
        this.informations = informations;

        foto = (ImageView) informations.get(12);
        nome = (Label) informations.get(13);
        idade = (TextField) informations.get(14);
        morto = (ImageView) informations.get(15);
        linhaAntepacado = (ImageView) informations.get(29);

        Platform.runLater(() -> {
            linhaAntepacado.setOpacity(1);
            foto.setOpacity(1);
            nome.setOpacity(1);
            idade.setOpacity(1);
        });
    }

/* ***************************************************************
* Metodo: Run
* Funcao: Esta Funcao inicia a Thread Filho3, a cada 1 segundo, ela altera
        a idade de Filho3 por meio de uma estrutura de repetição.
        Ao fim da estrutura de repetoção, e indicado que ele morreu.
* Parametros: nenhum
* Retorno: sem retorno
*************************************************************** */
    public void run() {
        for (age = 0; age <= 55; age++) {
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
