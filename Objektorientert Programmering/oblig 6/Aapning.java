import java.util.ArrayList;

public class Aapning extends HvitRute{

    public Aapning(int r, int k, Labyrint l){
        super(r, k, l);

    }

    // Kommer vi til en aapning saa er vi ute av labyrinten og har funnet en utvei.
    // Aapninger skal ikke gaa videre, saa kaller ikke paa gaa-metioden her.
    public void gaa(ArrayList<Tuppel> vei){

        ArrayList<Tuppel> nyVei = new ArrayList<>(vei);
        Tuppel tupp = new Tuppel(rad, kolonne);
        nyVei.add(tupp);
        // Legger denne utveien inn i labyrinten sin liste over utveier. 
        lab.utveier.add(nyVei);
    }
}
