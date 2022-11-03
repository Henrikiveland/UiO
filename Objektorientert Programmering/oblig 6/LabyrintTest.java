
public class LabyrintTest{
    int rader;
    int kolonner;
    String[][] liste;

    public LabyrintTest(int r, int k){
        rader = r;
        kolonner = k;
        liste = new String[rader][kolonner]; 
    }

@Override
public String toString(){
    String retur = "";
    for (int i = 0; i < rader; i++){
        for (int j = 0; j < kolonner; j++){
            retur = retur + liste[i][j]; 
        }
        retur = retur + "\n";
    }
    return retur;
}















    public void skrivUt(int r, int k){
        System.out.println(liste[r][k]);
    }
    public void leggTil(int r, int k, String v){
        liste[r][k] = v;

    }


}