
// Klasse som holder styr paa en rute sin rad og kolonne.
public class Tuppel {
    int rad;
    int kolonne;
    Rute rute;

    public Tuppel(int ra, int k, Rute ru){
        rad = ra;
        kolonne = k;
        rute = ru;

    }

    
    // Skriver ut posisjonen
    @Override
    public String toString(){
        return "["+  kolonne + "][" + rad + "]";
    }
}
