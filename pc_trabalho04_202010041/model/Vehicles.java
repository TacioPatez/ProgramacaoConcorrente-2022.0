/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 07/04/2022
* Ultima alteracao.: 09/04/2022
* Nome.............: Vehicles
* Funcao...........: Esta classe tem a funcao de criar o Objeto vehicle
                    Este objeto sera manipulado pelas threads Consumer e
                    Producer, modificando a posicao, para que o carro se 
                    mexa na tela, etc.
*************************************************************** */
package model;

import java.util.Random;

import controller.MainController;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Vehicles {
  private ImageView car = new ImageView();
  private MainController control;
  private int id; // space number

  public Vehicles(MainController control){
    this.control = control;
    setCar();
    putCarOnScene();
  }

/* ***************************************************************
* Metodo: setCar
* Funcao: Esta funcao seta uma imagem ao imageview
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void setCar(){
    Random r = new Random();
    int number = (r.nextInt(8))+1;
    Image image = new Image("/img/vehicle"+number+".png");
    car.setImage(image);
  }

/* ***************************************************************
* Metodo: putCarOnScene
* Funcao: Esta funcao coloca o imageview na Cena
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void putCarOnScene(){
    AnchorPane ap = control.getAnchorPane();
    Platform.runLater(() -> {
      ap.getChildren().add(car);
      car.setRotate(90);
      car.setX(-70);
      car.setY(90);
    });
  }

/* ***************************************************************
* Metodo: removeCarOnScene
* Funcao: Esta funcao retira o imageview na Cena
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void removeCarOnScene(){
    AnchorPane ap = control.getAnchorPane();

    leaveOutSpace();

    Platform.runLater(() -> {
      ap.getChildren().remove(car);
    });

  }

/* ***************************************************************
* Metodo: moveToSpace
* Funcao: Esta funcao faz com que o carro va em direcao a sua vaga
        correspondente.
* Parametros: o numero da vaga
* Retorno: sem retorno
*************************************************************** */
  public void moveToSpace(int id){ 
    this.id = id;

    switch (id){
      case 0:
        for(Double i = -70.0; i <= 320; i++){
          final Double x = i;
          Platform.runLater(() -> {
            car.setX(x);
          });

          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {}
        }

        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {}

        enterInSpace();
      break;

      case 1:
        for(Double i = -70.0; i <= 320+90; i++){
          final Double x = i;
          Platform.runLater(() -> {
            car.setX(x);
          });

          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {}
        }

        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {}

        enterInSpace();
      break;

      case 2:
        for(Double i = -70.0; i <= 320+180; i++){
          final Double x = i;
          Platform.runLater(() -> {
            car.setX(x);
          });

          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {}
        }

        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {}

        enterInSpace();
      break;

      case 3:
        for(Double i = -70.0; i <= 320+270; i++){
          final Double x = i;
          Platform.runLater(() -> {
            car.setX(x);
          });

          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {}
        }

        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {}

        enterInSpace();
      break;

      case 4:
        for(Double i = -70.0; i <= 320+360; i++){
          final Double x = i;
          Platform.runLater(() -> {
            car.setX(x);
          });

          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {}
        }

        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {}

        enterInSpace();
      break;

      case 5:
      for(Double i = -70.0; i <= 150; i++){
        final Double x = i;
        Platform.runLater(() -> {
          car.setX(x);
        });

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
      }

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}

      while((car.getX() <= 200.0) || (car.getY() <= 400.0) || (car.getRotate() <= 180.0)){
        if(car.getX() <= 200.0){
          Platform.runLater(() -> {
            car.setX(car.getX()+1.0);
          });
        }

        if(car.getY() <= 400.0){
          Platform.runLater(() -> {
            car.setY(car.getY()+1.0);
          });
        }

        if(car.getRotate() <= 180){
          Platform.runLater(() -> {
            car.setRotate(car.getRotate()+1.0);
          });
        }

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
          
      }

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}

      while((car.getX() <= 320.0) || (car.getY() <= 470.0) || (car.getRotate() >= 90.0)){
        if(car.getX() <= 320.0){
          Platform.runLater(() -> {
            car.setX(car.getX()+1.0);
          });
        }

        if(car.getY() <= 470.0){
          Platform.runLater(() -> {
            car.setY(car.getY()+1.0);
          });
        }

        if(car.getRotate() >= 90.0){
          Platform.runLater(() -> {
            car.setRotate(car.getRotate()-1.0);
          });
        }

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
          
      }

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}

        enterInSpace();
      break;

      case 6:
      for(Double i = -70.0; i <= 150; i++){
        final Double x = i;
        Platform.runLater(() -> {
          car.setX(x);
        });

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
      }

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}

      while((car.getX() <= 200.0) || (car.getY() <= 400.0) || (car.getRotate() <= 180.0)){
        if(car.getX() <= 200.0){
          Platform.runLater(() -> {
            car.setX(car.getX()+1.0);
          });
        }

        if(car.getY() <= 400.0){
          Platform.runLater(() -> {
            car.setY(car.getY()+1.0);
          });
        }

        if(car.getRotate() <= 180){
          Platform.runLater(() -> {
            car.setRotate(car.getRotate()+1.0);
          });
        }

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
          
      }

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}

      while((car.getX() <= 320.0+90.0) || (car.getY() <= 470.0) || (car.getRotate() >= 90.0)){
        if(car.getX() <= 320.0+90.0){
          Platform.runLater(() -> {
            car.setX(car.getX()+1.0);
          });
        }

        if(car.getY() <= 470.0){
          Platform.runLater(() -> {
            car.setY(car.getY()+1.0);
          });
        }

        if(car.getRotate() >= 90.0){
          Platform.runLater(() -> {
            car.setRotate(car.getRotate()-1.0);
          });
        }

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
          
      }

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}

        enterInSpace();
      break;

      case 7:
      for(Double i = -70.0; i <= 150; i++){
        final Double x = i;
        Platform.runLater(() -> {
          car.setX(x);
        });

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
      }

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}

      while((car.getX() <= 200.0) || (car.getY() <= 400.0) || (car.getRotate() <= 180.0)){
        if(car.getX() <= 200.0){
          Platform.runLater(() -> {
            car.setX(car.getX()+1.0);
          });
        }

        if(car.getY() <= 400.0){
          Platform.runLater(() -> {
            car.setY(car.getY()+1.0);
          });
        }

        if(car.getRotate() <= 180){
          Platform.runLater(() -> {
            car.setRotate(car.getRotate()+1.0);
          });
        }

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
          
      }

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}

      while((car.getX() <= 320.0+180.0) || (car.getY() <= 470.0) || (car.getRotate() >= 90.0)){
        if(car.getX() <= 320.0+180.0){
          Platform.runLater(() -> {
            car.setX(car.getX()+1.0);
          });
        }

        if(car.getY() <= 470.0){
          Platform.runLater(() -> {
            car.setY(car.getY()+1.0);
          });
        }

        if(car.getRotate() >= 90.0){
          Platform.runLater(() -> {
            car.setRotate(car.getRotate()-1.0);
          });
        }

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
          
      }
      
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}

        enterInSpace();
      break;

      case 8:
      for(Double i = -70.0; i <= 150; i++){
        final Double x = i;
        Platform.runLater(() -> {
          car.setX(x);
        });

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
      }

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}

      while((car.getX() <= 200.0) || (car.getY() <= 400.0) || (car.getRotate() <= 180.0)){
        if(car.getX() <= 200.0){
          Platform.runLater(() -> {
            car.setX(car.getX()+1.0);
          });
        }

        if(car.getY() <= 400.0){
          Platform.runLater(() -> {
            car.setY(car.getY()+1.0);
          });
        }

        if(car.getRotate() <= 180){
          Platform.runLater(() -> {
            car.setRotate(car.getRotate()+1.0);
          });
        }

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
          
      }

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}

      while((car.getX() <= 320.0+270.0) || (car.getY() <= 470.0) || (car.getRotate() >= 90.0)){
        if(car.getX() <= 320.0+270.0){
          Platform.runLater(() -> {
            car.setX(car.getX()+1.0);
          });
        }

        if(car.getY() <= 470.0){
          Platform.runLater(() -> {
            car.setY(car.getY()+1.0);
          });
        }

        if(car.getRotate() >= 90.0){
          Platform.runLater(() -> {
            car.setRotate(car.getRotate()-1.0);
          });
        }

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
          
      }
      
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}

        enterInSpace();
      break;

      case 9:
      for(Double i = -70.0; i <= 150; i++){
        final Double x = i;
        Platform.runLater(() -> {
          car.setX(x);
        });

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
      }

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}

      while((car.getX() <= 200.0) || (car.getY() <= 400.0) || (car.getRotate() <= 180.0)){
        if(car.getX() <= 200.0){
          Platform.runLater(() -> {
            car.setX(car.getX()+1.0);
          });
        }

        if(car.getY() <= 400.0){
          Platform.runLater(() -> {
            car.setY(car.getY()+1.0);
          });
        }

        if(car.getRotate() <= 180){
          Platform.runLater(() -> {
            car.setRotate(car.getRotate()+1.0);
          });
        }

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
          
      }

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}

      while((car.getX() <= 320.0+360.0) || (car.getY() <= 470.0) || (car.getRotate() >= 90.0)){
        if(car.getX() <= 320.0+360.0){
          Platform.runLater(() -> {
            car.setX(car.getX()+1.0);
          });
        }

        if(car.getY() <= 470.0){
          Platform.runLater(() -> {
            car.setY(car.getY()+1.0);
          });
        }

        if(car.getRotate() >= 90.0){
          Platform.runLater(() -> {
            car.setRotate(car.getRotate()-1.0);
          });
        }

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
          
      }
      
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {}

        enterInSpace();
      break;
    }
  }

