import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;


// Subklasse av Rute.
public class HvitRute extends Rute{
    char hvit = '.';

    public HvitRute(int rad, int kolonne, Labyrint labyrint){
        super(rad, kolonne, labyrint);
    }

    @Override
    public char tilTegn(){
        return hvit;
    }

    // Starter rekusjon-metoden
    public void gaa(ArrayList<Tuppel> vei){

        //Sjekker om ruten har blitt gaatt for.
        if (harGaatt == false){
            harGaatt = true;
            // Lager en ny kopi av veien som er gaatt.
            ArrayList<Tuppel> nyVei = new ArrayList<>(vei);
            // Legger inn en tuppel naavaerende rute i har gaatt listen.
            Tuppel tupp = new Tuppel(rad, kolonne, this);
            nyVei.add(tupp);

            // Sjekker om naboene finnes og kaller paa gaa-metodene dems.
            if (nord != null){
                nord.gaa(nyVei);
            }

            if (ost != null){
                ost.gaa(nyVei);
            }

            if (syd != null){
                syd.gaa(nyVei);
            }

            if (vest != null){
                vest.gaa(nyVei);
            }
        }
    }


    // En metode for aa velge ossen ruten skal se ut grafisk.
    void initGUI () {
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        setBackground(Color.white);
        setPreferredSize(new Dimension(ruteSize, ruteSize));
        // Legger til hva som skal se naar knappen trykkes paa.
        addActionListener(new RuteKnapp(this));
    }

    // En metode som resetter ruten.
    public void reset(){
        harGaatt = false;
        setBackground(Color.white);
        lab.brett.beskjed.setText("");
    }

}