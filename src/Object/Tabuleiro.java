package Object;
import java.util.ArrayList;
import javafx.scene.layout.GridPane;

public class Tabuleiro extends GridPane {
    private ArrayList <Blocos> nl;
    private String bal ;
    private int[] sorteCasas={19,60,51,15,77};
    private int[] azarCasas={79,87,49,30,12,84,26};

    public Tabuleiro() {
        int q=0;
        nl = new ArrayList();
        bal ="0,1,2,10,19,20,21,29,38,37,36,35,34,49,54,55,56,57,58,59,60,50,39,30,22,11,3,4,5,12,23,31,40,41,42,43,44,45,52,63,62,61,51,32,24,13,6,7,8,9,14,25,26,27,15,16,17,18,28,33,48,47,46,53,64,65,66,67,81,80,79,78,77,91,90,89,76,75,74,73,88,87,86,85,84,72,71,83,70,82,69,68";
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
        String [] po= bal.split("62");
        System.out.println("");
        try {
            for (int i = 0; i < 10; i++) {   
                for (int j = 0; j < 20; j++) {
                    String l=p.charAt(q)+"";
                    Blocos ls = new Blocos(l);
                    if (ls.getChildren().size()>0){
                        System.out.print(nl.size()+" ");
                        ls.Define(po[0].contains(nl.size()+""));
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
        nl.get(azarCasas[0]).Modify(0, -35, 50, 50, "../img/1.jpg","Tempestade devastadara recue",5);
        nl.get(azarCasas[1]).Modify(0, 0, 25, 25, "../img/2.jpg","Morte Toxica",0);
        nl.get(azarCasas[2]).Modify(0, 0, 25, 25, "../img/3.jpg","Foste faqueado recue",4);
        nl.get(azarCasas[3]).Modify(0, 0, 25, 30, "../img/4.jpg","Queimaste nas chamas recue ",3);
        nl.get(azarCasas[4]).Modify(0, 0, 25, 30, "../img/5.jpg","A Cobra te mordeu recue",5);
        nl.get(azarCasas[5]).Modify(0, 0, 25, 25, "../img/2.jpg","Morte Toxica",-1);
        nl.get(azarCasas[6]).Modify(0, 0, 25, 25, "../img/4.jpg","Queimaste nas chamas recue",3);

        nl.get(sorteCasas[0]).Modify(0, 0, 25, 25, "../img/1.png","Maçã avança",3);
        nl.get(sorteCasas[1]).Modify(0, 0, 25, 25, "../img/2.png","Encontraste um yati avança ",5);
        nl.get(sorteCasas[2]).Modify(0, 0, 25, 25, "../img/3.png","Tiveste uma otima Ideia avança ",4);
        nl.get(sorteCasas[3]).Modify(0, 0, 25, 25, "../img/4.png","Speed Acelere avançando ",6);
        nl.get(sorteCasas[4]).Modify(0, 0, 25, 25, "../img/5.png","Surf cara e avança ",4);
        
    }
    public ArrayList<Blocos> getNl() {
        return nl;
    }
    public String getBal() {
        return bal;
    }

    
}
