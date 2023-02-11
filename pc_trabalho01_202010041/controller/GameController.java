/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 03/01/2022
* Ultima alteracao.: 01/02/2022
* Nome.............: GameController
* Funcao...........: Este codigo tem a funcao de selecionar um objeto
                    Atom aleatoriamente.
*************************************************************** */

package controller;

import model.Atom;

import java.util.Random;

public class GameController {

//CONSTRUTOR
  public GameController() {
  }

  AtomData ad = new AtomData();

/* ***************************************************************
* Metodo: randomAtom
* Funcao: ele utiliza o metodo 'listarAtomos' da classe AtomData
          que retorna um array list com os objetos Atom, com este
          array list, a funcao seleciona um de maneira aleatoria.
* Parametros: nenhum
* Retorno: retorna um objeto Atom
*************************************************************** */ 
  public Atom randomAtom() {
    Atom a = new Atom();
    Random generator = new Random();

    int quant = ad.listarAtomos().size();

    a = ad.listarAtomos().get(generator.nextInt(quant));

    return a;
  }

}
