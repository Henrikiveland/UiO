
//Subklasse av klassen Legemiddel.
public class Narkotisk extends Legemiddel{


  protected int narkotiskStyrke;
  


  public Narkotisk(String n, int p, double vs, int ns){
    super(n, p, vs);
    narkotiskStyrke = ns;
}

  public int hentNarkotiskStyrke(){
    return narkotiskStyrke;
}

//Overskriver toStering metoden.
//returnerer toString metoden til superklassen pluss litt ekstra
  @Override
  public String toString(){
    return super.toString()+ (" Narkotiskstyrke er paa "+narkotiskStyrke+".");

  }

}
