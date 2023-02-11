/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 10/03/2022
* Ultima alteracao.: 10/03/2022
* Nome.............: MainController
* Funcao...........: 
*************************************************************** */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.PaiThread;

public class MainController implements Initializable, Runnable{
    @FXML
    private ImageView imageView_Bisneto;

    @FXML
    private ImageView imageView_BisnetoDied;

    @FXML
    private ImageView imageView_Filho1;

    @FXML
    private ImageView imageView_Filho1Died;

    @FXML
    private ImageView imageView_Filho2;

    @FXML
    private ImageView imageView_Filho2Died;

    @FXML
    private ImageView imageView_Filho3;

    @FXML
    private ImageView imageView_Filho3Died;

    @FXML
    private ImageView imageView_Neto1;

    @FXML
    private ImageView imageView_Neto1Died;

    @FXML
    private ImageView imageView_Neto2;

    @FXML
    private ImageView imageView_Neto2Died;

    @FXML
    private ImageView imageView_Pai;

    @FXML
    private ImageView imageView_PaiDied;

    @FXML
    private ImageView imageView_linhaBisneto;

    @FXML
    private ImageView imageView_linhaFilho1;

    @FXML
    private ImageView imageView_linhaFilho3;

    @FXML
    private ImageView imageView_linhaNeto1;

    @FXML
    private ImageView imageView_linhaNeto2;

    @FXML
    private Label label_Bisneto;

    @FXML
    private Label label_Filho1;

    @FXML
    private Label label_Filho2;

    @FXML
    private Label label_Filho3;

    @FXML
    private Label label_Neto1;

    @FXML
    private Label label_Neto2;

    @FXML
    private Label label_Pai;

    @FXML
    private TextField textField_Bisneto;

    @FXML
    private TextField textField_Filho1;

    @FXML
    private TextField textField_Filho2;

    @FXML
    private TextField textField_Filho3;

    @FXML
    private TextField textField_Neto1;

    @FXML
    private TextField textField_Neto2;

    @FXML
    private TextField textField_Pai;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    run();    
  }

/* ***************************************************************
* Metodo: Run
* Funcao: Esta funcao agrupo todas os objetos da Interface em um
        ArrayList para ser enviado por parâmetro para os objetos da
        Thread, após isso ele instancia a primeira Thread que e a
        PaiThread.
* Parametros: nenhum
* Retorno: sem retorno
*************************************************************** */
  @Override
  public void run() {
      ArrayList<ArrayList> informations = new ArrayList<ArrayList>();
      ArrayList paiInfo = new ArrayList();
        paiInfo.add(imageView_Pai);
        paiInfo.add(label_Pai);
        paiInfo.add(textField_Pai);
        paiInfo.add(imageView_PaiDied);
      informations.addAll(paiInfo);

      ArrayList filho1Info = new ArrayList();
        filho1Info.add(imageView_Filho1);
        filho1Info.add(label_Filho1);
        filho1Info.add(textField_Filho1);
        filho1Info.add(imageView_Filho1Died);
      informations.addAll(filho1Info);

      ArrayList filho2Info = new ArrayList();
        filho2Info.add(imageView_Filho2);
        filho2Info.add(label_Filho2);
        filho2Info.add(textField_Filho2);
        filho2Info.add(imageView_Filho2Died);
      informations.addAll(filho2Info);

      ArrayList filho3Info = new ArrayList();
        filho3Info.add(imageView_Filho3);
        filho3Info.add(label_Filho3);
        filho3Info.add(textField_Filho3);
        filho3Info.add(imageView_Filho3Died);
      informations.addAll(filho3Info);

      ArrayList neto1Info = new ArrayList();
        neto1Info.add(imageView_Neto1);
        neto1Info.add(label_Neto1);
        neto1Info.add(textField_Neto1);
        neto1Info.add(imageView_Neto1Died);
      informations.addAll(neto1Info);

      ArrayList neto2Info = new ArrayList();
        neto2Info.add(imageView_Neto2);
        neto2Info.add(label_Neto2);
        neto2Info.add(textField_Neto2);
        neto2Info.add(imageView_Neto2Died);
      informations.addAll(neto2Info);

      ArrayList bisnetoInfo = new ArrayList();
        bisnetoInfo.add(imageView_Bisneto);
        bisnetoInfo.add(label_Bisneto);
        bisnetoInfo.add(textField_Bisneto);
        bisnetoInfo.add(imageView_BisnetoDied);
      informations.addAll(bisnetoInfo);

      ArrayList linhas = new ArrayList();
        linhas.add(imageView_linhaFilho1);
        linhas.add(imageView_linhaFilho3);
        linhas.add(imageView_linhaNeto1);
        linhas.add(imageView_linhaNeto2);
        linhas.add(imageView_linhaBisneto);
      informations.addAll(linhas);

      PaiThread inicioThread = new PaiThread(informations);
        inicioThread.start();
    }
}
