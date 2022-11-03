
//Subklasse av klassen resept.
public class HvitResept extends Resept{


  public HvitResept(Legemiddel lMiddel, Lege uLege, int pasId, int r){
    super(lMiddel, uLege, pasId,r);
    type = "Hvit-resept";
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
