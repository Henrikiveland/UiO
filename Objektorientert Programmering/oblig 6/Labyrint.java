import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Labyrint{
    int rader;
    int kolonner;
    Rute[][] liste;
    String filNavn;
    ArrayList<ArrayList<Tuppel>> utveier = new ArrayList<ArrayList<Tuppel>>();
    File fil;

    // Kontruktoren tar inn en fil og oppretter en labyrint.
    public Labyrint(File innFil)throws FileNotFoundException{
        fil = innFil;
        int naverendeRad = 0;
        int naverendeKolonne = 0;
      
        // Oppretter en scanner og leser gjennom filen.
        Scanner scan;
        try {
            scan = new Scanner(fil);
        }catch(FileNotFoundException e) {
             throw new FileNotFoundException();
            }

        // Vet at forste linje er antall rader og kolonner.
        // Leser inn dette forst og lager en 2d liste med ruter.
        // Storrelsen paa liste er [rader][kolonner].
        String[] koordinater = scan.nextLine().strip().split(" ");
        rader = Integer.parseInt(koordinater[0]);
        kolonner = Integer.parseInt(koordinater[1]);
        liste = new Rute[rader][kolonner];

        // Vet at de neste linjene herifra er resten av labyrinten
        while(scan.hasNextLine()){

            // Ser gjennom rutene og lager riktig farge og legger på riktig sted i rute listen.
            String[] ruter = scan.nextLine().split("");
            for (String tegn : ruter) {
                // hvis det er en # saa er ruten sort.
                if (tegn.equals("#")){
                    liste[naverendeRad][naverendeKolonne] = new SortRute(naverendeRad, naverendeKolonne, this);
                }
                // Naa som alle de sorte rutene er utelukka, skal vi finne aapningene.
                // Det vil altsaa vaere alle rutene som er igjen paa randen av labyrinten.
                else if (naverendeKolonne == 0 || naverendeKolonne == kolonner-1 || naverendeRad == 0 || naverendeRad == rader-1){
                    liste[naverendeRad][naverendeKolonne] = new Aapning(naverendeRad, naverendeKolonne, this);
                }
                // Resten av rutene er hvite.
                else{
                    liste[naverendeRad][naverendeKolonne] = new HvitRute(naverendeRad, naverendeKolonne, this);

                }
                naverendeKolonne ++;
            }
            naverendeRad ++;
            naverendeKolonne = 0;

        }

        // Setter naboer
        // Gaar gjennpm alle rutene i listen med en dobbel for-lokke.
        for (int i = 0; i < rader; i++){
            for (int j = 0; j < kolonner; j++){
    
                Rute nord = null;
                Rute ost = null;
                Rute sor = null;
                Rute vest = null;

                // Fire if-sjekker som sjekker om hver av de fire naboene finnes.
                if ((i-1) >= 0){
                    nord = liste[i-1][j];
                }
                if ((j+1) <= (kolonner-1)){
                    ost = liste[i][j+1];
                }
                if ((i+1) <= (rader-1)){
                    sor = liste[i+1][j];
                }
                if((j-1) >= 0){
                    vest = liste[i][j-1];
                }

                // De naboene som ikke finnes forblir null og jeg setter naboene til hver rute.
                liste[i][j].settNabo(nord, ost, sor, vest);
            }
        }
    }

    // toString metode som skriver ut alle rutene i labyrinten paa riktig format.
    @Override
    public String toString(){
        String utskrift = "";
        for (int i = 0; i < rader; i++){
            for (int j = 0; j < kolonner; j++){
                utskrift = utskrift + liste[i][j].tilTegn(); 
            }
            utskrift = utskrift + "\n";
        }
        return utskrift;
        }

    // Metode som finner utveien fra et gitt punkt.
    public ArrayList<ArrayList<Tuppel>> finnUtveiFra(int k, int r){
        liste[r][k].finnUtvei();
        // Kaller på en gitt rute sin finnUtvei og lagrer utveiene i en ny liste for jeg tommer den gamle.
        ArrayList<ArrayList<Tuppel>> returUtvei = new ArrayList<>(utveier);
        // Tommer listen og resetter alle rutene saann at an kan kalle paa metoden
        // paa nytt saann at det ikke blir surr.
        utveier.clear();
        for (int i = 0; i < rader; i++){
            for (int j = 0; j < kolonner; j++){
                liste[i][j].reset(); 
            }
        }
        // returnerer alle utveiene.
        return returUtvei;
    }


}