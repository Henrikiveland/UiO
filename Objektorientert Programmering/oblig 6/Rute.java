import java.util.ArrayList;

// Dette eer en abstract klasse.
public abstract class Rute {
    int rad;
    int kolonne;
    Labyrint lab;
    Rute nord;
    Rute ost;
    Rute syd;
    Rute vest;
    boolean harGaatt = false;
    ArrayList<Tuppel> vei = new ArrayList<Tuppel>();

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


    // Metode som setter igang gaa() metoden.
    public void finnUtvei(){
        this.gaa(vei);
    }

    // Metode som resetter harGatt varibelen.
    public void reset(){
        harGaatt = false;
    }


}
