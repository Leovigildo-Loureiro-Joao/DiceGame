package Object;

import com.jfoenix.controls.JFXButton;

import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.util.Duration;


@SuppressWarnings("rawtypes")
public class DialogGame extends Dialog{
    private ImageView img=new ImageView();
    private Label label;
    private JFXButton butt = new JFXButton(" ");
    TextField quanTextField = new TextField();

    public DialogGame() {
       this.initStyle(StageStyle.UNIFIED);
       this.initModality(Modality.APPLICATION_MODAL);
       
       this.setHeight(400);
       this.setWidth(300);
       getDialogPane().getStylesheets().add("/css/geral.css");
       
    }

    public StackPane PopUp(String info,ImageView cam) {

        StackPane p = new StackPane();
        p.setOpacity(0);
        p.setId("dialog");
        img=new ImageView(cam.getImage());
        p.setMaxSize(300, 200);
        img.setFitHeight(100);
        img.setFitWidth(100);
        img.setTranslateY(-20);
        img.setPreserveRatio(true);
        label=new Label(info);
        label.setTranslateY(50);
        p.getChildren().addAll(img,label);
        FadeTransition fad = new FadeTransition(Duration.seconds(2), p);
        fad.setFromValue(0);
        fad.setToValue(1);
        fad.setOnFinished(event -> {
            p.getStyleClass().add("active");
            FadeTransition fad1 = new FadeTransition(Duration.seconds(2), p);
            fad1.setFromValue(1);
            fad1.setToValue(0);
            fad1.play();
            fad1.setOnFinished(e -> p.getStyleClass().remove("active"));
        });
        fad.play();
        return p;
    }

    public DialogGame init(){
       
        VBox logo=new VBox(new ImageView(new Image(DialogGame.class.getResourceAsStream("../img/strategy_game_150px.png"))),new Label("Dice GAMER"));
       
        butt.setClip(new ImageView(new Image(getClass().getResourceAsStream("../img/play_144px.png"))));
        VBox vb = new VBox(logo,new Group(new Label("Informe a quantidade de jogadores"),quanTextField),butt);
        vb.setSpacing(50);
        StackPane p = new StackPane(vb);
     
        this.getDialogPane().setContent(p);
        return this;
    }

    public JFXButton getButt() {
        return butt;
    }

    public TextField getQuanTextField() {
        return quanTextField;
    }

    
    

}
