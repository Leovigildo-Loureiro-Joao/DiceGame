package Object;

import com.jfoenix.controls.JFXButton;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class Border extends StackPane{
    private JFXButton button;
    private JFXButton logo=new JFXButton("Dice GAMER");;
    private JFXButton button2=new JFXButton(" ");
    private JFXButton button3=new JFXButton(" ");
    private Dados dados=new Dados();
    public JFXButton getButton() {
        return button;
    }
    public void setButton(JFXButton button) {
        this.button = button;
    }
    public Border() {
        logo.setClip(new ImageView(new Image(getClass().getResourceAsStream("../img/strategy_game_150px.png"))));
        logo.setTranslateY(-250);
        logo.setTranslateX(-40);
        logo.setMaxSize(100, 100);
        button2.setClip(new ImageView(new Image(getClass().getResourceAsStream("../img/pause_480px.png"))));
        button2.setTranslateX(30);
        button3.setClip(new ImageView(new Image(getClass().getResourceAsStream("../img/stop_144px.png"))));
        HBox hb = new HBox(button2,button3);
        hb.setTranslateY(-150);
        hb.setSpacing(10);
        hb.setMaxHeight(90);
        this.getChildren().addAll(logo,hb,dados);
    }
    public Dados getDados() {
        return dados;
    }

    
}
