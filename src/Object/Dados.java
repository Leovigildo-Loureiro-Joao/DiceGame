package Object;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Dados extends ImageView{

    int i=1;
    public Dados() {
        this.setImage(new Image(getClass().getResourceAsStream("../img/"+i+"C.png")));
    }

    public void Video(int r) {
        Timeline tm = new Timeline(new KeyFrame(Duration.millis(100),e -> {
            this.setImage(new Image(getClass().getResourceAsStream("../img/cuboM"+i+".png")));
            i=i==5?1:i+1;
        }),new KeyFrame(Duration.ZERO));
        tm.setCycleCount(15);
        tm.play();
        tm.setOnFinished(event -> {
            this.setImage(new Image(getClass().getResourceAsStream("../img/"+r+"C.png")));
            
        });
    }  
    
    
}
