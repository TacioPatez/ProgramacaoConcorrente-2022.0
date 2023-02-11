/* ***************************************************************
* Autor............: Tacio Patez Freire
* Matricula........: 202010041
* Inicio...........: 20/05/2022
* Ultima alteracao.: 20/05/2022
* Nome.............: Car7
* Funcao...........: Esta classe tem a funcao de criar o Objeto Car7
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

public class Car7 extends Thread {
  private MainController control;
  private ImageView carro = new ImageView();
  private int velocity = 1;
  private Double xPosition = 202.0;
  private Double yPosition = 20.0;
  private Double rotation = 90.0;
  
  public Car7 (MainController control){
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
      lat20ToRight();
      GlobalVariables.specialMutex[9].acquire();
      GlobalVariables.latiMutex[2][1].acquire();
      GlobalVariables.cornersMutex[2][1].acquire();
      GlobalVariables.latiMutex[2][0].release();
      lat21ToRight();
      GlobalVariables.latiMutex[2][2].acquire();
      GlobalVariables.cornersMutex[2][2].acquire();
      GlobalVariables.latiMutex[2][1].release();
      lat22ToRight();
      GlobalVariables.latiMutex[2][3].acquire();
      GlobalVariables.cornersMutex[2][3].acquire();
      GlobalVariables.latiMutex[2][2].release();
      lat23ToRight();
      GlobalVariables.specialMutex[10].acquire();
      GlobalVariables.specialMutex[1].acquire();
      GlobalVariables.longMutex[1][4].acquire();
      GlobalVariables.cornersMutex[2][4].acquire();
      GlobalVariables.latiMutex[2][3].release();
      GlobalVariables.specialMutex[9].release();
      long14ToUp();
      GlobalVariables.longMutex[0][4].acquire();
      GlobalVariables.cornersMutex[1][4].acquire();
      GlobalVariables.longMutex[1][4].release();
      long04ToUp();
      GlobalVariables.latiMutex[0][3].acquire();
      GlobalVariables.cornersMutex[0][4].acquire();
      GlobalVariables.longMutex[0][4].release();
      lat03ToLeft();
      GlobalVariables.specialMutex[0].acquire();
      GlobalVariables.latiMutex[0][2].acquire();
      GlobalVariables.cornersMutex[0][3].acquire();
      GlobalVariables.latiMutex[0][3].release();
      lat02ToLeft();
      GlobalVariables.latiMutex[0][1].acquire();
      GlobalVariables.cornersMutex[0][2].acquire();
      GlobalVariables.latiMutex[0][2].release();
      GlobalVariables.specialMutex[1].release();
      lat01ToLeft();
      GlobalVariables.latiMutex[0][0].acquire();
      GlobalVariables.cornersMutex[0][1].acquire();
      GlobalVariables.latiMutex[0][1].release();
      GlobalVariables.specialMutex[0].release();
      lat00ToLeft();
      GlobalVariables.longMutex[0][0].acquire();
      GlobalVariables.cornersMutex[0][0].acquire();
      GlobalVariables.latiMutex[0][0].release();
      long00ToDown();
      GlobalVariables.longMutex[1][0].acquire();
      GlobalVariables.cornersMutex[1][0].acquire();
      GlobalVariables.longMutex[0][0].release();
      long10ToDown();
      GlobalVariables.latiMutex[2][0].acquire();
      GlobalVariables.cornersMutex[2][0].acquire();
      GlobalVariables.longMutex[1][0].release(); 
      GlobalVariables.specialMutex[10].release();

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  }

  public void setCarVelocity(int value){
    this.velocity = value;
  }

  public void setCarImage(){
    Image image = new Image("/img/C7.png"); 
    Platform.runLater(() -> {
      carro.setImage(image);
    });
  }

  public void putCarOnScene(){
    AnchorPane ap = control.getAnchorPane();
    Platform.runLater(() -> {
      ap.getChildren().add(carro);
      carro.setX(202);
      carro.setY(220);
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


  public void lat20ToRight(){
    refreshPositions();
      while((xPosition < 205) || (yPosition < 220) || (rotation > 90)){
        if(xPosition < 205){
          Platform.runLater(() -> {
            carro.setX(xPosition+0.25);
          });
        }
  
        if(yPosition < 220){
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

      GlobalVariables.cornersMutex[2][0].release();

      Platform.runLater(() -> {
        carro.setX(205);
        carro.setY(220);
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

  public void lat21ToRight(){
    refreshPositions();
      while((xPosition < 311) || (yPosition < 220) || (rotation < 90)){
        if(xPosition < 311){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition < 220){
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

      GlobalVariables.cornersMutex[2][1].release();

      Platform.runLater(() -> {
        carro.setX(311);
        carro.setY(220);
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

  public void lat22ToRight(){
    refreshPositions();
      while((xPosition < 420) || (yPosition < 220) || (rotation < 90)){
        if(xPosition < 420){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition < 220){
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

      GlobalVariables.cornersMutex[2][2].release();

      Platform.runLater(() -> {
        carro.setX(420);
        carro.setY(220);
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

  public void lat23ToRight(){
    refreshPositions();
      while((xPosition < 535) || (yPosition < 220) || (rotation < 90)){
        if(xPosition < 535){
          Platform.runLater(() -> {
            carro.setX(xPosition+1.0);
          });
        }
  
        if(yPosition < 220){
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

      GlobalVariables.cornersMutex[2][3].release();

      Platform.runLater(() -> {
        carro.setX(535);
        carro.setY(220);
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











  //////RUAS LONGITUDENAIS

  public void long14ToUp(){
    refreshPositions();
      while((xPosition < 723) || (yPosition > 190) || (rotation > 0)){
        if(xPosition < 723){
          Platform.runLater(() -> {
            carro.setX(xPosition+0.5);
          });
        }
  
        if(yPosition > 190){
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

  public void long04ToUp(){
    refreshPositions();
      while((xPosition < 723) || (yPosition > 80) || (rotation > 0)){
        if(xPosition < 723){
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


}