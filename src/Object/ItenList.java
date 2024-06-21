package Object;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class ItenList extends HBox{
    int posicao;
    String classificacao;
    public ItenList(String classificacao, int posicao,Paint cor) {
        this.classificacao=classificacao;
        this.posicao=posicao;
         this.getChildren().addAll( new Circle(5, cor),new Label(classificacao));
    }
    
    public int getPosicao() {
        return posicao;
    }
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    public String getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    
}
