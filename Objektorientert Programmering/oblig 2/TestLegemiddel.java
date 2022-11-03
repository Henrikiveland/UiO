
//Test program for å teste legemiddel-objekter.
class TestLegemiddel{
  public static void main(String[] args){

    Narkotisk heroin = new Narkotisk("Heroin", 588, 55, 10);
    Vanedannende sobril = new Vanedannende("Sobril", 499, 66, 6);
    Vanlig paracet = new Vanlig("Paracet",39,77);

    // Har lagd mange test-metoder som jeg tester med hvert objekt.

    if (testLegemiddelId(heroin, 1) && testNavn(heroin, "Heroin")
    && testPris(heroin, 588) && testVirkestoff(heroin, 55)
    && testNarkotiskStyrke(heroin, 10)){
      System.out.println("Alt bra med Heroin.");
    }
    else {
      System.out.println("Noe feil med Heroin.");
    }
    System.out.println(heroin);
    System.out.println("");


    if (testLegemiddelId(sobril, 2) && testNavn(sobril, "Sobril")
    && testPris(sobril, 499) && testVirkestoff(sobril, 66)
    && testVanedannendeStyrke(sobril, 6)){
      System.out.println("Alt bra med Sobril.");
    }
    else {
      System.out.println("Noe feil med Sobril.");
    }

    System.out.println(sobril);
    System.out.println("");

    if (testLegemiddelId(paracet, 3) && testNavn(paracet, "Paracet")
    && testPris(paracet, 39) && testVirkestoff(paracet, 77)){
      System.out.println("Alt bra med Paracet.");
    }
    else {
      System.out.println("Noe feil med Paracet.");
    }

    System.out.println(paracet);
    System.out.println("");




}
  // Lager test-metoder for å teste alle metodene.
  public static boolean testLegemiddelId(Legemiddel legemiddel, int forventetLegemiddelid){
    return legemiddel.hentId() == forventetLegemiddelid;
  }

  public static boolean testNavn(Legemiddel legemiddel, String forventetNavn){
    return legemiddel.hentNavn() == forventetNavn;
  }

  public static boolean testPris(Legemiddel legemiddel, int forventetPris){
    return legemiddel.hentPris() == forventetPris;
  }

  public static boolean testVirkestoff(Legemiddel legemiddel, double forventetVirkestoff){
    return legemiddel.hentVirkestoff() == forventetVirkestoff;
  }

  public static boolean testNarkotiskStyrke(Narkotisk legemiddel, int forventetNarkotiskStyrke){
    return legemiddel.hentNarkotiskStyrke () == forventetNarkotiskStyrke;
  }

  public static boolean testVanedannendeStyrke(Vanedannende legemiddel, int forventetVanedannendeStyrke){
    return legemiddel.hentVanedannendeStyrke () == forventetVanedannendeStyrke;
  }

}
