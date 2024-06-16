package Object;

import javafx.scene.layout.GridPane;

public class Tabuleiro extends GridPane {
    public Tabuleiro() {
        int q=0;
        int c=0;
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
        try {
            for (int i = 0; i < 10; i++) {   
                for (int j = 0; j < 20; j++) {
                    String l=p.charAt(q)+"";
                    c=!l.equalsIgnoreCase("n")?c+1:c;
                    Blocos ls = new Blocos(l);
                   this.add(ls, j, i);
                   q++; 
                }
               }  
        } catch (Exception e) {
        }
    }
}
