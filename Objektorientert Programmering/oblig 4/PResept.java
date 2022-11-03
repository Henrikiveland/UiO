
//Subklasse av subklassen HvitResept.
public class PResept extends HvitResept{


  public PResept(Legemiddel lMiddel, Lege uLege, Pasient pas){
    super(lMiddel, uLege, pas, 3);
    type = "p";
  }


  //Overskriver en metode fra superklassen.
  // Her skal prisen som returneres vaere 180kr mindre enn orginalen, men ikke
  // mindre enn 0. Har derfor en if-sjekk som enten returnerer pris minus 180kr
  // eller 0 kroner.
  @Override
  public int prisAaBetale(){
    if (legemiddel.hentPris()>= 108){
      return (legemiddel.hentPris()-108);
    }
    else {
      return 0;
    }
  }
}
