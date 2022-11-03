import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class Labyrint extends JPanel{
    int rader;
    int kolonner;
    Rute[][] liste;
    String filNavn;
    ArrayList<ArrayList<Tuppel>> utveier = new ArrayList<ArrayList<Tuppel>>();
    File fil;
    LabyrintBrett brett;

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



    // Lager labyrinten grafisk.
    public void initGUI (){

        // Velger et rutenett som layout med rader * kolonner som storrelse.
        setLayout(new GridLayout(rader,kolonner));

        // Gaar gjennom hver rute i listen og bruker tilhorende GUI-metode og legger til i rutenettet.
        for (int i = 0; i < rader; i++){
            for (int j = 0; j < kolonner; j++){
                liste[i][j].initGUI(); 
                add(liste[i][j]);
            }
        }
    }



    // Bruker finnUtveiFra som tener ut utveien paa labyrinten.
    public void GUIfinnUtveiFra(int k, int r){
        brett.valgtKolonne = k;
        brett.valgtRad = r;
        
        // Henter ut alle utveier fra gitt punkt via finnUtveiFra-metoden.
        ArrayList<ArrayList<Tuppel>> returUtveier = new ArrayList<>(finnUtveiFra(k, r));

        // Hvis storrelsen er null saa gis det beksjed til bruker at det ikke finnes noe losning.
        if (returUtveier.size()==0){
            brett.beskjed.setText("Ingen losning");
        }
        else{
            

            // Hvis bretter har flere losninger, skal den vise forste losning
            // forste gangen. viserLosning blir endret og okt med en et annet sted.
            // Naar alle losningene har blitt vist, gaar det tilbake til aa vise den forste igjen.
            if (returUtveier.size()<= brett.viserLosning){
                brett.viserLosning = 0;
            }
            
            // Henter den forste utveien i lista.
            ArrayList<Tuppel> viserUtvei = returUtveier.get(brett.viserLosning);

            //Skifter farge paa de rutene som er i losningslista.
            for (Tuppel tuppel : viserUtvei) {
                tuppel.rute.setBackground(Color.red);
            }

            // Endrer tekst.
            brett.antallLosninger.setText(" Antall losninger: "+returUtveier.size()+". ");
            brett.jviserLosning.setText(" Viser losningnr: "+((brett.viserLosning)+1)+". ");
            }
        }


    // Metode for aa faa en referanse til hvilket brett labyrinten tilhorer.
    public void settBrett(LabyrintBrett b){
        brett = b;
        }

}

