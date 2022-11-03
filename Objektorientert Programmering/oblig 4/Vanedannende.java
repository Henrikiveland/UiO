
//Subklasse av klassen Legemiddel.
public class Vanedannende extends Legemiddel{

  int vanedannendeStyrke;


  public Vanedannende(String n, int p, double vs, int vandedannendeS ){
    super(n, p, vs);
    vanedannendeStyrke = vandedannendeS;

    }


  public int hentVanedannendeStyrke(){
    return vanedannendeStyrke;
    }


  //Overskriver toStering metoden.
  //returnerer toString metoden til superklassen pluss litt ekstra
  @Override
  public String toString(){
    return super.toString()+ (" Vanedannendestyrke er paa "+vanedannendeStyrke+".");
    }

}
