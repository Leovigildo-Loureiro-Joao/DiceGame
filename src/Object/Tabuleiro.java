package Object;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.GridPane;

public class Tabuleiro extends GridPane {
    ArrayList <Blocos> nl;
    public Tabuleiro() {
        int q=0;
        nl = new ArrayList();
        String bal ="0,1,2,10,19,20,21,29,38,37,36,35,34,49,54,55,56,57,58,59,60,61";

        String p =  "110nnn010nn0110nnnnn"
                   +"nn0nnn0n0nn0nn0n0110"
                   +"nn010n0n0nn0nn010nn0"
                   +"nnnn0n0n0nn0nnnnnnn0"
                   +"01110n0n011010nnn010"
                   +"0nnnnn0nnnn0n0nnn0nn"
                   +"0111110nnnn010nnn010"
                   +"nnnnnnnnnnnnnnnnnnn0"
                   +"11n3n10nnn0110n01110"
                   +"nn2n2n01110nn010nnnn";
        this.setVgap(20);
        this.setHgap(5);
        System.out.println("");
        try {
            for (int i = 0; i < 10; i++) {   
                for (int j = 0; j < 20; j++) {
                    String l=p.charAt(q)+"";
                    Blocos ls = new Blocos(l);
                    if (ls.getChildren().size()>0){
                        System.out.print(nl.size()+" ");
                        nl.add(ls);

                    }else
                    System.out.print("-- ");
                    
                    this.add(ls, j, i);
                   q++; 
                }
                System.out.println("");
               }  
        } catch (Exception e) {
        }
    }
    public ArrayList<Blocos> getNl() {
        return nl;
    }

    
}
