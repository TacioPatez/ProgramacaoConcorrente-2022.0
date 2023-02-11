/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 03/01/2022
* Ultima alteracao.: 01/02/2022
* Nome.............: Atom
* Funcao...........: Este codigo tem a funcao de criar um objeto
                    Atom que armazenara todas os atributos necessarios
                    de um atomo para o jogo.
*************************************************************** */
package model;

public class Atom {
  // ATRIBUTOS
  private String nome;
  private int camadas[] = new int[] { 0, 0, 0, 0, 0, 0, 0 };

  // CONSTRUTORES
  public Atom() {
  }

  public Atom(String name, int[] cam) {
    nome = name;

    for (int i = 0; i < 7; i++) {
      camadas[i] = cam[i];
    }
  }

/* ***************************************************************
* Metodo: getNome
* Funcao: retorna o nome do atomo
* Parametros: nenhum
* Retorno: retorna o nome do atomo
*************************************************************** */
  public String getNome() {
    return nome;
  }

/* ***************************************************************
* Metodo: getCamadas
* Funcao: retorna um array int informando as quantos eletrons esta
          em cada camada.
* Parametros: nenhum
* Retorno: retorna o array de inteiros com as camadas e seus eletrons
*************************************************************** */
  public int[] getCamadas() {
    return camadas;
  }
}
