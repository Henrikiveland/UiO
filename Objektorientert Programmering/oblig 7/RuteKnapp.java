import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;


// Hva som skjer naar man trykker paa en rute.
public class RuteKnapp implements ActionListener{
    Rute rute;

    public RuteKnapp(Rute r){
       rute = r;
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        // Sjekker om knappen er hvit eller sort
        // Hvis den er sort skal beksjeden som vises til bruker endres.
        if (rute instanceof SortRute){
            rute.lab.brett.beskjed.setText(" Trykk paa en hvit rute!");
        }
        // Hvis rutem er hvis skal vi kalle paa metoden for aa finne en utvei. 
        // Og vi viser forst den forste losningen og itererer gjennom alle
        // losningene ved aa trykke paa neste lonsing knappen.
        else{
            rute.lab.brett.viserLosning = 0;
            rute.lab.GUIfinnUtveiFra(rute.kolonne, rute.rad);
        }
    }
}