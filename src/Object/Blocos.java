package Object;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Blocos extends StackPane{
    Circle cr = new Circle(10, 10, 20);
    Label l=new Label();

    public Blocos(String p) {
        l.setText("");
        if (!p.equalsIgnoreCase("n")) {
            if(p.equals("0")){
                cr.setFill(Paint.valueOf("#FC8720"));
            }else
                cr.setFill(Paint.valueOf("#B26017"));
            if(p.equals("2")){
                cr.setTranslateY(-25);
            }
            this.getChildren().add(cr);
            this.getChildren().add(l);
        }
       
    }

}
