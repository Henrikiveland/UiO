import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;


public class SortRute extends Rute{
    char sort = '#';

    public SortRute(int rad, int kolonne, Labyrint labyrint){
        super(rad, kolonne, labyrint);
    }

    @Override
    public char tilTegn(){
        return sort;
    }
    

    // Sorte ruter skal ikke gaa videre
    public void gaa(ArrayList<Tuppel> vei){
        return;
    }

    public void reset(){
        harGaatt = false;
        setBackground(Color.black);
    }


    // En metode for aa velge ossen ruten skal se ut grafisk.
    void initGUI () {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.black);
        setPreferredSize(new Dimension(ruteSize, ruteSize));
        addActionListener(new RuteKnapp(this));
    }

}
