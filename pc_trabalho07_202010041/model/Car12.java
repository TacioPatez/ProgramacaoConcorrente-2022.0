/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 21/05/2022
* Ultima alteracao.: 21/05/2022
* Nome.............: Car10
* Funcao...........: Esta classe tem a funcao de criar o Objeto Car10
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

public class Car12 extends Thread {
  private MainController control;
  private ImageView carro = new ImageView();
  private int velocity = 1;
  private Double xPosition = 202.0;
  private Double yPosition = 20.0;
  private Double rotation = 90.0;
  
  public Car12 (MainController control){
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
      try {

        long41ToUp();
        GlobalVariables.longMutex[3][1].acquire();
        GlobalVariables.cornersMutex[4][1].acquire();
        GlobalVariables.longMutex[4][1].release();
        GlobalVariables.specialMutex[16].release();
        long31ToUp();
        GlobalVariables.longMutex[2][1].acquire();
        GlobalVariables.cornersMutex[3][1].acquire();
        GlobalVariables.longMutex[3][1].release();
        long21ToUp();
        GlobalVariables.longMutex[1][1].acquire();
        GlobalVariables.cornersMutex[2][1].acquire();
        GlobalVariables.longMutex[2][1].release();
        long11ToUp();
        GlobalVariables.longMutex[0][1].acquire();
        GlobalVariables.cornersMutex[1][1].acquire();
        GlobalVariables.longMutex[1][1].release();
        long01ToUp();
        GlobalVariables.specialMutex[18].acquire();
        GlobalVariables.specialMutex[8].acquire();
        GlobalVariables.specialMutex[0].acquire();
        GlobalVariables.latiMutex[0][1].acquire();
        GlobalVariables.cornersMutex[0][1].acquire();
        GlobalVariables.longMutex[0][1].release();
        lat01ToRight();
        GlobalVariables.latiMutex[0][2].acquire();
        GlobalVariables.cornersMutex[0][2].acquire();
        GlobalVariables.latiMutex[0][1].release();
        lat02ToRight();
        GlobalVariables.longMutex[0][3].acquire();
        GlobalVariables.cornersMutex[0][3].acquire();
        GlobalVariables.latiMutex[0][2].release();
        GlobalVariables.specialMutex[0].release();
        GlobalVariables.specialMutex[8].release();
        long03ToDown();
        GlobalVariables.longMutex[1][3].acquire();
        GlobalVariables.cornersMutex[1][3].acquire();
        GlobalVariables.longMutex[0][3].release();
        GlobalVariables.specialMutex[18].release();
        long13ToDown();
        GlobalVariables.specialMutex[16].acquire();
        GlobalVariables.specialMutex[6].acquire();
        GlobalVariables.longMutex[2][3].acquire();
        GlobalVariables.cornersMutex[2][3].acquire();
        GlobalVariables.longMutex[1][3].release();
        long23ToDown();
        GlobalVariables.longMutex[3][3].acquire();
        GlobalVariables.cornersMutex[3][3].acquire();
        GlobalVariables.longMutex[2][3].release();
        long33ToDown();
        GlobalVariables.specialMutex[19].acquire();
        GlobalVariables.longMutex[4][3].acquire();
        GlobalVariables.cornersMutex[4][3].acquire();
        GlobalVariables.longMutex[3][3].release();
        long43ToDown();
        GlobalVariables.specialMutex[7].acquire();
        GlobalVariables.specialMutex[2].acquire();
        GlobalVariables.latiMutex[5][2].acquire();
        GlobalVariables.cornersMutex[5][3].acquire();
        GlobalVariables.longMutex[4][3].release();
        GlobalVariables.specialMutex[6].release();
        GlobalVariables.specialMutex[19].release();
        lat52ToLeft();
        GlobalVariables.latiMutex[5][1].acquire();
        GlobalVariables.cornersMutex[5][2].acquire();
        GlobalVariables.latiMutex[5][2].release();
        lat51ToLeft();
        GlobalVariables.longMutex[4][1].acquire();
        GlobalVariables.cornersMutex[5][1].acquire();
        GlobalVariables.latiMutex[5][1].release();
        GlobalVariables.specialMutex[2].release();
        GlobalVariables.specialMutex[7].release();

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }

  public void setCarVelocity(int value){
    this.velocity = value;
  }

  public void setCarImage(){
    Image image = new Image("/img/C12.png"); 
    Platform.runLater(() -> {
      carro.setImage(image);
    });
  }

  public void putCarOnScene(){
    AnchorPane ap = control.getAnchorPane();
    Platform.runLater(() -> {
      ap.getChildren().add(carro);
      carro.setX(280);
      carro.setY(520);
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

  public void lat52ToLeft(){
    refreshPositions();
      while((xPosition > 470) || (yPosition < 554) || (rotation < 270)){
        if(xPosition > 470){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.25);
          });
        }
  
        if(yPosition < 554){
          Platform.runLater(() -> {
            carro.setY(yPosition+0.5);
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

      GlobalVariables.cornersMutex[5][3].release();

      Platform.runLater(() -> {
        carro.setX(470);
        carro.setY(554);
        carro.setRotate(270);
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
  
  public void lat51ToLeft(){
    refreshPositions();
      while((xPosition > 360) || (yPosition < 554) || (rotation < 270)){
        if(xPosition > 360){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition < 554){
          Platform.runLater(() -> {
            carro.setY(yPosition-1.0);
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

      GlobalVariables.cornersMutex[5][2].release();

      Platform.runLater(() -> {
        carro.setX(470);
        carro.setY(554);
        carro.setRotate(-90);
     });

      for(Double i = xPosition; i > 310; i-- ){
        final Double x = i;
        Platform.runLater(() -> {
          carro.setX(x);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }
  
  public void lat01ToRight(){
    refreshPositions();
      while((xPosition < 311) || (yPosition > 1) || (rotation < 90)){
        if(xPosition < 311){
          Platform.runLater(() -> {
            carro.setX(xPosition+0.5);
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

      GlobalVariables.cornersMutex[0][1].release();

      Platform.runLater(() -> {
        carro.setX(311);
        carro.setY(1);
        carro.setRotate(90);
      });

      for(Double i = xPosition; i < 360; i++ ){
        final Double x = i;
        Platform.runLater(() -> {
          carro.setX(x);
        });
        try {
          Thread.sleep(velocity); 
        } catch (InterruptedException e) {}
      }
  }

  public void lat02ToRight(){
    refreshPositions();
      while((xPosition < 420) || (yPosition > 1) || (rotation < 90)){
        if(xPosition < 420){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition > 1){
          Platform.runLater(() -> {
            carro.setY(yPosition-1.0);
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










  //////RUAS LONGITUDENAIS

  public void long41ToUp(){
    refreshPositions();
      while((xPosition > 280) || (yPosition > 520) || (rotation < 0)){
        if(xPosition > 280){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.5);
          });
        }
  
        if(yPosition > 520){
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

      GlobalVariables.cornersMutex[5][1].release();

      Platform.runLater(() -> {
        carro.setX(280);
        carro.setY(522);
        carro.setRotate(0);
     });

      for(Double i = yPosition; i > 480; i-- ){
        final Double y = i;
        Platform.runLater(() -> {
          carro.setY(y);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void long31ToUp(){
    refreshPositions();
      while((xPosition > 280) || (yPosition > 415) || (rotation > 0)){
        if(xPosition > 280){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition > 415){
          Platform.runLater(() -> {
            carro.setY(yPosition-1.0);
          });
        }
  
         if(rotation > 360){
          Platform.runLater(() -> {
             carro.setRotate(rotation-1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[4][1].release();

      Platform.runLater(() -> {
        carro.setX(280);
        carro.setY(415);
        carro.setRotate(0);
     });

      for(Double i = yPosition; i > 360; i-- ){
        final Double y = i;
        Platform.runLater(() -> {
          carro.setY(y);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void long21ToUp(){
    refreshPositions();
      while((xPosition > 280) || (yPosition > 300) || (rotation > 0)){
        if(xPosition > 280){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition > 300){
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

      GlobalVariables.cornersMutex[3][1].release();

      Platform.runLater(() -> {
        carro.setX(280);
        carro.setY(300);
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

  public void long11ToUp(){
    refreshPositions();
      while((xPosition < 280) || (yPosition > 190) || (rotation > 0)){
        if(xPosition < 280){
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

      GlobalVariables.cornersMutex[2][1].release();

      Platform.runLater(() -> {
        carro.setX(280);
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

  public void long01ToUp(){
    refreshPositions();
      while((xPosition < 280) || (yPosition > 80) || (rotation > 0)){
        if(xPosition < 280){
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

      GlobalVariables.cornersMutex[1][1].release();

      Platform.runLater(() -> {
        carro.setX(280);
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

  public void long03ToDown(){
    refreshPositions();
      while((xPosition < 505) || (yPosition < 30) || (rotation < 180)){
        if(xPosition < 505){
          Platform.runLater(() -> {
            carro.setX(xPosition+0.5);
          });
        }
  
        if(yPosition < 30){
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

      GlobalVariables.cornersMutex[0][3].release();

      Platform.runLater(() -> {
        carro.setX(505);
        carro.setY(30);
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

  public void long13ToDown(){
    refreshPositions();
      while((xPosition > 505) || (yPosition < 145) || (rotation > 180)){
        if(xPosition > 505){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition < 145){
          Platform.runLater(() -> {
            carro.setY(yPosition+1.0);
          });
        }
  
         if(rotation > 180){
          Platform.runLater(() -> {
             carro.setRotate(rotation-1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[1][3].release();

      Platform.runLater(() -> {
        carro.setX(505);
        carro.setY(30);
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

  public void long23ToDown(){
    refreshPositions();
      while((xPosition > 505) || (yPosition < 255) || (rotation > 180)){
        if(xPosition > 505){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition < 255){
          Platform.runLater(() -> {
            carro.setY(yPosition+1.0);
          });
        }
  
         if(rotation > 180){
          Platform.runLater(() -> {
             carro.setRotate(rotation-1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[2][3].release();

      Platform.runLater(() -> {
        carro.setX(505);
        carro.setY(255);
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

  public void long33ToDown(){
    refreshPositions();
      while((xPosition > 505) || (yPosition < 365) || (rotation > 180)){
        if(xPosition > 505){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition < 365){
          Platform.runLater(() -> {
            carro.setY(yPosition+1.0);
          });
        }
  
         if(rotation > 180){
          Platform.runLater(() -> {
             carro.setRotate(rotation-1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[3][3].release();

      Platform.runLater(() -> {
        carro.setX(505);
        carro.setY(365);
        carro.setRotate(180);
     });

      for(Double i = yPosition; i < 415; i++ ){
        final Double y = i;
        Platform.runLater(() -> {
          carro.setY(y);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void long43ToDown(){
    refreshPositions();
      while((xPosition > 505) || (yPosition < 480) || (rotation > 180)){
        if(xPosition > 505){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition < 480){
          Platform.runLater(() -> {
            carro.setY(yPosition+1.0);
          });
        }
  
         if(rotation > 180){
          Platform.runLater(() -> {
             carro.setRotate(rotation-1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[4][3].release();

      Platform.runLater(() -> {
        carro.setX(505);
        carro.setY(480);
        carro.setRotate(180);
     });

      for(Double i = yPosition; i < 525; i++ ){
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