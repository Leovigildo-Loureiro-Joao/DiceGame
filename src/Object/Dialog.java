package Object;

import javafx.animation.FadeTransition;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Dialog extends StackPane{
    private ImageView img=new ImageView();
    Label label;

    public Dialog() {
        this.setMaxSize(200, 200);
    }
    public void PopUp(String info,ImageView cam) {
        img=new ImageView(cam.getImage());
        this.getStyleClass().add("active");
        img.setFitHeight(100);
        img.setFitWidth(100);
        img.setPreserveRatio(true);
        label=new Label(info);
        label.setTranslateY(50);
        this.getChildren().addAll(img,label);
        FadeTransition fad = new FadeTransition(Duration.seconds(1), this);
        fad.setFromValue(0);
        fad.setToValue(1);
        fad.setOnFinished(event -> {
            FadeTransition fad1 = new FadeTransition(Duration.seconds(1), this);
            fad1.setFromValue(1);
            fad1.setToValue(0);
            fad1.play();
            fad1.setOnFinished(e -> this.getStyleClass().remove("active"));
        });
        fad.play();
    }

    public static StackPane init(){
        StackPane p = new StackPane();
        this.setMaxSize(200, 200);
        return p;
    }

}
