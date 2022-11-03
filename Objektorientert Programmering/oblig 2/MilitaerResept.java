
// Subklasse av subklassen Hvitresept.
public class MilitaerResept extends HvitResept{


  public MilitaerResept(Legemiddel lMiddel, Lege uLege, int pasId, int r){
    super(lMiddel, uLege, pasId, r);
    type = "Militaer-resept";
  }

//Overskriver metode fra superklassen.
  @Override
  public int prisAaBetale(){
    return 0;

  }

}
