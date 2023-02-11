/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 10/03/2022
* Ultima alteracao.: 10/03/2022
* Nome.............: Nteo2Thread
* Funcao...........: Esta classe tem a funcao de criar o objeto Neto2
                    que cria uma nova Thread. Esta thread no GUI irá alterar
                    a idade do filho do segundo filho e manipular as imagens 
                    referentes ao mesmo.
*************************************************************** */

package model;

import java.math.BigDecimal;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class Neto2Thread extends Thread{
        
    private ArrayList informations = new ArrayList();
    private ImageView foto = null;
    private Label nome;
    private TextField idade;
    private ImageView morto;
    private int age = 0;
    private ImageView linhaAntepacado = null;

    public Neto2Thread(ArrayList informations){ // atribui os objetos do ArrayList nas variaveis correspondentes.
        this.informations = informations;
        
        foto = (ImageView)informations.get(20);
        nome = (Label)informations.get(21);
        idade = (TextField)informations.get(22);
        morto = (ImageView)informations.get(23);
        linhaAntepacado = (ImageView)informations.get(31);
      
        Platform.runLater(() -> {
            linhaAntepacado.setOpacity(1);
            foto.setOpacity(1);
            nome.setOpacity(1);
            idade.setOpacity(1);
        });
    }
/* ***************************************************************
* Metodo: Run
* Funcao: Esta Funcao inicia a Thread Neto2, a cada 1 segundo, ela altera
        a idade de Neto2 por meio de uma estrutura de repetição.
        Ao fim da estrutura de repetoção, e indicado que ele morreu.
* Parametros: nenhum
* Retorno: sem retorno
*************************************************************** */
    public void run(){
        for(age = 0; age <= 33; age++){           
            Platform.runLater(() -> {
                idade.setText(String.valueOf(age));
            });  
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}
        }

        Platform.runLater(() -> {
            morto.setOpacity(1);
        });
        



    }
}
