
// Oppretter en abstract klasse, det vil si at man ikke kan lage objekter av
// denne klassen, men man kan lage pekere av denne klassen.
abstract class Resept{

  // Lager en static teller som går opp for hvert objekt som blir lagd, det vil
  // si at hvert objekt får en unik id.
  protected static int reseptIdTeller = 0;
  protected Legemiddel legemiddel;
  protected Lege utskrivendeLege;
  protected int pasientId;
  protected int reit;
  protected int reseptId;
  protected String type = "Resept";
  // Oppretter en variabel "type" som bare skal brukes i toString metoden.


  public Resept(Legemiddel lMiddel, Lege uLege, int pasId, int r){
    legemiddel = lMiddel;
    utskrivendeLege = uLege;
    pasientId = pasId;
    reit = r;
    // Legger til en på telleren og gjør id til nåværende objekt til idteller
    // neste objekt vil få en høyere id.
    reseptIdTeller ++;
    reseptId = reseptIdTeller;
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

  public int hentPasientId(){
    return pasientId;
  }

  public int hentReit(){
    return reit;
  }

  // Hvis reit er over null så senkes den med 1 og returnerer true, hvis ikke
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

  // Her lages to abstracte metoder. Siden dette er i en abstract klasse, så er
  // dette lov. Disse metodene må overskrives i subklassene.
  abstract public String farge();
  abstract public int prisAaBetale();


  // Her overskrives toString metoden. Siden alle variablene overskrives i alle
  // subklassene, trenger jeg ikke overskrive denne metoden i subklassene
  @Override
  public String toString(){
    return ("PasientId: "+ pasientId + ". ReseptId: "+ reseptId + ". Type resept: "
    + type +". Legemiddel: "+ legemiddel.hentNavn() + ". Antall igjen paa resept: "
    + reit + ". UtskrivendeLege: "+ utskrivendeLege.hentNavn()+ ". Pris: " +prisAaBetale()+"kr.");
  }

}
