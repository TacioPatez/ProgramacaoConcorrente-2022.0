/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 18/05/2022
* Ultima alteracao.: 19/05/2022
* Nome.............: Car2
* Funcao...........: Esta classe tem a funcao de criar o Objeto Car2
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

public class Car2 extends Thread {
  private MainController control;
  private ImageView carro = new ImageView();
  private int velocity = 1;
  private Double xPosition = 202.0;
  private Double yPosition = 1.0;
  private Double rotation = 90.0;
  
  public Car2 (MainController control){
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

    try {
      GlobalVariables.specialMutex[10].acquire(); // iniciar com 0
      GlobalVariables.specialMutex[13].acquire();
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }

    while(true){

      try {

        lat00ToRight();
        GlobalVariables.latiMutex[0][1].acquire();
        GlobalVariables.cornersMutex[0][1].acquire();
        GlobalVariables.latiMutex[0][0].release();
        lat01ToRight();
        GlobalVariables.latiMutex[0][2].acquire();
        GlobalVariables.cornersMutex[0][2].acquire();
        GlobalVariables.latiMutex[0][1].release();
        lat02ToRight();
        GlobalVariables.latiMutex[0][3].acquire();
        GlobalVariables.cornersMutex[0][3].acquire();
        GlobalVariables.latiMutex[0][2].release();
        lat03ToRight();
        GlobalVariables.longMutex[0][4].acquire();
        GlobalVariables.cornersMutex[0][4].acquire();
        GlobalVariables.latiMutex[0][3].release();
        long04ToDown();
        GlobalVariables.specialMutex[20].acquire();
        GlobalVariables.longMutex[1][4].acquire();
        GlobalVariables.cornersMutex[1][4].acquire();
        GlobalVariables.longMutex[0][4].release();
        GlobalVariables.specialMutex[13].release();
        long14ToDown();
        GlobalVariables.specialMutex[14].acquire();
        GlobalVariables.longMutex[2][4].acquire();
        GlobalVariables.cornersMutex[2][4].acquire();
        GlobalVariables.longMutex[1][4].release();
        GlobalVariables.specialMutex[10].release();
        long24ToDown();
        GlobalVariables.specialMutex[4].acquire();
        GlobalVariables.longMutex[3][5].acquire();
        GlobalVariables.cornersMutex[3][5].acquire();
        GlobalVariables.longMutex[2][4].release();
        long35ToDown();
        GlobalVariables.longMutex[4][4].acquire();
        GlobalVariables.cornersMutex[4][5].acquire();
        GlobalVariables.longMutex[3][5].release();
        GlobalVariables.specialMutex[20].release();
        long44ToDown();
        GlobalVariables.latiMutex[5][3].acquire();
        GlobalVariables.cornersMutex[5][4].acquire();
        GlobalVariables.longMutex[4][4].release();
        lat53ToLeft();
        GlobalVariables.specialMutex[6].acquire();
        GlobalVariables.longMutex[4][3].acquire();
        GlobalVariables.cornersMutex[5][3].acquire();
        GlobalVariables.latiMutex[5][3].release();
        GlobalVariables.specialMutex[4].release();
        GlobalVariables.specialMutex[14].release();
        long43ToUp();
        GlobalVariables.longMutex[3][3].acquire();
        GlobalVariables.cornersMutex[4][3].acquire();
        GlobalVariables.longMutex[4][3].release();
        long33ToUp();
        GlobalVariables.longMutex[2][3].acquire();
        GlobalVariables.cornersMutex[3][3].acquire();
        GlobalVariables.longMutex[3][3].release();
        long23ToUp();
        GlobalVariables.latiMutex[2][2].acquire();
        GlobalVariables.cornersMutex[2][3].acquire();
        GlobalVariables.longMutex[2][3].release();
        GlobalVariables.specialMutex[6].release();
        lat22ToLeft();
        GlobalVariables.longMutex[2][2].acquire();
        GlobalVariables.cornersMutex[2][2].acquire();
        GlobalVariables.latiMutex[2][2].release();
        long22ToDown();
        GlobalVariables.longMutex[3][2].acquire();
        GlobalVariables.cornersMutex[3][2].acquire();
        GlobalVariables.longMutex[2][2].release();
        long32ToDown();
        GlobalVariables.longMutex[4][2].acquire();
        GlobalVariables.cornersMutex[4][2].acquire();
        GlobalVariables.longMutex[3][2].release();
        long42ToDown();
        GlobalVariables.specialMutex[15].acquire();
        GlobalVariables.specialMutex[3].acquire();
        GlobalVariables.latiMutex[5][1].acquire();
        GlobalVariables.cornersMutex[5][2].acquire();
        GlobalVariables.longMutex[4][2].release();
        lat51ToLeft();
        GlobalVariables.latiMutex[5][0].acquire();
        GlobalVariables.cornersMutex[5][1].acquire();
        GlobalVariables.latiMutex[5][1].release();
        lat50ToLeft();
        GlobalVariables.longMutex[4][0].acquire();
        GlobalVariables.cornersMutex[5][0].acquire();
        GlobalVariables.latiMutex[5][0].release();
        long40ToUp();
        GlobalVariables.specialMutex[21].acquire();
        GlobalVariables.longMutex[3][0].acquire();
        GlobalVariables.cornersMutex[4][0].acquire();
        GlobalVariables.longMutex[4][0].release();
        GlobalVariables.specialMutex[15].release();
        long30ToUp();
        GlobalVariables.specialMutex[13].acquire();
        GlobalVariables.longMutex[2][0].acquire();
        GlobalVariables.cornersMutex[3][0].acquire();
        GlobalVariables.longMutex[3][0].release();
        GlobalVariables.specialMutex[3].release();
        long20ToUp();
        GlobalVariables.specialMutex[10].acquire();
        GlobalVariables.longMutex[1][0].acquire();
        GlobalVariables.cornersMutex[2][0].acquire();
        GlobalVariables.longMutex[2][0].release();
        long10ToUp();
        GlobalVariables.longMutex[0][0].acquire();
        GlobalVariables.cornersMutex[1][0].acquire();
        GlobalVariables.longMutex[1][0].release();
        GlobalVariables.specialMutex[21].release();
        long00ToUp();
        GlobalVariables.latiMutex[0][0].acquire();
        GlobalVariables.cornersMutex[0][0].acquire();
        GlobalVariables.longMutex[0][0].release();

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }

  public void setCarVelocity(int value){
    this.velocity = value;
  }

  public void setCarImage(){
    Image image = new Image("/img/C2.png"); 
    Platform.runLater(() -> {
      carro.setImage(image);
    });
  }

  public void putCarOnScene(){
    AnchorPane ap = control.getAnchorPane();
    Platform.runLater(() -> {
      ap.getChildren().add(carro);
      carro.setX(202);
      carro.setY(1);
      carro.setRotate(450);
    });
  }

  public void refreshPositions(){
    Platform.runLater(() -> {
      xPosition = carro.getX();
      yPosition = carro.getY();
      rotation = carro.getRotate();
    });
  }

  //RUAS LATITUDENAIS
  public void lat00ToRight(){
    refreshPositions();
      while((xPosition < 202) || (yPosition > 1) || (rotation < 450)){
        if(xPosition < 202){
          Platform.runLater(() -> {
            carro.setX(xPosition+0.25);
          });
        }
  
        if(yPosition > 1){
          Platform.runLater(() -> {
            carro.setY(yPosition-0.5);
          });
        }
  
         if(rotation < 450){
          Platform.runLater(() -> {
             carro.setRotate(rotation+1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[0][0].release();

      Platform.runLater(() -> {
        carro.setX(202);
        carro.setY(1);
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

  public void lat01ToRight(){
    refreshPositions();
      while((xPosition < 311) || (yPosition < 1) || (rotation < 90)){
        if(xPosition < 311){
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
      while((xPosition < 420) || (yPosition < 1) || (rotation < 90)){
        if(xPosition < 420){
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

  public void lat53ToLeft(){
    refreshPositions();
      while((xPosition > 690) || (yPosition < 554) || (rotation < 270)){
        if(xPosition > 690){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.25);
          });
        }
  
        if(yPosition < 554){
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

      GlobalVariables.cornersMutex[5][4].release();

      Platform.runLater(() -> {
        carro.setX(690);
        carro.setY(554);
        carro.setRotate(270);
     });

      for(Double i = xPosition; i > 535; i-- ){
        final Double x = i;
        Platform.runLater(() -> {
          carro.setX(x);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void lat22ToLeft(){
    refreshPositions();
      while((xPosition > 470) || (yPosition > 220) || (rotation > 270)){
        if(xPosition > 470){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.25);
          });
        }
  
        if(yPosition > 220){
          Platform.runLater(() -> {
            carro.setY(yPosition-0.5);
          });
        }
  
         if(rotation > 270){
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
        carro.setX(470);
        carro.setY(220);
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
            carro.setX(xPosition-0.25);
          });
        }
  
        if(yPosition < 554){
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

      GlobalVariables.cornersMutex[5][2].release();

      Platform.runLater(() -> {
        carro.setX(360);
        carro.setY(554);
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

  public void lat50ToLeft(){
    refreshPositions();
      while((xPosition > 250) || (yPosition < 554) || (rotation < 270)){
        if(xPosition > 250){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition < 554){
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

      GlobalVariables.cornersMutex[5][1].release();

      Platform.runLater(() -> {
        carro.setX(250);
        carro.setY(554);
        carro.setRotate(270);
     });

      for(Double i = xPosition; i > 200; i-- ){
        final Double x = i;
        Platform.runLater(() -> {
          carro.setX(x);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }


























  //RUAS LONGITUDENAIS
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

  public void long35ToDown(){
    refreshPositions();
      while((xPosition < 723) || (yPosition < 360) || (rotation < 180)){
        if(xPosition < 723){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition < 360){
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

      GlobalVariables.cornersMutex[3][5].release();

      Platform.runLater(() -> {
        carro.setX(723);
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

  public void long44ToDown(){
    refreshPositions();
      while((xPosition < 723) || (yPosition < 480) || (rotation < 180)){
        if(xPosition < 723){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition < 480){
          Platform.runLater(() -> {
            carro.setY(yPosition+1.0);
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

      GlobalVariables.cornersMutex[4][5].release();

      Platform.runLater(() -> {
        carro.setX(723);
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

  public void long43ToUp(){
    refreshPositions();
      while((xPosition > 505) || (yPosition > 520) || (rotation < 360)){
        if(xPosition > 505){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.5);
          });
        }
  
        if(yPosition > 520){
          Platform.runLater(() -> {
            carro.setY(yPosition-0.25);
          });
        }
  
         if(rotation < 360){
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
        carro.setX(505);
        carro.setY(522);
        carro.setRotate(360);
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

  public void long33ToUp(){
    refreshPositions();
      while((xPosition > 505) || (yPosition > 415) || (rotation < 360)){
        if(xPosition > 505){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition > 415){
          Platform.runLater(() -> {
            carro.setY(yPosition-1.0);
          });
        }
  
         if(rotation < 360){
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
        carro.setX(505);
        carro.setY(415);
        carro.setRotate(360);
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

  public void long23ToUp(){
    refreshPositions();
      while((xPosition > 505) || (yPosition > 300) || (rotation < 360)){
        if(xPosition > 505){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition > 300){
          Platform.runLater(() -> {
            carro.setY(yPosition-1.0);
          });
        }
  
         if(rotation < 360){
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
        carro.setX(505);
        carro.setY(300);
        carro.setRotate(360);
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

  public void long22ToDown(){
    refreshPositions();
      while((xPosition > 390) || (yPosition < 250) || (rotation > 180)){
        if(xPosition > 390){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.5);
          });
        }
  
        if(yPosition < 250){
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

      GlobalVariables.cornersMutex[2][2].release();

      Platform.runLater(() -> {
        carro.setX(390);
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

  public void long32ToDown(){
    refreshPositions();
      while((xPosition > 390) || (yPosition < 360) || (rotation > 180)){
        if(xPosition > 390){
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

      GlobalVariables.cornersMutex[3][2].release();

      Platform.runLater(() -> {
        carro.setX(390);
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
      while((xPosition > 390) || (yPosition < 480) || (rotation > 180)){
        if(xPosition > 390){
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

      GlobalVariables.cornersMutex[4][2].release();

      Platform.runLater(() -> {
        carro.setX(390);
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

  public void long40ToUp(){
    refreshPositions();
      while((xPosition > 170) || (yPosition > 520) || (rotation < 360)){
        if(xPosition > 170){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.5);
          });
        }
  
        if(yPosition > 520){
          Platform.runLater(() -> {
            carro.setY(yPosition-0.25);
          });
        }
  
         if(rotation < 360){
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
        carro.setX(170);
        carro.setY(520);
        carro.setRotate(360);
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

  public void long30ToUp(){
    refreshPositions();
      while((xPosition > 170) || (yPosition > 415) || (rotation < 360)){
        if(xPosition > 170){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition > 415){
          Platform.runLater(() -> {
            carro.setY(yPosition-1.0);
          });
        }
  
         if(rotation < 360){
          Platform.runLater(() -> {
             carro.setRotate(rotation+1.0);
          });
         }
  
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}

        refreshPositions();
      }

      GlobalVariables.cornersMutex[4][0].release();

      Platform.runLater(() -> {
        carro.setX(170);
        carro.setY(415);
        carro.setRotate(360);
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

  public void long20ToUp(){
    refreshPositions();
      while((xPosition > 170) || (yPosition > 300) || (rotation < 360)){
        if(xPosition > 170){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition > 300){
          Platform.runLater(() -> {
            carro.setY(yPosition-1.0);
          });
        }
  
         if(rotation < 360){
          Platform.runLater(() -> {
             carro.setRotate(rotation+1.0);
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
        carro.setY(300);
        carro.setRotate(360);
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

  public void long10ToUp(){
    refreshPositions();
      while((xPosition > 170) || (yPosition > 190) || (rotation < 360)){
        if(xPosition > 170){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition > 190){
          Platform.runLater(() -> {
            carro.setY(yPosition-1.0);
          });
        }
  
         if(rotation < 360){
          Platform.runLater(() -> {
             carro.setRotate(rotation+1.0);
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
        carro.setY(190);
        carro.setRotate(360);
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

  public void long00ToUp(){
    refreshPositions();
      while((xPosition > 170) || (yPosition > 80) || (rotation < 360)){
        if(xPosition > 170){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition > 80){
          Platform.runLater(() -> {
            carro.setY(yPosition-1.0);
          });
        }
  
         if(rotation < 360){
          Platform.runLater(() -> {
             carro.setRotate(rotation+1.0);
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
        carro.setY(80);
        carro.setRotate(360);
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

}
