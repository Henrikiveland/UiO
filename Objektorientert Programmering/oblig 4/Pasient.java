class Pasient{

private String navn;
private String fodselsnr;
private static int IdCounter = 1;
private int pasientId;
private Stabel<Resept> reseptListe = new Stabel<>(); //bruker "stabelformat" paa reseptlisten


public Pasient(String n, String fnr){

    navn = n;
    fodselsnr = fnr;
    pasientId = IdCounter;
    IdCounter++;

}

public int tellNarkotisk() {
    int teller = 0;
    for (Resept resept : reseptListe) { //itererer gjennom reseptListe
      if (resept.hentLegemiddel() instanceof Narkotisk){ //sjekker om resepten er av type Narkotisk
          if(resept.hentReit() > 0){ //vi sjekker ogsaa om det er flere reit igjen paa resepter for at det skal vaere "lovlig
            teller++;
          }
      } 
    }
    return teller; 
  }

public void leggTilResept(Resept resept) {

    reseptListe.leggPaa(resept);//legger til en ny resept i listen til pasienten
}

//lager egne metoder for å hente ut informasjon
public int hentId(){
    return pasientId;

}

public String hentNavn(){
    return navn;
}

public String hentFodselsNr(){
  return fodselsnr;
}



public Stabel<Resept> hentReseptListe(){

    return reseptListe;

}


@Override
  public String toString(){
      return("PasientId: "+pasientId + ". Navn: " + navn + ". Fodselsnr: " + fodselsnr + ".");
  }


}










