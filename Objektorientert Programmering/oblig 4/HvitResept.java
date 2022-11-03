
//Subklasse av klassen resept.
public class HvitResept extends Resept{


  public HvitResept(Legemiddel lMiddel, Lege uLege, Pasient pas, int r){
    super(lMiddel, uLege, pas, r);
    type = "hvit";
  }

//overskriver abstract metode fra superklassen.
  @Override
  public String farge(){
    return "hvit";
  }

//overskriver abstract metode fra superklassen.
  @Override
  public int prisAaBetale(){
    return legemiddel.hentPris();
  }

}