/* ***************************************************************
* Metodo: enterInSpace
* Funcao: Esta funcao faz com que o carro entre na sua vaga
        correspondente.
* Parametros: sem parametro
* Retorno: sem retorno
*************************************************************** */
  public void enterInSpace(){
    Double xInicial = car.getX();
    Double yInicial = car.getY();
    Double rInicial = car.getRotate();

    if(id >= 0 && id <= 4){
      while((car.getX() <= xInicial+105.0) || (car.getY() <= yInicial+110.0) || (car.getRotate() <= rInicial+90.0)){
        if(car.getX() <= xInicial+105.0){
          Platform.runLater(() -> {
            car.setX(car.getX()+1.0);
          });
        }

        if(car.getY() <= yInicial+110.0){
          Platform.runLater(() -> {
            car.setY(car.getY()+1.0);
          });
        }

        if(car.getRotate() <= rInicial+90.0){
          Platform.runLater(() -> {
            car.setRotate(car.getRotate()+1.0);
          });
        }

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
          
      }
    } else { 
      while(car.getX() <= xInicial+105.0 || car.getY() >= yInicial-110 || car.getRotate() >= rInicial-90){
        if(car.getX() <= xInicial+105.0){
          Platform.runLater(() -> {
            car.setX(car.getX()+1);
          });
        }

        if(car.getY() >= yInicial-110){
          Platform.runLater(() -> {
            car.setY(car.getY()-1);
          });
        }

        if(car.getRotate() >= rInicial-90){
          Platform.runLater(() -> {
            car.setRotate(car.getRotate()-1);
          });
        }
          
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}

      }
    }
  }

