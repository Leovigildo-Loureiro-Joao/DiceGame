package Object;

import java.util.Random;

import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Actores extends StackPane{
    int posicao;
    String andarilho="llbbllbbddddbbllllllcccccccc";

    public Actores() {
        setMaxWidth(50);
        setMaxHeight(50);
        this.getChildren().add(new Circle(5, Paint.valueOf("rgb("+new Random().nextInt(255)+","+new Random().nextInt(255)+","+new Random().nextInt(255)+")")));
    }

    public void Anda(){
       
        ScaleTransition td = new ScaleTransition(Duration.millis(500), this);
        td.setFromY(2);
        td.setToY(1);   
        td.setFromX(2);
        td.setToX(1);   
        td.play();
        if (andarilho.charAt(posicao)=='l'||andarilho.charAt(posicao)=='d') {
            TranslateTransition tr= new TranslateTransition(Duration.millis(500), this) ;
            tr.setFromX(this.getTranslateX());        
            tr.setToX(this.getTranslateX()+(andarilho.charAt(posicao)=='l'?43:-43));   
            tr.play();
        }else{
            TranslateTransition tr= new TranslateTransition(Duration.millis(500), this) ;
            tr.setFromY(this.getTranslateY());        
            tr.setToY(this.getTranslateY()+(andarilho.charAt(posicao)=='c'?-60:60));   
            tr.play();
        }
        posicao++;
  
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getAndarilho() {
        return andarilho;
    }

    public void setAndarilho(String andarilho) {
        this.andarilho = andarilho;
    }

    

}
