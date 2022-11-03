import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;


// Dette eer en abstract klasse.
public abstract class Rute extends JButton {
    int rad;
    int kolonne;
    Labyrint lab;
    Rute nord;
    Rute ost;
    Rute syd;
    Rute vest;
    boolean harGaatt = false;
    ArrayList<Tuppel> vei = new ArrayList<Tuppel>();
    int ruteSize = 10;

    // Tar inn kolonne, rad og labyrint som parameter
    public Rute(int r, int k, Labyrint l){
        rad = r;
        kolonne = k;
        lab = l;
    }

    // Metode som setter naboer.
    public void settNabo(Rute n, Rute o, Rute s, Rute v){
        nord = n;
        ost = o;
        syd = s;
        vest = v;
    }

    // abstract metode som maa overskrives i subklasser.
    abstract char tilTegn();

    abstract void gaa(ArrayList<Tuppel> veienGaatt);
    abstract void reset();


    // En metode for aa velge ossen ruten skal se ut grafisk.
    abstract void initGUI();


    // Metode som setter igang gaa() metoden.
    public void finnUtvei(){
        this.gaa(vei);
    }

    // Metode som resetter ruten.

}
