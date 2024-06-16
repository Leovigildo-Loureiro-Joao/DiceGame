package Tabuleiro;

import java.util.HashMap;

import Object.Actores;
import Object.Border;
import Object.Tabuleiro;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application{
    private Stage stage;
    HashMap<String,Object[]> screens= new HashMap<>();
    Actores actor;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage= primaryStage;
        stage.setScene(new Scene( Tela(), 1000, 600));
        stage.show();        
    }

    public BorderPane Tela(){
        BorderPane p= new BorderPane();
        Border v =new Border();
        actor = new Actores();
        Tabuleiro b =new Tabuleiro();
      
        v.getButton().setOnMouseClicked(event -> {
            actor.Anda();
        });
        p.getStylesheets().add("file:/C:/Users/Familia_LJ/Documents/Leovigildo/Projectos/Java/Game/src/css/geral.css");
        p.setLeft(v);
        p.setCenter(new StackPane(b,actor));
        actor.setTranslateX(-426);
        actor.setTranslateY(-270);
        return p;
    }



    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
