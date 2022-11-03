
// Oppretter en abstract klasse, det vil si at man ikke kan lage objekter av
// denne klassen, men man kan lage pekere av denne klassen.
abstract class Legemiddel{

// Lager en static teller som går opp for hvert objekt som blir lagd, det vil
// si at hvert objekt får en unik id.
protected static int idteller = 0;
protected int id;
protected String navn;
protected int pris;
protected double virkestoff;


public Legemiddel(String n, int p, double vs){
  navn = n;
  pris = p;
  virkestoff = vs;
  // Legger til en på telleren og gjør id til nåværende objekt til idteller
  // neste objekt vil få en høyere id.
  idteller ++;
  id = idteller;
}


public int hentId(){
  return id;
}


public String hentNavn(){
return navn;
}

public int hentPris(){
  return pris;
}

public double hentVirkestoff(){
  return virkestoff;
}

public void settNyPris(int nyPris){
  pris = nyPris;
}

//Overskriver toString metoden til å skrive ut relevant informasjon.
@Override
public String toString(){
  return (navn+" Id: "+id+". Koster "+pris+" kroner. Virkestoff er paa "+ virkestoff+" mg.");
}









}
