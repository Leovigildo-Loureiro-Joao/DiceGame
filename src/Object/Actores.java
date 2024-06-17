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
    private int posicao;
    private String andarilho="llbbllbbddddbbllllllccccccllbbbblllllbbddccccccllbbllclllbbbddbbllbbddddbddcdddbddddcd";
    public Actores() {
        setMaxWidth(50);
        setMaxHeight(50);
        this.getChildren().add(new Circle(5, Paint.valueOf("rgb("+new Random().nextInt(255)+","+new Random().nextInt(255)+","+new Random().nextInt(255)+")")));
    }

    public int Anda(){
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
            tr.setToY(this.getTranslateY()+(andarilho.charAt(posicao)=='c'?-60:(andarilho.charAt(posicao)=='C'?-120:60)));   
            tr.play();
        }
        posicao++;      
        String bal ="0,1,2,10,19,20,21,29,38,37,36,35,34,49,54,55,56,57,58,59,60,50,39,30,22,11,3,4,5,12,23,31,40,41,42,43,44,45,52,63,62,61,51,32,24,13,6,7,8,9,14,25,26,27,15,16,17,18,28,33,48,47,46,53,64,65,66,67,81,80,79,78,77,91,90,89,76,75,74,73,88,87,86,85,84,72,71,83,70,82,69,68";
        return Integer.parseInt(bal.split(",")[posicao]);
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
