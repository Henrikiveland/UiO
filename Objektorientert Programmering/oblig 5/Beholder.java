import java.util.ArrayList;
import java.util.HashMap;

// Klasse for å holde på flere subsekvenser.
public class Beholder {
    // Lager en arrayliste som holder på Hashmaper som holder på String og subsekvenser.
    ArrayList<HashMap<String, Subsekvens>> liste = new ArrayList<HashMap<String, Subsekvens>>();

    public void settInn(HashMap<String, Subsekvens> hash){
        liste.add(hash);

    }
    public HashMap<String, Subsekvens> hentUt(){
        
        HashMap<String, Subsekvens> hashmap = liste.get(0);
        liste.remove(0);
        return hashmap;

    }

    public int antall(){
        return liste.size();
    }
    
}
