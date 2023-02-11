/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 21/05/2022
* Ultima alteracao.: 21/05/2022
* Nome.............: Car16
* Funcao...........: Esta classe tem a funcao de criar o Objeto Car16
                    Modificando a posicao, para que o carro se 
                    mexa na tela, implementa os semaforos, etc.
*************************************************************** */
package model;

import controller.MainController;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import utils.GlobalVariables;

public class Car16 extends Thread {
  private MainController control;
  private ImageView carro = new ImageView();
  private int velocity = 1;
  private Double xPosition = 202.0;
  private Double yPosition = 20.0;
  private Double rotation = 90.0;
  
  public Car16 (MainController control){
    this.control = control;
  }

/* ***************************************************************
* Metodo: run
* Funcao: Esta funcao inicia a thread e implementa os semaforos
* Parametros: sem parametros
* Retorno: sem retorno
*************************************************************** */
  public void run(){

    setCarImage();
    putCarOnScene();

    while(true){
      try{

        long22ToUp();
        GlobalVariables.longMutex[1][2].acquire();
        GlobalVariables.cornersMutex[2][2].acquire();
        GlobalVariables.longMutex[2][2].release();
        long12ToUp();
        GlobalVariables.specialMutex[19].acquire();
        GlobalVariables.longMutex[0][2].acquire();
        GlobalVariables.cornersMutex[1][2].acquire();
        GlobalVariables.longMutex[1][2].release();
        long02ToUp();
        GlobalVariables.specialMutex[11].acquire();
        GlobalVariables.specialMutex[1].acquire();
        GlobalVariables.latiMutex[0][2].acquire();
        GlobalVariables.cornersMutex[0][2].acquire();
        GlobalVariables.longMutex[0][2].release();
        lat02ToRight();
        GlobalVariables.latiMutex[0][3].acquire();
        GlobalVariables.cornersMutex[0][3].acquire();
        GlobalVariables.latiMutex[0][2].release();
        GlobalVariables.specialMutex[19].release();
        lat03ToRight();
        GlobalVariables.longMutex[0][4].acquire();
        GlobalVariables.cornersMutex[0][4].acquire();
        GlobalVariables.latiMutex[0][3].release();
        long04ToDown();
        GlobalVariables.longMutex[1][4].acquire();
        GlobalVariables.cornersMutex[1][4].acquire();
        GlobalVariables.longMutex[0][4].release();
        GlobalVariables.specialMutex[11].release();
        long14ToDown();
        GlobalVariables.longMutex[2][4].acquire();
        GlobalVariables.cornersMutex[2][4].acquire();
        GlobalVariables.longMutex[1][4].release();
        GlobalVariables.specialMutex[1].release();
        long24ToDown();
        GlobalVariables.latiMutex[3][4].acquire();
        GlobalVariables.cornersMutex[3][5].acquire();
        GlobalVariables.longMutex[2][4].release();
        lat34ToLeft();
        GlobalVariables.specialMutex[12].acquire();
        GlobalVariables.latiMutex[3][3].acquire();
        GlobalVariables.cornersMutex[3][4].acquire();
        GlobalVariables.latiMutex[3][4].release();
        lat33ToLeft();
        GlobalVariables.latiMutex[3][2].acquire();
        GlobalVariables.cornersMutex[3][3].acquire();
        GlobalVariables.latiMutex[3][3].release();
        lat32ToLeft();
        GlobalVariables.longMutex[2][2].acquire();
        GlobalVariables.cornersMutex[3][2].acquire();
        GlobalVariables.latiMutex[3][2].release();
        GlobalVariables.specialMutex[12].release();

      }catch (InterruptedException e){
        e.printStackTrace();
      }
    }

  }

  public void setCarVelocity(int value){
    this.velocity = value;
  }

  public void setCarImage(){
    Image image = new Image("/img/C16.png"); 
    Platform.runLater(() -> {
      carro.setImage(image);
    });
  }