/* ***************************************************************
* Metodo: leaveOutSpace
* Funcao: Esta funcao faz com que o carro saia da sua vaga.
* Parametros: sem parametro
* Retorno: sem retorno
*************************************************************** */
  public void leaveOutSpace(){
    Double xInicial = car.getX();
    Double yInicial = car.getY();
    Double rInicial = car.getRotate();

    if(id >= 0 && id <= 4){
      while((car.getX() >= xInicial-105.0) || (car.getY() >= yInicial-110.0) || (car.getRotate() >= rInicial-90.0)){
        if(car.getX() >= xInicial-105.0){
          Platform.runLater(() -> {
            car.setX(car.getX()-1.0);
          });
        }

        if(car.getY() >= yInicial-110.0){
          Platform.runLater(() -> {
            car.setY(car.getY()-1.0);
          });
        }

        if(car.getRotate() >= rInicial-90.0){
          Platform.runLater(() -> {
            car.setRotate(car.getRotate()-1.0);
          });
        }

        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}
          
      }
    } else { 
      while(car.getX() >= xInicial-105.0 || car.getY() <= yInicial+110 || car.getRotate() <= rInicial+90){
        if(car.getX() >= xInicial-105.0){
          Platform.runLater(() -> {
            car.setX(car.getX()-1);
          });
        }

        if(car.getY() <= yInicial+110){
          Platform.runLater(() -> {
            car.setY(car.getY()+1);
          });
        }

        if(car.getRotate() <= rInicial+90){
          Platform.runLater(() -> {
            car.setRotate(car.getRotate()+1);
          });
        }
          
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {}

      }
    }

    moveToOut();
  }

/* ***************************************************************
* Metodo: moveToOut
* Funcao: Esta funcao faz com que o carro va para a saida.
* Parametros: sem parametro
* Retorno: sem retorno
*************************************************************** */

  public void moveToOut(){ 
    Double xInicial = car.getX();

    switch (id) {
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
        for(Double i = xInicial; i <= 900; i++){
          final Double x = i;
          Platform.runLater(() -> {
            car.setX(x);
          });

          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {}
        }

        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {}

        while(car.getX() <= 1000.0 || car.getY() <= 350.0 || car.getRotate() <= 180.0){
          if(car.getX() <= 1000){
            Platform.runLater(() -> {
              car.setX(car.getX()+1.0);
            });
          }
  
          if(car.getY() <= 350.0){
            Platform.runLater(() -> {
              car.setY(car.getY()+1);
            });
          }
  
          if(car.getRotate() <= 180.0){
            Platform.runLater(() -> {
              car.setRotate(car.getRotate()+1);
            });
          }
            
          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {}
        }

        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {}

        while(car.getX() <= 1400.0 || car.getY() <= 470.0 || car.getRotate() >= 90.0){
          if(car.getX() <= 1400.0){
            Platform.runLater(() -> {
              car.setX(car.getX()+1.0);
            });
          }
  
          if(car.getY() <= 470.0){
            Platform.runLater(() -> {
              car.setY(car.getY()+1);
            });
          }
  
          if(car.getRotate() >= 90.0){
            Platform.runLater(() -> {
              car.setRotate(car.getRotate()-1);
            });
          }
            
          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {}
        }


      break;

      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        for(Double i = xInicial; i <= 1400; i++){
          final Double x = i;
          Platform.runLater(() -> {
            car.setX(x);
          });

          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {}
        }

        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {}
      break;
    }
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
