package Object;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Blocos extends StackPane{
    //private Circle cr = new Circle(10, 10, 20);
    ImageView cr = new ImageView();
    private Label l=new Label();
    private ImageView img = new ImageView();
    private Timeline t;
    private String nome;
    private int casas;
    private String info;

    public Blocos(String p) {
        l.setText("");
        img.setPreserveRatio(true);
        cr.setPreserveRatio(true);
        cr.setFitHeight(40);
        cr.setFitWidth(40);
        if (!p.equalsIgnoreCase("n")) {
            if(p.equals("2")){
                cr.setTranslateY(-25);
            }
            this.getChildren().add(cr);
            this.getChildren().add(l);
            this.getChildren().add(img);
        }
       
    }

    public void Modify(int x , int y,int w,int h,String val,String nome, int casas){
        t.stop();
        img.setTranslateX(x);
        img.setTranslateY(y-20);
        img.setFitHeight(h);
        img.setFitWidth(w);
        info = nome+" "+casas;
        this.casas=casas;
        this.nome=nome;
        img.setImage(new Image(getClass().getResourceAsStream(val)));
        cr.setImage(new Image(getClass().getResourceAsStream("../img/crafting_table_50px.png")));
         t = new Timeline(
            new KeyFrame(Duration.millis(500),new KeyValue(img.translateYProperty(),y-20)),
            new KeyFrame(Duration.millis(0),new KeyValue(img.translateYProperty(),y-25))
        );
        t.setCycleCount(Timeline.INDEFINITE);
        t.setAutoReverse(true);
        t.play();
    }


    public void Define(boolean p){
        cr.setImage(new Image(getClass().getResourceAsStream(p?"../img/cannabis_50px.png":"../img/maple_leaf_50px.png")));
        t = new Timeline(
            new KeyFrame(Duration.millis(10000),new KeyValue(cr.translateXProperty(),0),new KeyValue(cr.rotateProperty(),0)),
            new KeyFrame(Duration.millis(0),new KeyValue(cr.translateXProperty(),1),new KeyValue(cr.rotateProperty(),50))
        );
        t.setCycleCount(Timeline.INDEFINITE);
        t.setAutoReverse(true);
        t.play();
    }

    public Label getL() {
        return l;
    }

    public void setL(Label l) {
        this.l = l;
    }

    public ImageView getImg() {
        return img;
    }

    public ImageView getCr() {
        return cr;
    }

    public void setCr(ImageView cr) {
        this.cr = cr;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public Timeline getT() {
        return t;
    }

    public void setT(Timeline t) {
        this.t = t;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCasas() {
        return casas;
    }

    public void setCasas(int casas) {
        this.casas = casas;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
}
