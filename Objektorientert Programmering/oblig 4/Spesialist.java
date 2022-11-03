
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



  // De fire metodene under lager resepter. Det er samme metode som i lege-klassen, bare at 
  // spesialister for lov til aa lage resepter paa narkotiske legemiddler.
  // Resepten blir lgat inn i spesialisten og pasienten sin liste.
  @Override
  public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit){

      HvitResept resept = new HvitResept(legemiddel, this, pasient , reit);
      utskrevedeResepter.leggTil(resept);
      pasient.hentReseptListe().leggPaa(resept);
      return resept;
      
  }

  @Override
  public MilitaerResept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit){
   
      MilitaerResept resept = new MilitaerResept(legemiddel, this, pasient , reit);
      utskrevedeResepter.leggTil(resept);
      pasient.hentReseptListe().leggPaa(resept);
      return resept; 
  }

  @Override
  public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient){
    
      PResept resept = new PResept(legemiddel, this, pasient);
      utskrevedeResepter.leggTil(resept);
      pasient.hentReseptListe().leggPaa(resept);
      return resept;
  }


  @Override
  public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit){
      
        BlaaResept resept = new BlaaResept(legemiddel, this, pasient , reit);
        utskrevedeResepter.leggTil(resept);
        pasient.hentReseptListe().leggPaa(resept); 
        return resept; 
    }














}
