// Klasse for å behalde og holde på en subsekvens
public class Subsekvens {
    private int antall = 1;
    private String subsekvens;
    public Subsekvens(String subSekv){
        subsekvens = subSekv;
    }


public void settSekvens(String subSekv){
    subsekvens = subSekv;
}
public String hentSekvens(){
    return subsekvens;
}

public void settAntall(int tall){
    antall = tall;
}

public int hentAntall(){
    return antall;
}
    
}