  public void putCarOnScene(){
    AnchorPane ap = control.getAnchorPane();
    Platform.runLater(() -> {
      ap.getChildren().add(carro);
      carro.setX(390);
      carro.setY(290);
      carro.setRotate(0);
    });
  }

  public void refreshPositions(){
    Platform.runLater(() -> {
      xPosition = carro.getX();
      yPosition = carro.getY();
      rotation = carro.getRotate();
    });
  }

 
  //////RUAS LATITUDENAIS

  public void lat02ToRight(){
    refreshPositions();
      while((xPosition < 420) || (yPosition > 1) || (rotation < 90)){
        if(xPosition < 420){
          Platform.runLater(() -> {
            carro.setX(xPosition+0.25);
          });
        }
  
        if(yPosition > 1){
          Platform.runLater(() -> {
            carro.setY(yPosition-0.5);
          });
        }
  
         if(rotation < 90){
          Platform.runLater(() -> {
             carro.setRotate(rotation+1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[0][2].release();

      Platform.runLater(() -> {
        carro.setX(420);
        carro.setY(1);
        carro.setRotate(90);
     });

      for(Double i = xPosition; i < 473; i++ ){
        final Double x = i;
        Platform.runLater(() -> {
          carro.setX(x);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void lat03ToRight(){
    refreshPositions();
      while((xPosition < 535) || (yPosition < 1) || (rotation < 90)){
        if(xPosition < 535){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition < 1){
          Platform.runLater(() -> {
            carro.setY(yPosition+1.0);
          });
        }
  
         if(rotation < 90){
          Platform.runLater(() -> {
             carro.setRotate(rotation+1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[0][3].release();

      Platform.runLater(() -> {
        carro.setX(535);
        carro.setY(1);
        carro.setRotate(90);
     });

      for(Double i = xPosition; i < 692; i++ ){
        final Double x = i;
        Platform.runLater(() -> {
          carro.setX(x);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void lat34ToLeft(){
    refreshPositions();
      while((xPosition > 690) || (yPosition < 330) || (rotation < 270)){
        if(xPosition > 690){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.25);
          });
        }
  
        if(yPosition < 330){
          Platform.runLater(() -> {
            carro.setY(yPosition+0.25);
          });
        }
  
         if(rotation < 270){
          Platform.runLater(() -> {
             carro.setRotate(rotation+1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[3][5].release();

      Platform.runLater(() -> {
        carro.setX(690);
        carro.setY(330);
        carro.setRotate(-90);
     });

      for(Double i = xPosition; i > 645; i-- ){
        final Double x = i;
        Platform.runLater(() -> {
          carro.setX(x);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void lat33ToLeft(){
    refreshPositions();
      while((xPosition > 585) || (yPosition > 330) || (rotation > -90)){
        if(xPosition > 585){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition > 330){
          Platform.runLater(() -> {
            carro.setY(yPosition-1.0);
          });
        }
  
         if(rotation > -90){
          Platform.runLater(() -> {
             carro.setRotate(rotation-1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[3][4].release();

      Platform.runLater(() -> {
        carro.setX(585);
        carro.setY(330);
        carro.setRotate(270);
     });

      for(Double i = xPosition; i > 540; i-- ){
        final Double x = i;
        Platform.runLater(() -> {
          carro.setX(x);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void lat32ToLeft(){
    refreshPositions();
      while((xPosition > 470) || (yPosition < 330) || (rotation < 270)){
        if(xPosition > 470){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition < 330){
          Platform.runLater(() -> {
            carro.setY(yPosition+1.0);
          });
        }
  
         if(rotation < 270){
          Platform.runLater(() -> {
             carro.setRotate(rotation+1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[3][3].release();

      Platform.runLater(() -> {
        carro.setX(690);
        carro.setY(330);
        carro.setRotate(-90);
     });

      for(Double i = xPosition; i > 420; i-- ){
        final Double x = i;
        Platform.runLater(() -> {
          carro.setX(x);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }







  //////RUAS LONGITUDENAIS

  public void long22ToUp(){
    refreshPositions();
      while((xPosition > 390) || (yPosition > 290) || (rotation < 0)){
        if(xPosition > 390){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.5);
          });
        }
  
        if(yPosition > 290){
          Platform.runLater(() -> {
            carro.setY(yPosition-0.25);
          });
        }
  
         if(rotation < 0){
          Platform.runLater(() -> {
             carro.setRotate(rotation+1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[3][2].release();

      Platform.runLater(() -> {
        carro.setX(390);
        carro.setY(291);
        carro.setRotate(0);
     });

      for(Double i = yPosition; i > 250; i-- ){
        final Double y = i;
        Platform.runLater(() -> {
          carro.setY(y);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void long12ToUp(){
    refreshPositions();
      while((xPosition < 390) || (yPosition > 190) || (rotation > 0)){
        if(xPosition < 390){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition > 190){
          Platform.runLater(() -> {
            carro.setY(yPosition-1.0);
          });
        }
  
         if(rotation > 0){
          Platform.runLater(() -> {
             carro.setRotate(rotation-1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[2][2].release();

      Platform.runLater(() -> {
        carro.setX(390);
        carro.setY(190);
        carro.setRotate(0);
     });

      for(Double i = yPosition; i > 140; i-- ){
        final Double y = i;
        Platform.runLater(() -> {
          carro.setY(y);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void long02ToUp(){
    refreshPositions();
      while((xPosition < 390) || (yPosition > 80) || (rotation > 0)){
        if(xPosition < 390){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition > 80){
          Platform.runLater(() -> {
            carro.setY(yPosition-1.0);
          });
        }
  
         if(rotation > 0){
          Platform.runLater(() -> {
             carro.setRotate(rotation-1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[1][2].release();

      Platform.runLater(() -> {
        carro.setX(390);
        carro.setY(80);
        carro.setRotate(0);
     });

      for(Double i = yPosition; i > 30; i-- ){
        final Double y = i;
        Platform.runLater(() -> {
          carro.setY(y);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void long04ToDown(){
    refreshPositions();
      while((xPosition < 723) || (yPosition < 32) || (rotation < 180)){
        if(xPosition < 723){
          Platform.runLater(() -> {
            carro.setX(xPosition+0.5);
          });
        }
  
        if(yPosition < 32){
          Platform.runLater(() -> {
            carro.setY(yPosition+0.25);
          });
        }
  
         if(rotation < 180){
          Platform.runLater(() -> {
             carro.setRotate(rotation+1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[0][4].release();

      Platform.runLater(() -> {
        carro.setX(723);
        carro.setY(32);
        carro.setRotate(180);
     });

      for(Double i = yPosition; i < 80; i++ ){
        final Double y = i;
        Platform.runLater(() -> {
          carro.setY(y);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void long14ToDown(){
    refreshPositions();
      while((xPosition < 723) || (yPosition < 140) || (rotation < 180)){
        if(xPosition < 723){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition < 140){
          Platform.runLater(() -> {
            carro.setY(yPosition+1);
          });
        }
  
         if(rotation < 180){
          Platform.runLater(() -> {
             carro.setRotate(rotation+1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[1][4].release();

      Platform.runLater(() -> {
        carro.setX(723);
        carro.setY(140);
        carro.setRotate(180);
     });

      for(Double i = yPosition; i < 190; i++ ){
        final Double y = i;
        Platform.runLater(() -> {
          carro.setY(y);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void long24ToDown(){
    refreshPositions();
      while((xPosition < 723) || (yPosition < 250) || (rotation < 180)){
        if(xPosition < 723){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition < 250){
          Platform.runLater(() -> {
            carro.setY(yPosition+1);
          });
        }
  
         if(rotation < 180){
          Platform.runLater(() -> {
             carro.setRotate(rotation+1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[2][4].release();

      Platform.runLater(() -> {
        carro.setX(723);
        carro.setY(250);
        carro.setRotate(180);
     });

      for(Double i = yPosition; i < 300; i++ ){
        final Double y = i;
        Platform.runLater(() -> {
          carro.setY(y);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }
  
}