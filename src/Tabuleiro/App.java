package Tabuleiro;

import java.util.HashMap;
import java.util.Random;

import Object.Actores;
import Object.Blocos;
import Object.Border;
import Object.DialogGame;
import Object.ItenList;
import Object.Tabuleiro;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Scene;
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
    private DialogGame dialog=new DialogGame();
    StackPane fundo;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage= primaryStage;
        stage.setScene(new Scene( Tela(), 1140, 630));
        stage.initStyle(StageStyle.UNDECORATED);   
        dialog.init().show();
        dialog.getButt().setOnAction(event -> {
            if (!dialog.getQuanTextField().getText().isBlank()) {
                Inicializa(Integer.parseInt(dialog.getQuanTextField().getText()));
                dialog.hide();
                stage.show();
            }
        });
    }
   
    public BorderPane Tela(){
        fundo=new StackPane(tab);
        fundo.getStyleClass().add("fundo");
        borda.getDados().setOnMouseClicked(event -> {
            val=new Random().nextInt(6)+1;
            if (vez==actor.length)
                vez=0;
            borda.getDados().Video(val);
            PauseTransition pa= new PauseTransition(Duration.millis(100));
            pa.setCycleCount(15);
            pa.setOnFinished(ev ->  Andado(val, true));
            pa.play();
        });
        p.getStylesheets().add("/css/geral.css");
        p.setLeft(borda);
        p.setCenter(fundo);
        return p;
    }


    public void Andado(int r,boolean avanca){
        if ( actor[vez].getLocal()<107) {
            val = r;
            int y = actor[vez].Anda(r==-1?null:tab.getBal(),avanca);
            pd= tab.getNl().get(y);
            PauseTransition pda = new PauseTransition(Duration.millis(800));
            pda.play();
            pda.setOnFinished(eve -> {
                ScaleTransition td = new ScaleTransition(Duration.millis(300), pd);
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
                        fundo.getChildren().add(dialog.PopUp( pd.getInfo(),  pd.getImg()));
                        Andado(pd.getCasas(), pd.getInfo().contains("avança"));
                    }else{
                        vez++;
                        Actualiza();
                    }
                       
                }
            });
        }else{
            stage.close();
        }
       
    }

    private void Inicializa(int n){
        actor = new Actores[n];
        for (int i = 0; i < actor.length; i++) {
            actor[i]=new Actores(i);
            fundo.getChildren().add(actor[i]);
            Reinicie(i);
            borda.getListaGamer().getItems().add(new ItenList(actor[i].getClassificacao(), actor[i].getPosicao(), actor[i].getCor()));
        }
    }

    private void Actualiza(){
        for (int i = 0; i < actor.length; i++) {
            borda.getListaGamer().getItems().set(i,new ItenList(actor[i].getClassificacao(), actor[i].getPosicao(), actor[i].getCor()));
        }
        borda.getListaGamer().getItems().sort((o1, o2) -> {
            return o2.getPosicao() - o1.getPosicao();
        });
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
