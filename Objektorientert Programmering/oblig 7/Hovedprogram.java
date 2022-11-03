import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

// Hovedprogram for Labyrint-program.
public class Hovedprogram {
    public static void main(String[] args) {

        // Lar bruker velge fil. FileChooser koden under er kopiert av foreleser Dag Langmyhr.
        JFileChooser velger = new JFileChooser();
        int resultat = velger.showOpenDialog(null);
        if (resultat != JFileChooser.APPROVE_OPTION) 
            System.exit(1);
        File fil = velger.getSelectedFile();
        Scanner leser = null;
        try {
            leser = new Scanner(fil);
        } catch (FileNotFoundException e) {
            System.out.println("Feil i filVelger");
            System.exit(1);
        }

        // Lager en labyrint av valgt fil.
        Labyrint lab = null;
        try {
            lab = new Labyrint(fil);
        } catch (FileNotFoundException e) {
            System.out.printf("FEIL: Kunne ikke lese fra '%s'\n" );
            System.exit(1);
        }



        // Lager en JFrame med tekst Labyrint.
        JFrame vindu = new JFrame("Labyrint");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Setter inn LabyrintBrettet
        LabyrintBrett brett = new LabyrintBrett(lab);
        brett.initGUI();
        vindu.add(brett);


        vindu.pack();
        vindu.setVisible(true);
    }
}
