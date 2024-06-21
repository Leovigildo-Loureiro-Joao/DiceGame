package Object;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Border extends StackPane{
    private JFXButton button;
    private VBox logo;
    private JFXButton button2=new JFXButton(" ");
    private JFXButton button3=new JFXButton(" ");
    private Dados dados=new Dados();
    private ListView<ItenList> listaGamer=new ListView<ItenList>();
    public JFXButton getButton() {
        return button;
    }
    public void setButton(JFXButton button) {
        this.button = button;
    }
    public Border() {
        logo=new VBox(new ImageView(new Image(getClass().getResourceAsStream("../img/strategy_game_150px.png"))),new Label("Dice GAMER"));
       
        button2.setClip(new ImageView(new Image(getClass().getResourceAsStream("../img/pause_480px.png"))));
        button2.setTranslateX(30);
        button3.setClip(new ImageView(new Image(getClass().getResourceAsStream("../img/stop_144px.png"))));
        HBox hb = new HBox(button2,button3);
        hb.setTranslateY(-150);
        logo.setTranslateY(-250);
        hb.setSpacing(10);
        hb.setMaxHeight(90);
        listaGamer.setMaxHeight(200);
        VBox vb= new VBox(new Label("Clique no dado para jogar"),dados);
        vb.setTranslateY(-50);
        vb.setSpacing(40);
        this.getChildren().addAll(logo,hb,vb,listaGamer);
    
    }
    public Dados getDados() {
        return dados;
    }
    public ListView<ItenList> getListaGamer() {
        return listaGamer;
    }

    
    
}
