import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

// Denne klassen skal bli kjort med traader saa den implementerer Runnable og run-metoden.
public class LesFil implements Runnable{

    static int sekvensLengde;
    String filNavn;
    Beholder hashMapsBeholder;


    public LesFil(int SekvnsLen, String filN, Beholder hashMapsB) {
        filNavn = filN;
        hashMapsBeholder = hashMapsB;
        sekvensLengde = SekvnsLen;
    }
    // Denne run-metoden blir kjort av en traad.
    public void run(){

        String linje;
        String sekvens;
        try {
            Scanner scan = new Scanner(new File("Data/" + filNavn));

            HashMap<String,Subsekvens>  subsekvensHashmap = new HashMap <> ();		
            System.out.println(" Programmet leser filen: " + filNavn );

            // Her har jeg faatt hjelp av losningsforlsaget til ukesoppgaver uke 8. 
            while(scan.hasNextLine()) {
                linje = scan.nextLine();
                linje = linje.trim();
                // Her sjekkes hver subsekvens med riktig sekvenslengde gjennom hele lengden av bokstaver.
                for (int pos = 0; pos + sekvensLengde <= linje.length(); pos ++) {
                    sekvens = linje.substring(pos, pos + sekvensLengde);
                    // Hvis subsekvensen allerde er i hashmapen ignoreres linjen under, men hvis ikke 
                    // saa blir subsekvensen lagt inn i hashmapen.
                    subsekvensHashmap.putIfAbsent(sekvens,new Subsekvens(sekvens));
                }
            }
            scan.close();
            hashMapsBeholder.settInn(subsekvensHashmap);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

}
