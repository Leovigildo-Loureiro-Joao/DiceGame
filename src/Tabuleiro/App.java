package Tabuleiro;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import Object.Actores;
import Object.Blocos;
import Object.Border;
import Object.Tabuleiro;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application{
    private Stage stage;
    HashMap<String,Object[]> screens= new HashMap<>();
    Actores actor;
    Tabuleiro b =new Tabuleiro();

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage= primaryStage;
        stage.setScene(new Scene( Tela(), 1000, 600));
        stage.show();        
    }
    Blocos pd;
    int val;
    public BorderPane Tela(){
        BorderPane p= new BorderPane();
        Border v =new Border();
        actor = new Actores();
        v.getButton().setOnMouseClicked(event -> {
            val=new Random().nextInt(6);
          Andado(val);
        });
        p.getStylesheets().add("file:/C:/Users/Familia_LJ/Documents/Leovigildo/Projectos/Java/Game/src/css/geral.css");
        p.setLeft(v);
        p.setCenter(new StackPane(b,actor));
        actor.setTranslateX(-426);
        actor.setTranslateY(-270);
        return p;
    }


    public void Andado(int r){
        val = r;
        pd= b.getNl().get(actor.Anda());
        PauseTransition pda = new PauseTransition(Duration.millis(1000));
        pda.play();
        pda.setOnFinished(eve -> {
            ScaleTransition td = new ScaleTransition(Duration.millis(400), pd);
            td.setFromY(0.5);
            td.setToY(1);   
            td.setFromX(0.5);
            td.setToX(1);
            td.play();   
            val--; 
            if (val!=0) {
                Andado(val);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
