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
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application{
    private Stage stage;
    private HashMap<String,Object[]> screens= new HashMap<>();
    private Actores[] actor;
    private Tabuleiro tab =new Tabuleiro();
    private Blocos pd;
    private int val;
    private int vez;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage= primaryStage;
        stage.setScene(new Scene( Tela(), 1000, 600));
        stage.show();        
    }
   
    public BorderPane Tela(){
        BorderPane p= new BorderPane();
        Border v =new Border();
        actor = new Actores[2];
        Inicializa();
        v.getButton().setOnMouseClicked(event -> {
            if (vez==actor.length)
                vez=0;
            //val=new Random().nextInt(5)+1;
            val=13;
            System.out.println("Dado Lancado: "+val);
            Andado(val,true);
        });
        p.getStylesheets().add("file:/C:/Users/Familia_LJ/Documents/Leovigildo/Projectos/Java/Game/src/css/geral.css");
        p.setLeft(v);
        p.setCenter(new StackPane(tab));
        for (int i = 0; i < actor.length; i++) {
            ((StackPane) p.getCenter()).getChildren().add(actor[i]);
           Reinicie(i); 
        }
        return p;
    }


    public void Andado(int r,boolean avanca){
        val = r;
        int y = actor[vez].Anda(tab.getBal(),avanca);
        pd= tab.getNl().get(y);
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
            if (val>0) {
                Andado(val,avanca);
            }else{
                if (pd.getInfo()!=null) {
                    Andado(pd.getCasas(), pd.getInfo().contains("avança"));
                }else
                vez++;

            }
        });
    }

    private void Inicializa(){
        actor[0]=new Actores("Leovigildo");
        actor[1]=new Actores("Lionel");
    }

    private void Reinicie(int i){
        actor[i].setTranslateX(-432);
        actor[i].setTranslateY(-275);
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public Stage getStage() {
        return stage;
    }

    public HashMap<String, Object[]> getScreens() {
        return screens;
    }

    public Actores[] getActor() {
        return actor;
    }

    public Tabuleiro getTab() {
        return tab;
    }

    public Blocos getPd() {
        return pd;
    }

    public int getVal() {
        return val;
    }

    
}
