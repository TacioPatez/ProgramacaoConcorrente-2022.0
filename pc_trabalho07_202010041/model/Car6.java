/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 19/05/2022
* Ultima alteracao.: 20/05/2022
* Nome.............: Car6
* Funcao...........: Esta classe tem a funcao de criar o Objeto Car6
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

public class Car6 extends Thread {
  private MainController control;
  private ImageView carro = new ImageView();
  private int velocity = 1;
  private Double xPosition = 202.0;
  private Double yPosition = 1.0;
  private Double rotation = 90.0;
  
  public Car6 (MainController control){
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

    try { // inicia semaforo com 0
      GlobalVariables.specialMutex[9].acquire();
      GlobalVariables.specialMutex[14].acquire();
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }

    while(true){

      try {
        long44ToUp();
        GlobalVariables.longMutex[3][5].acquire();
        GlobalVariables.cornersMutex[4][5].acquire();
        GlobalVariables.longMutex[4][4].release();
        long35ToUp();
        GlobalVariables.longMutex[2][4].acquire();
        GlobalVariables.cornersMutex[3][5].acquire();
        GlobalVariables.longMutex[3][5].release();
        long24ToUp();
        GlobalVariables.latiMutex[2][3].acquire();
        GlobalVariables.cornersMutex[2][4].acquire();
        GlobalVariables.longMutex[2][4].release();
        GlobalVariables.specialMutex[14].release();
        lat23ToLeft();
        GlobalVariables.latiMutex[2][2].acquire();
        GlobalVariables.cornersMutex[2][3].acquire();
        GlobalVariables.latiMutex[2][3].release();
        lat22ToLeft();
        GlobalVariables.latiMutex[2][1].acquire();
        GlobalVariables.cornersMutex[2][2].acquire();
        GlobalVariables.latiMutex[2][2].release();
        lat21ToLeft();
        GlobalVariables.longMutex[1][1].acquire();
        GlobalVariables.cornersMutex[2][1].acquire();
        GlobalVariables.latiMutex[2][1].release();
        GlobalVariables.specialMutex[9].release();
        long11ToUp();
        GlobalVariables.latiMutex[1][1].acquire();
        GlobalVariables.cornersMutex[1][1].acquire();
        GlobalVariables.longMutex[1][1].release();
        lat11ToRight();
        GlobalVariables.latiMutex[1][2].acquire();
        GlobalVariables.cornersMutex[1][2].acquire();
        GlobalVariables.latiMutex[1][1].release();
        lat12ToRight();
        GlobalVariables.specialMutex[17].acquire();
        GlobalVariables.specialMutex[13].acquire();
        GlobalVariables.specialMutex[11].acquire();
        GlobalVariables.latiMutex[1][3].acquire();
        GlobalVariables.cornersMutex[1][3].acquire();
        GlobalVariables.latiMutex[1][2].release();
        lat13ToRight();
        GlobalVariables.longMutex[0][4].acquire();
        GlobalVariables.cornersMutex[1][4].acquire();
        GlobalVariables.latiMutex[1][3].release();
        long04ToUp();
        GlobalVariables.latiMutex[0][3].acquire();
        GlobalVariables.cornersMutex[0][4].acquire();
        GlobalVariables.longMutex[0][4].release();
        lat03ToLeft();
        GlobalVariables.specialMutex[8].acquire();
        GlobalVariables.latiMutex[0][2].acquire();
        GlobalVariables.cornersMutex[0][3].acquire();
        GlobalVariables.latiMutex[0][3].release();
        lat02ToLeft();
        GlobalVariables.latiMutex[0][1].acquire();
        GlobalVariables.cornersMutex[0][2].acquire();
        GlobalVariables.latiMutex[0][2].release();
        GlobalVariables.specialMutex[11].release();
        lat01ToLeft();
        GlobalVariables.latiMutex[0][0].acquire();
        GlobalVariables.cornersMutex[0][1].acquire();
        GlobalVariables.latiMutex[0][1].release();
        GlobalVariables.specialMutex[8].release();
        lat00ToLeft();
        GlobalVariables.longMutex[0][0].acquire();
        GlobalVariables.cornersMutex[0][0].acquire();
        GlobalVariables.latiMutex[0][0].release();
        long00ToDown();
        GlobalVariables.longMutex[1][0].acquire();
        GlobalVariables.cornersMutex[1][0].acquire();
        GlobalVariables.longMutex[0][0].release();
        long10ToDown();
        GlobalVariables.longMutex[2][0].acquire();
        GlobalVariables.cornersMutex[2][0].acquire();
        GlobalVariables.longMutex[1][0].release();
        long20ToDown();
        GlobalVariables.specialMutex[5].acquire();
        GlobalVariables.latiMutex[3][0].acquire();
        GlobalVariables.cornersMutex[3][0].acquire();
        GlobalVariables.longMutex[2][0].release();
        GlobalVariables.specialMutex[13].release();
        GlobalVariables.specialMutex[17].release();
        lat30ToRight();
        GlobalVariables.latiMutex[3][1].acquire();
        GlobalVariables.cornersMutex[3][1].acquire();
        GlobalVariables.latiMutex[3][0].release();
        lat31ToRight();
        GlobalVariables.specialMutex[12].acquire();
        GlobalVariables.latiMutex[3][2].acquire();
        GlobalVariables.cornersMutex[3][2].acquire();
        GlobalVariables.latiMutex[3][1].release();
        lat32ToRight();
        GlobalVariables.latiMutex[3][3].acquire();
        GlobalVariables.cornersMutex[3][3].acquire();
        GlobalVariables.latiMutex[3][2].release();
        lat33ToRight();
        GlobalVariables.longMutex[3][4].acquire();
        GlobalVariables.cornersMutex[3][4].acquire();
        GlobalVariables.latiMutex[3][3].release();
        GlobalVariables.specialMutex[5].release();
        GlobalVariables.specialMutex[12].release();
        long34ToDown();
        GlobalVariables.latiMutex[4][3].acquire();
        GlobalVariables.cornersMutex[4][4].acquire();
        GlobalVariables.longMutex[3][4].release();
        lat43ToLeft();
        GlobalVariables.latiMutex[4][2].acquire();
        GlobalVariables.cornersMutex[4][3].acquire();
        GlobalVariables.latiMutex[4][3].release();
        lat42ToLeft();
        GlobalVariables.specialMutex[22].acquire();
        GlobalVariables.latiMutex[4][1].acquire();
        GlobalVariables.cornersMutex[4][2].acquire();
        GlobalVariables.latiMutex[4][2].release();
        lat41ToLeft();
        GlobalVariables.latiMutex[4][0].acquire();
        GlobalVariables.cornersMutex[4][1].acquire();
        GlobalVariables.latiMutex[4][1].release();
        lat40ToLeft();
        GlobalVariables.specialMutex[15].acquire();
        GlobalVariables.longMutex[4][0].acquire();
        GlobalVariables.cornersMutex[4][0].acquire();
        GlobalVariables.latiMutex[4][0].release();
        GlobalVariables.specialMutex[22].release();
        long40ToDown();
        GlobalVariables.latiMutex[5][0].acquire();
        GlobalVariables.cornersMutex[5][0].acquire();
        GlobalVariables.longMutex[4][0].release();
        lat50ToRight();
        GlobalVariables.specialMutex[9].acquire();
        GlobalVariables.specialMutex[16].acquire();
        GlobalVariables.specialMutex[7].acquire();
        GlobalVariables.latiMutex[5][1].acquire();
        GlobalVariables.cornersMutex[5][1].acquire();
        GlobalVariables.latiMutex[5][0].release();
        lat51ToRight();
        GlobalVariables.latiMutex[5][2].acquire();
        GlobalVariables.cornersMutex[5][2].acquire();
        GlobalVariables.latiMutex[5][1].release();
        GlobalVariables.specialMutex[15].release();
        lat52ToRight();
        GlobalVariables.specialMutex[14].acquire();
        GlobalVariables.latiMutex[5][3].acquire();
        GlobalVariables.cornersMutex[5][3].acquire();
        GlobalVariables.latiMutex[5][2].release();
        GlobalVariables.specialMutex[7].release();
        GlobalVariables.specialMutex[16].release();
        lat53ToRight();
        GlobalVariables.longMutex[4][4].acquire();
        GlobalVariables.cornersMutex[5][4].acquire();
        GlobalVariables.latiMutex[5][3].release();

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }

  public void setCarVelocity(int value){
    this.velocity = value;
  }

  public void setCarImage(){
    Image image = new Image("/img/C6.png"); 
    Platform.runLater(() -> {
      carro.setImage(image);
    });
  }

  public void putCarOnScene(){
    AnchorPane ap = control.getAnchorPane();
    Platform.runLater(() -> {
      ap.getChildren().add(carro);
      carro.setX(723);
      carro.setY(525);
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

  public void lat23ToLeft(){
    refreshPositions();
      while((xPosition > 690) || (yPosition > 220) || (rotation > -90)){
        if(xPosition > 690){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.25);
          });
        }
  
        if(yPosition > 220){
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

      GlobalVariables.cornersMutex[2][4].release();

      Platform.runLater(() -> {
        carro.setX(690);
        carro.setY(220);
        carro.setRotate(-90);
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
      while((xPosition > 470) || (yPosition > 220) || (rotation > -90)){
        if(xPosition > 470){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition > 220){
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

      GlobalVariables.cornersMutex[2][3].release();

      Platform.runLater(() -> {
        carro.setX(690);
        carro.setY(220);
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

  public void lat21ToLeft(){
    refreshPositions();
      while((xPosition > 360) || (yPosition > 220) || (rotation > -90)){
        if(xPosition > 360){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition > 220){
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

      GlobalVariables.cornersMutex[2][2].release();

      Platform.runLater(() -> {
        carro.setX(360);
        carro.setY(220);
        carro.setRotate(-90);
     });

      for(Double i = xPosition; i > 315; i-- ){
        final Double x = i;
        Platform.runLater(() -> {
          carro.setX(x);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void lat11ToRight(){
    refreshPositions();
      while((xPosition < 311) || (yPosition > 110) || (rotation < 90)){
        if(xPosition < 311){
          Platform.runLater(() -> {
            carro.setX(xPosition+0.25);
          });
        }
  
        if(yPosition > 110){
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

      GlobalVariables.cornersMutex[1][1].release();

      Platform.runLater(() -> {
        carro.setX(311);
        carro.setY(110);
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

  public void lat12ToRight(){
    refreshPositions();
      while((xPosition < 425) || (yPosition > 110) || (rotation < 90)){
        if(xPosition < 425){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition > 110){
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

      GlobalVariables.cornersMutex[1][2].release();

      Platform.runLater(() -> {
        carro.setX(425);
        carro.setY(110);
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

  public void lat13ToRight(){
    refreshPositions();
      while((xPosition < 535) || (yPosition > 110) || (rotation < 90)){
        if(xPosition < 535){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition > 110){
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

      GlobalVariables.cornersMutex[1][3].release();

      Platform.runLater(() -> {
        carro.setX(535);
        carro.setY(110);
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

  public void lat03ToLeft(){
    refreshPositions();
      while((xPosition > 690) || (yPosition > 1) || (rotation > -90)){
        if(xPosition > 690){
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

      GlobalVariables.cornersMutex[0][4].release();

      Platform.runLater(() -> {
        carro.setX(690);
        carro.setY(1);
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
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition > 1){
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

      GlobalVariables.cornersMutex[0][3].release();

      Platform.runLater(() -> {
        carro.setX(470);
        carro.setY(1);
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
  
  public void lat01ToLeft(){
    refreshPositions();
      while((xPosition > 360) || (yPosition > 1) || (rotation > -90)){
        if(xPosition > 360){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition > 1){
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

      GlobalVariables.cornersMutex[0][2].release();

      Platform.runLater(() -> {
        carro.setX(470);
        carro.setY(1);
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

  public void lat00ToLeft(){
    refreshPositions();
      while((xPosition > 250) || (yPosition > 1) || (rotation > -90)){
        if(xPosition > 250){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition > 1){
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

      GlobalVariables.cornersMutex[0][1].release();

      Platform.runLater(() -> {
        carro.setX(250);
        carro.setY(1);
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

  public void lat30ToRight(){
    refreshPositions();
      while((xPosition < 200) || (yPosition < 330) || (rotation > 90)){
        if(xPosition < 200){
          Platform.runLater(() -> {
            carro.setX(xPosition+0.25);
          });
        }
  
        if(yPosition < 330){
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

      GlobalVariables.cornersMutex[3][0].release();

      Platform.runLater(() -> {
        carro.setX(250);
        carro.setY(330);
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

  public void lat31ToRight(){
    refreshPositions();
      while((xPosition < 310) || (yPosition < 330) || (rotation > 90)){
        if(xPosition < 310){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition < 330){
          Platform.runLater(() -> {
            carro.setY(yPosition+1.0);
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

      GlobalVariables.cornersMutex[3][1].release();

      Platform.runLater(() -> {
        carro.setX(360);
        carro.setY(330);
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

  public void lat32ToRight(){
    refreshPositions();
      while((xPosition < 425) || (yPosition < 330) || (rotation > 90)){
        if(xPosition < 425){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition < 330){
          Platform.runLater(() -> {
            carro.setY(yPosition+1.0);
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

      GlobalVariables.cornersMutex[3][2].release();

      Platform.runLater(() -> {
        carro.setX(425);
        carro.setY(330);
        carro.setRotate(90);
      });

      for(Double i = xPosition; i < 475; i++ ){
        final Double x = i;
        Platform.runLater(() -> {
          carro.setX(x);
        });
        try {
          Thread.sleep(velocity); 
        } catch (InterruptedException e) {}
      }
  }

  public void lat33ToRight(){
    refreshPositions();
      while((xPosition < 540) || (yPosition < 330) || (rotation > 90)){
        if(xPosition < 540){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition < 330){
          Platform.runLater(() -> {
            carro.setY(yPosition+1.0);
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

      GlobalVariables.cornersMutex[3][3].release();

      Platform.runLater(() -> {
        carro.setX(540);
        carro.setY(330);
        carro.setRotate(90);
      });

      for(Double i = xPosition; i < 585; i++ ){
        final Double x = i;
        Platform.runLater(() -> {
          carro.setX(x);
        });
        try {
          Thread.sleep(velocity); 
        } catch (InterruptedException e) {}
      }
  }

  public void lat43ToLeft(){
    refreshPositions();
      while((xPosition > 585) || (yPosition < 450) || (rotation < 270)){
        if(xPosition > 585){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.25);
          });
        }
  
        if(yPosition < 450){
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

      GlobalVariables.cornersMutex[4][4].release();

      Platform.runLater(() -> {
        carro.setX(585);
        carro.setY(450);
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

  public void lat42ToLeft(){
    refreshPositions();
      while((xPosition > 470) || (yPosition < 450) || (rotation < 270)){
        if(xPosition > 470){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition < 450){
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

      GlobalVariables.cornersMutex[4][3].release();

      Platform.runLater(() -> {
        carro.setX(470);
        carro.setY(450);
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

  public void lat41ToLeft(){
    refreshPositions();
      while((xPosition > 355) || (yPosition < 450) || (rotation < 270)){
        if(xPosition > 355){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition < 450){
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

      GlobalVariables.cornersMutex[4][2].release();

      Platform.runLater(() -> {
        carro.setX(355);
        carro.setY(450);
        carro.setRotate(270);
     });

      for(Double i = xPosition; i > 315; i-- ){
        final Double x = i;
        Platform.runLater(() -> {
          carro.setX(x);
        });
        try {
          Thread.sleep(velocity);
        } catch (InterruptedException e) {}
      }
  }

  public void lat40ToLeft(){
    refreshPositions();
      while((xPosition > 245) || (yPosition < 450) || (rotation < 270)){
        if(xPosition > 245){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition < 450){
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

      GlobalVariables.cornersMutex[4][1].release();

      Platform.runLater(() -> {
        carro.setX(245);
        carro.setY(450);
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

  public void lat50ToRight(){
    refreshPositions();
      while((xPosition < 200) || (yPosition < 554) || (rotation > 90)){
        if(xPosition < 200){
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

      GlobalVariables.cornersMutex[5][0].release();

      Platform.runLater(() -> {
        carro.setX(200);
        carro.setY(554);
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

  public void lat51ToRight(){
    refreshPositions();
      while((xPosition < 315) || (yPosition < 554) || (rotation > 90)){
        if(xPosition < 315){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition < 554){
          Platform.runLater(() -> {
            carro.setY(yPosition+1.0);
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

      GlobalVariables.cornersMutex[5][1].release();

      Platform.runLater(() -> {
        carro.setX(315);
        carro.setY(554);
        carro.setRotate(90);
      });

      for(Double i = xPosition; i < 355; i++ ){
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
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition < 554){
          Platform.runLater(() -> {
            carro.setY(yPosition+1.0);
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

  public void lat53ToRight(){
    refreshPositions();
      while((xPosition < 535) || (yPosition < 554) || (rotation > 90)){
        if(xPosition < 535){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition < 554){
          Platform.runLater(() -> {
            carro.setY(yPosition+1.0);
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

      GlobalVariables.cornersMutex[5][3].release();

      Platform.runLater(() -> {
        carro.setX(535);
        carro.setY(554);
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


















  //////RUAS LONGITUDENAIS

  public void long44ToUp(){
    refreshPositions();
      while((xPosition < 723) || (yPosition > 520) || (rotation > 0)){
        if(xPosition < 723){
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

      GlobalVariables.cornersMutex[5][4].release();

      Platform.runLater(() -> {
        carro.setX(723);
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

  public void long35ToUp(){
    refreshPositions();
      while((xPosition > 723) || (yPosition > 415) || (rotation > 0)){
        if(xPosition > 723){
          Platform.runLater(() -> {
            carro.setX(xPosition-1.0);
          });
        }
  
        if(yPosition > 415){
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

  public void long11ToUp(){
    refreshPositions();
      while((xPosition > 280) || (yPosition > 190) || (rotation < 0)){
        if(xPosition > 280){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.5);
          });
        }
  
        if(yPosition > 190){
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

  public void long04ToUp(){
    refreshPositions();
      while((xPosition < 723) || (yPosition > 80) || (rotation > 0)){
        if(xPosition < 723){
          Platform.runLater(() -> {
            carro.setX(xPosition+0.5);
          });
        }
  
        if(yPosition > 80){
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

      GlobalVariables.cornersMutex[1][4].release();

      Platform.runLater(() -> {
        carro.setX(723);
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

  public void long00ToDown(){
    refreshPositions();
      while((xPosition > 170) || (yPosition < 30) || (rotation > 180)){
        if(xPosition > 170){
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

      GlobalVariables.cornersMutex[0][0].release();

      Platform.runLater(() -> {
        carro.setX(170);
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

      GlobalVariables.cornersMutex[1][0].release();

      Platform.runLater(() -> {
        carro.setX(170);
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

  public void long34ToDown(){
    refreshPositions();
      while((xPosition < 615) || (yPosition < 360) || (rotation < 180)){
        if(xPosition < 615){
          Platform.runLater(() -> {
            carro.setX(xPosition+0.5);
          });
        }
  
        if(yPosition < 360){
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

      GlobalVariables.cornersMutex[3][4].release();

      Platform.runLater(() -> {
        carro.setX(615);
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

  public void long40ToDown(){
    refreshPositions();
      while((xPosition > 170) || (yPosition < 480) || (rotation > 180)){
        if(xPosition > 170){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.5);
          });
        }
  
        if(yPosition < 480){
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

      GlobalVariables.cornersMutex[4][0].release();

      Platform.runLater(() -> {
        carro.setX(170);
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

}