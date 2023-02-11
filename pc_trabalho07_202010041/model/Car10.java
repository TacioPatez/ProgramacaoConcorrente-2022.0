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

public class Car10 extends Thread {
  private MainController control;
  private ImageView carro = new ImageView();
  private int velocity = 1;
  private Double xPosition = 202.0;
  private Double yPosition = 20.0;
  private Double rotation = 90.0;
  
  public Car10 (MainController control){
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

  try { // iniciar com 0
    GlobalVariables.latiMutex[5][0].acquire();
    GlobalVariables.specialMutex[3].acquire();
    GlobalVariables.specialMutex[16].acquire();
  } catch (InterruptedException e1) {
    e1.printStackTrace();
  }

   while(true){
    try {

      lat50ToRight();
      GlobalVariables.specialMutex[16].acquire();
      GlobalVariables.specialMutex[2].acquire();
      GlobalVariables.latiMutex[5][1].acquire();
      GlobalVariables.cornersMutex[5][1].acquire();
      GlobalVariables.latiMutex[5][0].release();
      lat51ToRight();
      GlobalVariables.latiMutex[5][2].acquire();
      GlobalVariables.cornersMutex[5][2].acquire();
      GlobalVariables.latiMutex[5][1].release();
      GlobalVariables.specialMutex[3].release();
      lat52ToRight();
      GlobalVariables.specialMutex[4].acquire();
      GlobalVariables.latiMutex[5][3].acquire();
      GlobalVariables.cornersMutex[5][3].acquire();
      GlobalVariables.latiMutex[5][2].release();
      GlobalVariables.specialMutex[2].release();
      GlobalVariables.specialMutex[16].release();
      lat53ToRight();
      GlobalVariables.longMutex[4][4].acquire();
      GlobalVariables.cornersMutex[5][4].acquire();
      GlobalVariables.latiMutex[5][3].release();
      long44ToUp();
      GlobalVariables.longMutex[3][5].acquire();
      GlobalVariables.cornersMutex[4][5].acquire();
      GlobalVariables.longMutex[4][4].release();
      long35ToUp();
      GlobalVariables.latiMutex[3][4].acquire();
      GlobalVariables.cornersMutex[3][5].acquire();
      GlobalVariables.longMutex[3][5].release();
      GlobalVariables.specialMutex[4].release();
      lat34ToLeft();
      GlobalVariables.specialMutex[17].acquire();
      GlobalVariables.specialMutex[5].acquire();
      GlobalVariables.latiMutex[3][3].acquire();
      GlobalVariables.cornersMutex[3][4].acquire();
      GlobalVariables.latiMutex[3][4].release();
      lat33ToLeft();
      GlobalVariables.latiMutex[3][2].acquire();
      GlobalVariables.cornersMutex[3][3].acquire();
      GlobalVariables.latiMutex[3][3].release();
      lat32ToLeft();
      GlobalVariables.latiMutex[3][1].acquire();
      GlobalVariables.cornersMutex[3][2].acquire();
      GlobalVariables.latiMutex[3][2].release();
      lat31ToLeft();
      GlobalVariables.latiMutex[3][0].acquire();
      GlobalVariables.cornersMutex[3][1].acquire();
      GlobalVariables.latiMutex[3][1].release();
      lat30ToLeft();
      GlobalVariables.specialMutex[3].acquire();
      GlobalVariables.longMutex[3][0].acquire();
      GlobalVariables.cornersMutex[3][0].acquire();
      GlobalVariables.latiMutex[3][0].release();
      GlobalVariables.specialMutex[5].release();
      GlobalVariables.specialMutex[17].release();
      long30ToDown();
      GlobalVariables.longMutex[4][0].acquire();
      GlobalVariables.cornersMutex[4][0].acquire();
      GlobalVariables.longMutex[3][0].release();
      long40ToDown();
      GlobalVariables.latiMutex[5][0].acquire();
      GlobalVariables.cornersMutex[5][0].acquire();
      GlobalVariables.longMutex[4][0].release();

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
   }


  }

  public void setCarVelocity(int value){
    this.velocity = value;
  }

  public void setCarImage(){
    Image image = new Image("/img/C10.png"); 
    Platform.runLater(() -> {
      carro.setImage(image);
    });
  }

  public void putCarOnScene(){
    AnchorPane ap = control.getAnchorPane();
    Platform.runLater(() -> {
      ap.getChildren().add(carro);
      carro.setX(202);
      carro.setY(554);
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


  public void lat50ToRight(){
    refreshPositions();
      while((xPosition < 205) || (yPosition < 554) || (rotation > 90)){
        if(xPosition < 205){
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
        carro.setX(205);
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
      while((xPosition < 311) || (yPosition < 554) || (rotation < 90)){
        if(xPosition < 311){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition < 554){
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

      GlobalVariables.cornersMutex[5][1].release();

      Platform.runLater(() -> {
        carro.setX(311);
        carro.setY(554);
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
      while((xPosition < 420) || (yPosition < 554) || (rotation < 90)){
        if(xPosition < 420){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition < 554){
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

      GlobalVariables.cornersMutex[5][2].release();

      Platform.runLater(() -> {
        carro.setX(420);
        carro.setY(554);
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

  public void lat53ToRight(){
    refreshPositions();
      while((xPosition < 535) || (yPosition < 554) || (rotation < 90)){
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

      GlobalVariables.cornersMutex[5][3].release();

      Platform.runLater(() -> {
        carro.setX(535);
        carro.setY(554);
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
      while((xPosition > 690) || (yPosition > 330) || (rotation > -90)){
        if(xPosition > 690){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.25);
          });
        }
  
        if(yPosition > 330){
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

  public void lat32ToLeft(){
    refreshPositions();
      while((xPosition > 470) || (yPosition > 330) || (rotation > -90)){
        if(xPosition > 470){
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

      GlobalVariables.cornersMutex[3][3].release();

      Platform.runLater(() -> {
        carro.setX(470);
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
  
  public void lat31ToLeft(){
    refreshPositions();
      while((xPosition > 360) || (yPosition > 330) || (rotation > -90)){
        if(xPosition > 360){
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

      GlobalVariables.cornersMutex[3][2].release();

      Platform.runLater(() -> {
        carro.setX(470);
        carro.setY(330);
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

  public void lat30ToLeft(){
    refreshPositions();
      while((xPosition > 250) || (yPosition > 330) || (rotation > -90)){
        if(xPosition > 250){
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

      GlobalVariables.cornersMutex[3][1].release();

      Platform.runLater(() -> {
        carro.setX(250);
        carro.setY(330);
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
      while((xPosition < 723) || (yPosition > 415) || (rotation > 0)){
        if(xPosition < 723){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
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

  public void long30ToDown(){
    refreshPositions();
      while((xPosition > 170) || (yPosition < 365) || (rotation > 180)){
        if(xPosition > 170){
          Platform.runLater(() -> {
            carro.setX(xPosition-0.5);
          });
        }
  
        if(yPosition < 365){
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

      GlobalVariables.cornersMutex[3][0].release();

      Platform.runLater(() -> {
        carro.setX(170);
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

  public void long40ToDown(){
    refreshPositions();
      while((xPosition > 170) || (yPosition < 480) || (rotation > 180)){
        if(xPosition > 170){
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

      GlobalVariables.cornersMutex[4][0].release();

      Platform.runLater(() -> {
        carro.setX(170);
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