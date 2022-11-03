
class Lege implements Comparable<Lege>{

  protected String navn;
  
  // Lager en lenkeliste som tar vare på reseptene som legen lager.
  Lenkeliste<Resept> utskrevedeResepter = new Lenkeliste<>();

  public Lege(String n){
    navn = n;
  }

  // Metode som gjør at vi kan sammenligne leger med andre leger ved navn.
  @Override
  public int compareTo(Lege lege){

    return navn.compareTo(lege.hentNavn());

  }


  // Her går vi gjennom alle reseptene som legen har skrevet ut og sjekker om det er 
  // av typen vanedannende. Til slutt returneres antall vanedannedne legemidler som legen
  // har skrevet ut tilsammen.
  public int tellVanedannende() {
    int teller = 0;
    for (Resept resept : utskrevedeResepter) {
      if (resept.hentLegemiddel() instanceof Vanedannende) {
        teller++;
      }
    }
    return teller;
  }
  
  // Her går vi gjennom alle reseptene som legen har skrevet ut og sjekker om det er 
  // av typen narkotisk. Til slutt returneres antall narkotiske legemidler som legen
  // har skrevet ut tilsammen.
  public int tellNarkotisk() {
    int teller = 0;
    for (Resept resept : utskrevedeResepter) {
      if (resept.hentLegemiddel() instanceof Narkotisk){
        teller++;
      } 
    }
    return teller;
  }
  
  // De fire metodene under lager resepter. Forst sjekker vi om legemiddelet er narkotsik.
  // Hvis det er det saa for ikke legen lov til aa lage denne resepten, det er det bare 
  // spesialister som kan. Hvis det ikke er narkotisk, blir resepten lkaget og lagt inn i 
  // listen til legen og pasienten.
  
  public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    
    if (legemiddel instanceof Narkotisk){
      throw new UlovligUtskrift(this, legemiddel, pasient.hentId());
    }
    else{

      HvitResept resept = new HvitResept(legemiddel, this, pasient , reit);
      utskrevedeResepter.leggTil(resept);
      pasient.hentReseptListe().leggPaa(resept);
      return resept;
      
    }
  }
  
  public MilitaerResept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
    
   
    if (legemiddel instanceof Narkotisk){
      throw new UlovligUtskrift(this, legemiddel, pasient.hentId());
    }
    else{

      MilitaerResept resept = new MilitaerResept(legemiddel, this, pasient , reit);
      utskrevedeResepter.leggTil(resept);
      pasient.hentReseptListe().leggPaa(resept);
      return resept;
    }
  }
  

  public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
  
    if (legemiddel instanceof Narkotisk){
      throw new UlovligUtskrift(this, legemiddel, pasient.hentId());
    }
    else{

        PResept resept = new PResept(legemiddel, this, pasient);
        utskrevedeResepter.leggTil(resept);
        pasient.hentReseptListe().leggPaa(resept);
        return resept;
      }
  }
  
  public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift{
      
      if (legemiddel instanceof Narkotisk){
          throw new UlovligUtskrift(this, legemiddel, pasient.hentId());
     }
      else{

        BlaaResept resept = new BlaaResept(legemiddel, this, pasient , reit);
        utskrevedeResepter.leggTil(resept);
        pasient.hentReseptListe().leggPaa(resept); 
        return resept;
    
        }
      }
    

  public Lenkeliste<Resept> hentUtskrevendeResepter(){

    return utskrevedeResepter;

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
