/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 10/03/2022
* Ultima alteracao.: 10/03/2022
* Nome.............: PaiThread
* Funcao...........: Esta classe tem a funcao de criar o objeto Pai
                    que cria uma nova Thread. Esta thread no GUI irá alterar
                    a idade do pai, manipular as imagens referentes ao mesmo e
                    instaciar novas Threads referente aos seus filhos.
*************************************************************** */

package model;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class PaiThread extends Thread{
        
  private ArrayList informations = new ArrayList();
  private ImageView foto = null;
  private Label nome;
  private TextField idade;
  private ImageView morto;
  private int age;

  //Construtor
  public PaiThread(ArrayList informations){
    this.informations = informations;
        
    Platform.runLater(() -> { // atribui os objetos do ArrayList nas variaveis correspondentes.
      foto = (ImageView)informations.get(0);
      nome = (Label)informations.get(1);
      idade = (TextField)informations.get(2);
      morto = (ImageView)informations.get(3);
    }); 
  }

/* ***************************************************************
* Metodo: Run
* Funcao: Esta Funcao inicia a Thread Pai, a cada 1 segundo, ela altera
        a idade de Pai por meio de uma estrutura de repetição.
        A cada fim da estrutura de repetoção, e instanciado um filho ou
        e indicado que ele morreu.
* Parametros: nenhum
* Retorno: sem retorno
*************************************************************** */
  public void run(){
    for(age = 0; age < 22; age++){
      Platform.runLater(() -> {
        idade.setText(String.valueOf(age));
      });
      try{
        Thread.sleep(1000);
        }catch(InterruptedException e){}
      }

    Filho1Thread filho1 = new Filho1Thread(informations);
      filho1.start();

    for(; age < 25; age++){      
      Platform.runLater(() -> {
        idade.setText(String.valueOf(age));
      });
      try{
        Thread.sleep(1000);
      }catch(InterruptedException e){}
    }

    Filho2Thread filho2 = new Filho2Thread(informations);
      filho2.start();

    for(; age < 32; age++){     
      Platform.runLater(() -> {
        idade.setText(String.valueOf(age));
      }); 
      try{
        Thread.sleep(1000);
      }catch(InterruptedException e){}
    }

    Filho3Thread filho3 = new Filho3Thread(informations);
      filho3.start();

    for(; age <= 90; age++){      
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
