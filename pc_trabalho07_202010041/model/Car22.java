/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 21/05/2022
* Ultima alteracao.: 21/05/2022
* Nome.............: Car22
* Funcao...........: Esta classe tem a funcao de criar o Objeto Car22
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

public class Car22 extends Thread {
  private MainController control;
  private ImageView carro = new ImageView();
  private int velocity = 1;
  private Double xPosition = 202.0;
  private Double yPosition = 20.0;
  private Double rotation = 90.0;
  
  public Car22(MainController control){
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

        lat43ToRight();
        GlobalVariables.latiMutex[4][4].acquire();
        GlobalVariables.cornersMutex[4][4].acquire();
        GlobalVariables.latiMutex[4][3].release();
        lat44ToRight();
        GlobalVariables.specialMutex[20].acquire();
        GlobalVariables.longMutex[3][5].acquire();
        GlobalVariables.cornersMutex[4][5].acquire();
        GlobalVariables.latiMutex[4][4].release();
        long35ToUp();
        GlobalVariables.longMutex[2][4].acquire();
        GlobalVariables.cornersMutex[3][5].acquire();
        GlobalVariables.longMutex[3][5].release();
        long24ToUp();
        GlobalVariables.longMutex[1][4].acquire();
        GlobalVariables.cornersMutex[2][4].acquire();
        GlobalVariables.longMutex[2][4].release();
        long14ToUp();
        GlobalVariables.latiMutex[1][3].acquire();
        GlobalVariables.cornersMutex[1][4].acquire();
        GlobalVariables.longMutex[1][4].release();
        GlobalVariables.specialMutex[20].release();
        lat13ToLeft();
        GlobalVariables.specialMutex[19].acquire();
        GlobalVariables.specialMutex[18].acquire();
        GlobalVariables.longMutex[0][3].acquire();
        GlobalVariables.cornersMutex[1][3].acquire();
        GlobalVariables.latiMutex[1][3].release();
        long03ToUp();
        GlobalVariables.latiMutex[0][2].acquire();
        GlobalVariables.cornersMutex[0][3].acquire();
        GlobalVariables.longMutex[0][3].release();
        lat02ToLeft();
        GlobalVariables.longMutex[0][2].acquire();
        GlobalVariables.cornersMutex[0][2].acquire();
        GlobalVariables.latiMutex[0][2].release();
        GlobalVariables.specialMutex[18].release();
        long02ToDown();
        GlobalVariables.latiMutex[1][1].acquire();
        GlobalVariables.cornersMutex[1][2].acquire();
        GlobalVariables.longMutex[0][2].release();
        GlobalVariables.specialMutex[19].release();
        lat11ToLeft();
        GlobalVariables.latiMutex[1][0].acquire();
        GlobalVariables.cornersMutex[1][1].acquire();
        GlobalVariables.latiMutex[1][1].release();
        lat10ToLeft();
        GlobalVariables.specialMutex[21].acquire();
        GlobalVariables.specialMutex[22].acquire();
        GlobalVariables.longMutex[1][0].acquire();
        GlobalVariables.cornersMutex[1][0].acquire();
        GlobalVariables.latiMutex[1][0].release();
        long10ToDown();
        GlobalVariables.longMutex[2][0].acquire();
        GlobalVariables.cornersMutex[2][0].acquire();
        GlobalVariables.longMutex[1][0].release();
        long20ToDown();
        GlobalVariables.longMutex[3][0].acquire();
        GlobalVariables.cornersMutex[3][0].acquire();
        GlobalVariables.longMutex[2][0].release();
        long30ToDown();
        GlobalVariables.latiMutex[4][0].acquire();
        GlobalVariables.cornersMutex[4][0].acquire();
        GlobalVariables.longMutex[3][0].release();
        GlobalVariables.specialMutex[21].release();
        lat40ToRight();
        GlobalVariables.latiMutex[4][1].acquire();
        GlobalVariables.cornersMutex[5][0].acquire();
        GlobalVariables.latiMutex[4][0].release();
        lat41ToRight();
        GlobalVariables.longMutex[4][2].acquire();
        GlobalVariables.cornersMutex[4][2].acquire();
        GlobalVariables.latiMutex[4][1].release();
        GlobalVariables.specialMutex[22].release();
        long42ToDown();
        GlobalVariables.specialMutex[19].acquire();
        GlobalVariables.latiMutex[5][2].acquire();
        GlobalVariables.cornersMutex[5][2].acquire();
        GlobalVariables.longMutex[4][2].release();
        lat52ToRight();
        GlobalVariables.longMutex[4][3].acquire();
        GlobalVariables.cornersMutex[5][3].acquire();
        GlobalVariables.latiMutex[5][2].release();
        long43ToUp();
        GlobalVariables.latiMutex[4][3].acquire();
        GlobalVariables.cornersMutex[4][3].acquire();
        GlobalVariables.longMutex[4][3].release();
        GlobalVariables.specialMutex[19].release();

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    

  }

