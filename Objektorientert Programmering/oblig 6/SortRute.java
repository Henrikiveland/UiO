import java.util.ArrayList;

public class SortRute extends Rute{
    char sort = '#';

    public SortRute(int rad, int kolonne, Labyrint labyrint){
        super(rad, kolonne, labyrint);
    }

    @Override
    public char tilTegn(){
        return sort;
    }
    

    // Sorte ruter skal ikke gaa videre
    public void gaa(ArrayList<Tuppel> vei){
        return;
    }
}
