
// Subklasse av subklassen Hvitresept.
public class MilitaerResept extends HvitResept{


  public MilitaerResept(Legemiddel lMiddel, Lege uLege, Pasient pas, int r){
    super(lMiddel, uLege, pas, r);
    type = "millitaer";
  }

//Overskriver metode fra superklassen.
  @Override
  public int prisAaBetale(){
    return 0;

  }

}