  public void setCarVelocity(int value){
    this.velocity = value;
  }

  public void setCarImage(){
    Image image = new Image("/img/C22.png"); 
    Platform.runLater(() -> {
      carro.setImage(image);
    });
  }

  public void putCarOnScene(){
    AnchorPane ap = control.getAnchorPane();
    Platform.runLater(() -> {
      ap.getChildren().add(carro);
      carro.setX(650);
      carro.setY(450);
      carro.setRotate(90);
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

  public void lat43ToRight(){
    refreshPositions();
      while((xPosition < 535) || (yPosition > 450) || (rotation < 90)){
        if(xPosition < 535){
          Platform.runLater(() -> {
            carro.setX(xPosition+0.25);
          });
        }
  
        if(yPosition > 450){
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

      GlobalVariables.cornersMutex[4][3].release();

      Platform.runLater(() -> {
        carro.setX(535);
        carro.setY(450);
        carro.setRotate(90);
     });

      for(Double i = xPosition; i < 580; i++ ){
        final Double x = i;
        Platform.runLater(() -> {
          carro.setX(x);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void lat44ToRight(){
    refreshPositions();
      while((xPosition < 650) || (yPosition > 450) || (rotation < 90)){
        if(xPosition < 650){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition > 450){
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

      GlobalVariables.cornersMutex[4][4].release();

      Platform.runLater(() -> {
        carro.setX(580);
        carro.setY(450);
        carro.setRotate(90);
     });

      for(Double i = xPosition; i < 690; i++ ){
        final Double x = i;
        Platform.runLater(() -> {
          carro.setX(x);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void lat13ToLeft(){
    refreshPositions();
      while((xPosition > 690) || (yPosition > 110) || (rotation > -90)){
        if(xPosition > 690){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.25);
          });
        }
  
        if(yPosition > 110){
          Platform.runLater(() -> {
            carro.setY(yPosition-0.5);
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

      GlobalVariables.cornersMutex[1][4].release();

      Platform.runLater(() -> {
        carro.setX(690);
        carro.setY(110);
        carro.setRotate(-90);
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

  public void lat02ToLeft(){
    refreshPositions();
      while((xPosition > 470) || (yPosition > 1) || (rotation > -90)){
        if(xPosition > 470){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.25);
          });
        }
  
        if(yPosition > 1){
          Platform.runLater(() -> {
            carro.setY(yPosition-0.5);
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

      GlobalVariables.cornersMutex[0][3].release();

      Platform.runLater(() -> {
        carro.setX(470);
        carro.setY(1);
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

  public void lat11ToLeft(){
    refreshPositions();
      while((xPosition > 350) || (yPosition < 110) || (rotation < 270)){
        if(xPosition > 350){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.25);
          });
        }
  
        if(yPosition < 110){
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

      GlobalVariables.cornersMutex[1][2].release();

      Platform.runLater(() -> {
        carro.setX(350);
        carro.setY(110);
        carro.setRotate(270);
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

  public void lat10ToLeft(){
    refreshPositions();
      while((xPosition > 245) || (yPosition < 110) || (rotation < 270)){
        if(xPosition > 245){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition < 110){
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

      GlobalVariables.cornersMutex[1][1].release();

      Platform.runLater(() -> {
        carro.setX(245);
        carro.setY(110);
        carro.setRotate(270);
     });

      for(Double i = xPosition; i > 205; i-- ){
        final Double x = i;
        Platform.runLater(() -> {
          carro.setX(x);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void lat40ToRight(){
    refreshPositions();
      while((xPosition < 205) || (yPosition < 447) || (rotation > 90)){
        if(xPosition < 205){
          Platform.runLater(() -> {
            carro.setX(xPosition+0.25);
          });
        }
  
        if(yPosition < 447){
          Platform.runLater(() -> {
            carro.setY(yPosition+0.5);
          });
        }
  
         if(rotation > 90){
          Platform.runLater(() -> {
             carro.setRotate(rotation-1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[4][0].release();

      Platform.runLater(() -> {
        carro.setX(205);
        carro.setY(447);
        carro.setRotate(90);
     });

      for(Double i = xPosition; i < 250; i++ ){
        final Double x = i;
        Platform.runLater(() -> {
          carro.setX(x);
        });
        try {
          Thread.sleep(velocity); 
        } catch (InterruptedException e) {}
      }
  }

  public void lat41ToRight(){
    refreshPositions();
      while((xPosition < 311) || (yPosition < 447) || (rotation < 90)){
        if(xPosition < 311){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition < 447){
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

      GlobalVariables.cornersMutex[5][0].release();

      Platform.runLater(() -> {
        carro.setX(311);
        carro.setY(447);
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

  public void lat52ToRight(){
    refreshPositions();
      while((xPosition < 425) || (yPosition < 554) || (rotation > 90)){
        if(xPosition < 425){
          Platform.runLater(() -> {
            carro.setX(xPosition+0.25);
          });
        }
  
        if(yPosition < 554){
          Platform.runLater(() -> {
            carro.setY(yPosition+0.5);
          });
        }
  
         if(rotation > 90){
          Platform.runLater(() -> {
             carro.setRotate(rotation-1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[5][2].release();

      Platform.runLater(() -> {
        carro.setX(425);
        carro.setY(554);
        carro.setRotate(90);
     });

      for(Double i = xPosition; i < 470; i++ ){
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

  public void long35ToUp(){
    refreshPositions();
      while((xPosition < 723) || (yPosition > 415) || (rotation > 0)){
        if(xPosition < 723){
          Platform.runLater(() -> {
            carro.setX(xPosition+0.5);
          });
        }
  
        if(yPosition > 415){
          Platform.runLater(() -> {
            carro.setY(yPosition-0.5);
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

      GlobalVariables.cornersMutex[4][5].release();

      Platform.runLater(() -> {
        carro.setX(723);
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

  public void long24ToUp(){
    refreshPositions();
      while((xPosition > 723) || (yPosition > 300) || (rotation > 0)){
        if(xPosition > 723){
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

      GlobalVariables.cornersMutex[3][5].release();

      Platform.runLater(() -> {
        carro.setX(723);
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

  public void long14ToUp(){
    refreshPositions();
      while((xPosition < 723) || (yPosition > 190) || (rotation > 0)){
        if(xPosition < 723){
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

      GlobalVariables.cornersMutex[2][4].release();

      Platform.runLater(() -> {
        carro.setX(723);
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

  public void long03ToUp(){
    refreshPositions();
      while((xPosition > 505) || (yPosition > 75) || (rotation < 0)){
        if(xPosition > 505){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.5);
          });
        }
  
        if(yPosition > 75){
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

      GlobalVariables.cornersMutex[1][3].release();

      Platform.runLater(() -> {
        carro.setX(505);
        carro.setY(75);
        carro.setRotate(0);
     });

      for(Double i = yPosition; i > 35; i-- ){
        final Double y = i;
        Platform.runLater(() -> {
          carro.setY(y);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void long02ToDown(){
    refreshPositions();
      while((xPosition > 390) || (yPosition < 30) || (rotation > 180)){
        if(xPosition > 390){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.5);
          });
        }
  
        if(yPosition < 30){
          Platform.runLater(() -> {
            carro.setY(yPosition+0.25);
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

      GlobalVariables.cornersMutex[0][2].release();

      Platform.runLater(() -> {
        carro.setX(390);
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

  public void long10ToDown(){
    refreshPositions();
      while((xPosition > 170) || (yPosition < 145) || (rotation > 180)){
        if(xPosition > 170){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.5);
          });
        }
  
        if(yPosition < 145){
          Platform.runLater(() -> {
            carro.setY(yPosition+0.25);
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

      GlobalVariables.cornersMutex[1][0].release();

      Platform.runLater(() -> {
        carro.setX(170);
        carro.setY(145);
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

  public void long20ToDown(){
    refreshPositions();
      while((xPosition > 170) || (yPosition < 255) || (rotation > 180)){
        if(xPosition > 170){
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

      GlobalVariables.cornersMutex[2][0].release();

      Platform.runLater(() -> {
        carro.setX(170);
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

  public void long30ToDown(){
    refreshPositions();
      while((xPosition > 170) || (yPosition < 360) || (rotation > 180)){
        if(xPosition > 170){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition < 360){
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

      GlobalVariables.cornersMutex[3][0].release();

      Platform.runLater(() -> {
        carro.setX(170);
        carro.setY(360);
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
   
  public void long42ToDown(){
    refreshPositions();
      while((xPosition < 390) || (yPosition < 480) || (rotation < 180)){
        if(xPosition < 390){
          Platform.runLater(() -> {
            carro.setX(xPosition+0.5);
          });
        }
  
        if(yPosition < 480){
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

      GlobalVariables.cornersMutex[4][2].release();

      Platform.runLater(() -> {
        carro.setX(390);
        carro.setY(480);
        carro.setRotate(180);
     });

      for(Double i = yPosition; i < 520; i++ ){
        final Double y = i;
        Platform.runLater(() -> {
          carro.setY(y);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void long43ToUp(){
    refreshPositions();
      while((xPosition < 505) || (yPosition > 520) || (rotation > 0)){
        if(xPosition < 505){
          Platform.runLater(() -> {
            carro.setX(xPosition+0.5);
          });
        }
  
        if(yPosition > 520){
          Platform.runLater(() -> {
            carro.setY(yPosition-0.25);
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

      GlobalVariables.cornersMutex[5][3].release();

      Platform.runLater(() -> {
        carro.setX(505);
        carro.setY(520);
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

}