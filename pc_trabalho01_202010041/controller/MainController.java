/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 03/01/2022
* Ultima alteracao.: 01/02/2022
* Nome.............: MainController
* Funcao...........: Este codigo tem a funcao de fazer a interacao entre
                    a interface grafica e os codigos, alem de atribuir
                    funcoes/eventos para os buttons, labels, sliders, etc.
*************************************************************** */

package controller;

import model.Atom;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController implements Initializable {

  @FXML
  private Button backRulesButton;

  @FXML
  private Button decreaseRoundButton;

  @FXML
  private Button doneRoundButton;

  @FXML
  private Slider eletronicLayerSlider;

  @FXML
  private TextField eletronsNumberTextField;

  @FXML
  private AnchorPane gameAnchorPane;

  @FXML
  private AnchorPane fatherAnchorPane;

  @FXML
  private Button increaseRoundButton;

  @FXML
  private AnchorPane mainAnchorPane;

  @FXML
  private Button playGameButton;

  @FXML
  private Button quitButton;

  @FXML
  private AnchorPane rulesAnchorPane;

  @FXML
  private Button rulesGameButton;

  @FXML
  private Label atomNameLabel;

  @FXML
  private ImageView camada2ImageView;

  @FXML
  private ImageView camada3ImageView;

  @FXML
  private ImageView camada4ImageView;

  @FXML
  private ImageView camada5ImageView;

  @FXML
  private ImageView camada6ImageView;

  @FXML
  private ImageView camada7ImageView;

  GameController gc = new GameController();
  Atom a = new Atom();
  int camadaAtual = 0; // camada que o usuario esta atualmente
  String eletronsCamada;
  int[] camadas = new int[] { 1, 0, 0, 0, 0, 0, 0 }; // array de camdas que o usuario esta preenchendo

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {

    ImageView[] imageArray = { camada2ImageView, camada3ImageView, camada4ImageView, camada5ImageView,
        camada6ImageView, camada7ImageView };

    playGameButton.setOnMouseClicked(Event -> { // comeca o jogo
      mainAnchorPane.setVisible(false);
      gameAnchorPane.setVisible(true);
      eletronsNumberTextField.setText("0");
      startGame();
    });

    doneRoundButton.setOnMouseClicked(Event -> { // finaliza o jogo
      if (endGame() == true) {
        mainAnchorPane.setVisible(true);
        gameAnchorPane.setVisible(false);
      }
    });

    rulesGameButton.setOnMouseClicked(Event -> { // botao pra abrir a tela com as regras
      mainAnchorPane.setVisible(false);
      rulesAnchorPane.setVisible(true);
    });

    quitButton.setOnMouseClicked(Event -> { // botao pra fechar o programa
      Stage stage;
      stage = (Stage) fatherAnchorPane.getScene().getWindow();
      stage.close();
    });

    backRulesButton.setOnMouseClicked(Event -> { // botao na tela de regras pra voltar pra
      mainAnchorPane.setVisible(true);           // tela principal
      rulesAnchorPane.setVisible(false);
    });

    eletronicLayerSlider.valueProperty().addListener(new ChangeListener<Number>() { // atualizar a camada atual
      @Override                                                                     // que o player esta usando
      public void changed(ObservableValue<? extends Number> ov, Number valorAntigo, Number valorNovo) {
        camadaAtual = valorNovo.intValue() - 1;
        eletronsCamada = String.valueOf(camadas[camadaAtual]);
        eletronsNumberTextField.setText(eletronsCamada);
      }
    });

    decreaseRoundButton.setOnMouseClicked(Event -> { // diminuir o numero de eletrons na camada
      if (camadas[camadaAtual] > 0) {
        camadas[camadaAtual]--;
        eletronsNumberTextField.setText(String.format("%d", camadas[camadaAtual]));
      }
      if (camadas[camadaAtual] == 0 && camadaAtual != 0) {
        imageArray[camadaAtual - 1].setVisible(false);
      }
    });

    increaseRoundButton.setOnMouseClicked(Event -> { // aumentar o numero de eletrons na camada
      switch (camadaAtual) {
        case 0:
          if (camadas[camadaAtual] < 2) {
            camadas[camadaAtual]++;
          }
          eletronsNumberTextField.setText(String.format("%d", camadas[camadaAtual]));
          break;

        case 1:
          if (camadas[camadaAtual] < 8) {
            camadas[camadaAtual]++;
          }
          imageArray[camadaAtual - 1].setVisible(true);
          eletronsNumberTextField.setText(String.format("%d", camadas[camadaAtual]));
          break;

        case 2:
          if (camadas[camadaAtual] < 18) {
            camadas[camadaAtual]++;
          }
          if (camadaAtual != 0) {
            imageArray[camadaAtual - 1].setVisible(true);
          }
          eletronsNumberTextField.setText(String.format("%d", camadas[camadaAtual]));
          break;

        case 3:
          if (camadas[camadaAtual] < 32) {
            camadas[camadaAtual]++;
          }
          if (camadaAtual != 0) {
            imageArray[camadaAtual - 1].setVisible(true);
          }
          eletronsNumberTextField.setText(String.format("%d", camadas[camadaAtual]));
          break;

        case 4:
          if (camadas[camadaAtual] < 32) {
            camadas[camadaAtual]++;
          }
          if (camadaAtual != 0) {
            imageArray[camadaAtual - 1].setVisible(true);
          }
          eletronsNumberTextField.setText(String.format("%d", camadas[camadaAtual]));
          break;

        case 5:
          if (camadas[camadaAtual] < 18) {
            camadas[camadaAtual]++;
          }
          if (camadaAtual != 0) {
            imageArray[camadaAtual - 1].setVisible(true);
          }
          eletronsNumberTextField.setText(String.format("%d", camadas[camadaAtual]));
          break;

        case 6:
          if (camadas[camadaAtual] < 8) {
            camadas[camadaAtual]++;
          }
          if (camadaAtual != 0) {
            imageArray[camadaAtual - 1].setVisible(true);
          }
          eletronsNumberTextField.setText(String.format("%d", camadas[camadaAtual]));
          break;
      }
    });

  }

/* ***************************************************************
* Metodo: startGame
* Funcao: verifica se o usuario preencheu os eletrons do atomo
          em sua camada reespectiva, se sim, retorna true, se nao,
          retorn false.
* Parametros: nenhum
* Retorno: Void
*************************************************************** */ 
  public void startGame() {
    eletronicLayerSlider.setValue(1);
    for (int i = 0; i < 7; i++) {
      camadas[i] = 0;
    }

    camada2ImageView.setVisible(false);
    camada3ImageView.setVisible(false);
    camada4ImageView.setVisible(false);
    camada5ImageView.setVisible(false);
    camada6ImageView.setVisible(false);
    camada7ImageView.setVisible(false);

    a = gc.randomAtom();

    atomNameLabel.setText(a.getNome());
  }

/* ***************************************************************
* Metodo: endGame
* Funcao: verifica se o usuario preencheu os eletrons do atomo
          em sua camada reespectiva, se sim, retorna true, se nao,
          retorn false.
* Parametros: nenhum
* Retorno: Boolean
*************************************************************** */ 
  public Boolean endGame() {
    int[] teste = a.getCamadas();
    for (int i = 0; i < camadas.length; i++) {
      if (camadas[i] != teste[i]) {
        return false;
      }
    }
    return true;
  }

}
