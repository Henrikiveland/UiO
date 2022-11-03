
// Subklasse av klassen legemiddel.
// Denne subklassen er det samme som klassen legemiddel, og har derfor ingen
// ekstra ting enn en konstruktor som kaller paa superklassen.
public class Vanlig extends Legemiddel{

  public Vanlig(String n, int p, double vs){
    super(n, p, vs);
  }

}
