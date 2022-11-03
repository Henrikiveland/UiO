import java.util.HashMap;

// Denne klassen skal bli kjort med traader saa den implementerer Runnable og run-metoden.
public class SammenFletting implements Runnable{
    Beholder beholder;
    

    public SammenFletting(Beholder b){
        beholder = b;
    }

    // Denne metoden slaar sammen to hashmaper og lager en kombinert hashmap.
    public static HashMap<String, Subsekvens> flettSammen(HashMap<String, Subsekvens> hash1, HashMap<String, Subsekvens> hash2){
        // Legger alle noklene og verdiene til hash1 inn i en ny hashmap nyHash.
        HashMap<String, Subsekvens> nyHash = hash1;

        // Gaar gjennom alle noklene i den hash2 og sjekker om de fins eller ikke i nyHash
        for (String key : hash2.keySet()) {
            // Fins nokelen i nyHash, saa slaar vi sammen antallet og gaar videre.
            if (nyHash.containsKey(key)){
                nyHash.get(key).settAntall(nyHash.get(key).hentAntall() + hash2.get(key).hentAntall());

            }
            // Hvis nokkelen ikke allerede er i nyHash, blir den lagt inn med riktige verdier.
            else{
                nyHash.put(key, hash2.get(key));
            }
        }
        return nyHash;
    }
    // Kunne kanskje ha kombinert metoden over med run metoden, men lagde de i to forskjellige 
    // omganger og bestemte at dette var lettest.
    // Denne run-metoden kjører frem til det bare er en hashmap igjen i gitt beholder.
    public void run(){
        while (beholder.antall() > 1){
            beholder.settInn(SammenFletting.flettSammen(beholder.hentUt(), beholder.hentUt()));

        }
    }

}
