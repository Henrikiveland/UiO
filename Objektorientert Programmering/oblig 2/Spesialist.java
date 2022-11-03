
// Dette er en subklasse av klassen lege og den implementerer grensesnittet
// Godkjenningsfritak.
public class Spesialist extends Lege implements Godkjenningsfritak{

  protected String kontrollID;

  public Spesialist(String navn, String kId){
    super(navn);
    kontrollID = kId;
  }

  // Overskriver metoden fra grensesnittet.
  @Override
  public String hentKontrollID(){
    return kontrollID;
  }

 // Overskriver toString metoden.
  @Override
  public String toString(){
  return "Spesialist sitt navn: " + navn + ". KontrollID: "+ kontrollID;

  }
}
