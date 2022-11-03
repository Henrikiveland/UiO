
// Oppretter en abstract klasse, det vil si at man ikke kan lage objekter av
// denne klassen, men man kan lage pekere av denne klassen.
abstract class Legemiddel{

// Lager en static teller som gaar opp for hvert objekt som blir lagd, det vil
// si at hvert objekt faar en unik id.
protected static int idteller = 1;
protected int id;
protected String navn;
protected int pris;
protected double virkestoff;





public Legemiddel(String n, int p, double vs){
  navn = n;
  pris = p;
  virkestoff = vs;
  // Legger til en paa telleren og gjor id til naavaerende objekt til idteller
  // neste objekt vil faa en hoyere id.
  id = idteller;
  idteller ++;
  
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

//Overskriver toString metoden til aa skrive ut relevant informasjon.
@Override
public String toString(){
  return ("Id: "+id+". "+navn+". Koster "+pris+" kroner. Virkestoff er paa "+ virkestoff+" mg.");
}









}
