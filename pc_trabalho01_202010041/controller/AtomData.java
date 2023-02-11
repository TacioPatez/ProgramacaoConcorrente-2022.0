/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 03/01/2022
* Ultima alteracao.: 01/02/2022
* Nome.............: AtomData
* Funcao...........: Este codigo tem a funcao de fazer com que
                    o arquivo 'atomos.txt' no pacote 'utils' seja lido
                    e a partir da leitura, seja criado uma lista de objetos
                    do tipo 'Atom' com os atributos dado pelo arquivo txt.
*************************************************************** */
package controller;

import model.Atom;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AtomData {

//CONSTRUTOR
  public AtomData() {
  }

  File arquivo = new File("util/atomos.txt");

/* ***************************************************************
* Metodo: listarAtomos
* Funcao: ler o arquivo atomos.txt e cria objetos 'Atom' de acordo
          com cada atomo registrado neste txt, em seguida poe todos
          esses objetos criado dentro de um array list
* Parametros: nenhum
* Retorno: retorna uma lista com os objetos Atom
*************************************************************** */
  public ArrayList<Atom> listarAtomos() {
    ArrayList<Atom> atom = new ArrayList<Atom>();
    int[] camadas = new int[7];

    try {
      Scanner reader = new Scanner(new FileReader(arquivo));
      while (reader.hasNext()) {
        String nome = reader.next();
        for (int i = 0; i < 7; i++) {
          camadas[i] = reader.nextInt();
        }

        atom.add(new Atom(nome, camadas));
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return atom;
  }
}
