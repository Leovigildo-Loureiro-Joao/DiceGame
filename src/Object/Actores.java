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
    private String nome;
    private String andarilho;
    private final String andarilhC="llbbllbbddddbbllllllccccccllbbbblllllbbddcCccclllbbllclllbbbddbbllbbddddbddcdddbddddcdGTGTd";
    private final String andarilhI="ddccddccllllccddddddbbbbbbddccccdddddccllbBbbbdddccddbdddcccllccddccllllcllblllcllllblGTGTl";
    public Actores(String nome) {
        setMaxWidth(50);
        setMaxHeight(50);
        this.nome=nome;
        this.getChildren().add(new Circle(5, Paint.valueOf("rgb("+new Random().nextInt(255)+","+new Random().nextInt(255)+","+new Random().nextInt(255)+")")));
    }
        /* 
        l: inidica a esquerda L: inidica a Megaesquerda 
        d: inidica a direita D: inidica a Megadireita
        c: inidica cima C: inidica a Megacima
        b: inidica baixo B: inidica a Megabaixo
        T: inidica Diogonal Direita cima   G: inidica Diogonal Direita baixo
        P: inidica Diogonal esquerda cima   H: inidica Diogonal esquerda baixo
        */
    public int Anda(String t,boolean avanca){
        andarilho=avanca?andarilhC:andarilhI;
        ScaleTransition td = new ScaleTransition(Duration.millis(500), this);
        td.setFromY(2);
        td.setToY(1);   
        td.setFromX(2);
        td.setToX(1);   
        td.play();
        if (!avanca) {
            posicao--;  
        }
        if (andarilho.charAt(posicao)=='l'||andarilho.charAt(posicao)=='d') {
            int valor = posicao%4==0?48:44;
            Move((andarilho.charAt(posicao)=='l'?valor:-1*valor), 0);
        }else if ((andarilho.charAt(posicao)=='T')||(andarilho.charAt(posicao)=='G')) {
            int valor = (posicao%4==0?48:44)*-1;
            Move(valor, (andarilho.charAt(posicao)=='T'?-45:45));
        }else if (andarilho.charAt(posicao)=='P'||andarilho.charAt(posicao)=='H') {
            int valor = posicao%4==0?48:44;
            Move(valor, (andarilho.charAt(posicao)=='P'?-45:45));
        }else{
            Move(0, (andarilho.charAt(posicao)=='c'?-60:(andarilho.charAt(posicao)=='C'?-120:60)));
        }
        if (avanca)
            posicao++  ;
        return Integer.parseInt(t.split(",")[posicao]);
    }

    private void Move(int xval,int yval){
        TranslateTransition tr= new TranslateTransition(Duration.millis(500), this) ;
        if (xval!=0) {
            tr.setFromX(this.getTranslateX());        
            tr.setToX(this.getTranslateX()+xval); 
        }if (yval!=0) { 
            tr.setFromY(this.getTranslateY());
            tr.setToY(this.getTranslateY()+yval); 
        }  
        tr.play(); 
        tr.setOnFinished(tds -> {
            System.out.println("Actor: "+nome+" x:"+this.getTranslateX()+" y:"+this.getTranslateY());
        });
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

    public String getNome() {
        return nome;
    }


}
