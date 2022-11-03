
//Subklasse av klassen resept.
public class BlaaResept extends Resept{


  public BlaaResept(Legemiddel lMiddel, Lege uLege, int pasId, int r){
    super(lMiddel, uLege, pasId,r);
    type = "Blaa-resept";
  }

  //overskriver abstract metode fra superklassen.
  @Override
  public String farge(){
    return "blaa";
  }
  //overskriver abstract metode fra superklassen.
  @Override
  public int prisAaBetale(){
    double pris = legemiddel.hentPris();
    double rabattPris = (pris * 0.25); //lager en ny pris som er 25% av org pris
    return ((int)Math.round(rabattPris));
    // ^her bruker jeg en math metode som avrunder tallet til nærmeste heltall,
    // og caster det til et int tall før det returneres.

  }
}
