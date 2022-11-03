
// Oppretter en abstract klasse, det vil si at man ikke kan lage objekter av
// denne klassen, men man kan lage pekere av denne klassen.
abstract class Resept{

  // Lager en static teller som gar opp for hvert objekt som blir lagd, det vil
  // si at hvert objekt far en unik id.
  protected static int reseptIdTeller = 1;
  protected Legemiddel legemiddel;
  protected Lege utskrivendeLege;
  protected Pasient pasient;
  protected int reit;
  protected int reseptId;
  protected String type = "Resept";
  // Oppretter en variabel "type" som bare skal brukes i toString metoden.


  public Resept(Legemiddel lMiddel, Lege uLege, Pasient pas, int r){
    legemiddel = lMiddel;
    utskrivendeLege = uLege;
    pasient = pas;
    reit = r;
    // Legger til en paa telleren og gjor id til navaerende objekt til idteller
    // neste objekt vil fa en hoeyere id.
    reseptId = reseptIdTeller;
    reseptIdTeller ++;
    
    }

  public int hentId(){
    return reseptId;
  }

  public Legemiddel hentLegemiddel(){
    return legemiddel;
  }

  public Lege hentLege(){
    return utskrivendeLege;
  }

  public String hentType(){
    return type;
  }

  public Pasient hentPasient(){
    return pasient;
  }

  public int hentReit(){
    return reit;
  }

  // Hvis reit er over null saa senkes den med 1 og returnerer true, hvis ikke
  // returneres false.
  public boolean bruk(){
    if (reit>0){
      reit --;
      return true;
    }
    else{
      return false;
    }
  }

  // Her lages to abstracte metoder. Siden dette er i en abstract klasse, saa er
  // dette lov. Disse metodene maa overskrives i subklassene.
  abstract public String farge();
  abstract public int prisAaBetale();


  // Her overskrives toString metoden. Siden alle variablene overskrives i alle
  // subklassene, trenger jeg ikke overskrive denne metoden i subklassene
  @Override
  public String toString(){
    return (pasient + " ReseptId: "+ reseptId + ". Type resept: "
    + type +". Legemiddel: "+ legemiddel.hentNavn() + ". Antall igjen paa resept: "
    + reit + ". Utskrivende Lege: "+ utskrivendeLege.hentNavn()+ ". Pris: " +prisAaBetale()+"kr.");


    
  }

}
