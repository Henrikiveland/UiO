import java.util.ArrayList;

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
            Tuppel tupp = new Tuppel(rad, kolonne);
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
}