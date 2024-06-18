package Tabuleiro;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import Object.Actores;
import Object.Blocos;
import Object.Border;
import Object.Dados;
import Object.Dialog;
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
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class App extends Application{
    private Stage stage;
    private HashMap<String,Object[]> screens= new HashMap<>();
    private Actores[] actor;
    private Tabuleiro tab =new Tabuleiro();
    private Blocos pd;
    private int val;
    private int vez;
    private BorderPane p= new BorderPane();
    private Border borda =new Border();
    private Dialog dialog=new Dialog();
    StackPane fundo;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage= primaryStage;
        stage.setScene(new Scene( Tela(), 1140, 630));
        stage.initStyle(StageStyle.UNDECORATED);    
        stage.show();   
    }
   
    public BorderPane Tela(){
        fundo=new StackPane(tab,dialog);
        fundo.getStyleClass().add("fundo");
        actor = new Actores[2];
        Inicializa();
        borda.getDados().setOnMouseClicked(event -> {
            val=4;
            if (vez==actor.length)
                vez=0;
            borda.getDados().Video(val);
            PauseTransition pa= new PauseTransition(Duration.millis(100));
            pa.setCycleCount(15);
            pa.setOnFinished(ev ->  Andado(val, true));
            pa.play();
        });
        p.getStylesheets().add("file:/C:/Users/Familia_LJ/Documents/Leovigildo/Projectos/Java/Game/src/css/geral.css");
        p.setLeft(borda);
        p.setCenter(fundo);
        for (int i = 0; i < actor.length; i++) {
            fundo.getChildren().add(actor[i]);
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
                    dialog.PopUp( pd.getInfo(),  pd.getImg());
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
