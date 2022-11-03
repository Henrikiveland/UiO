
public class Lege{

  public String navn;


  public Lege(String n){
    navn = n;
  }


  public String hentNavn(){
    return navn;
  }

//Overskriver toString metoden
  @Override
  public String toString(){
    return "Legens navn: " + navn + ".";
  }

}
