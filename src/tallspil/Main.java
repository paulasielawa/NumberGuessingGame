package tallspil;

import java.util.InputMismatchException;
import static javax.swing.JOptionPane.*;

class Tallspill {
    private int slumptall;

    public int nyttTall() {
        slumptall = (int) (Math.random()* 201);
        return slumptall;
    }
    public String visMelding(){
        return showInputDialog("Jeg tenker på et tall mellom 0 og 200.\nPrøv å gjette på tallet: ");
    }
    private void forLite(int tall){
            showMessageDialog(null,tall + " er for lite! Prøv igjen!");
    }
    private void forStort(int tall) {
            showMessageDialog(null,tall + " er for stor! Prøv igjen!");
    }
    public void avsluttRunde(int antall, int gjetning) {
        showMessageDialog(null,antall + " er riktig! Du gjettet riktig på " + gjetning +
                " forsøk.");
    }
    public void kjørSpill() {
        int tilfeldigTall = nyttTall();
        int userInput = 0;
        int gjetning = 0;


        while (userInput!=tilfeldigTall){
            gjetning++;
            try {
                userInput = Integer.parseInt(visMelding());
            } catch (Exception e) {
                System.out.println("Du må skrive et tall. Feil " + e);
            }
            if (userInput < tilfeldigTall) {
                    forLite(userInput);
            }
            if (userInput > tilfeldigTall) {
                    forStort(userInput);
            }
        }

        if(userInput == tilfeldigTall) {
            avsluttRunde(userInput,gjetning);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Tallspill person = new Tallspill();
        person.kjørSpill();
    }
}