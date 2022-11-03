
// Klasse som holder styr paa en rute sin rad og kolonne.
public class Tuppel {
    int rad;
    int kolonne;

    public Tuppel(int r, int k){
        rad = r;
        kolonne = k;
    }

    
    // Skriver ut posisjonen
    @Override
    public String toString(){
        return "["+  kolonne + "][" + rad + "]";
    }
}
