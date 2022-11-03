
//Test program for å teste resept-objekter.
class TestResepter{
  public static void main(String[] args){


    Vanlig paracet = new Vanlig("Paracet",200,77);
    Lege Henrik = new Lege("doktor Henrik Iveland");
    HvitResept hvit = new HvitResept(paracet, Henrik, 4, 1);
    MilitaerResept militaer = new MilitaerResept(paracet, Henrik, 4, 5);
    PResept p = new PResept(paracet, Henrik, 4);
    BlaaResept blaa = new BlaaResept(paracet, Henrik, 4, 5);


    // Tester hvert objekt med en testmetode som blir lagd under.
    System.out.println(testHentId(hvit, 1));
    System.out.println(testHentLegemiddel(p, paracet));
    System.out.println(testHentLege(blaa, Henrik));
    System.out.println(testHentPasientId(militaer, 4));
    System.out.println(testHentReit(hvit, 1));
    System.out.println(testHentReit(p, 3));
    System.out.println(testBruk(hvit, true));
    System.out.println(testBruk(hvit, false));
    System.out.println(testFarge(blaa, "blaa"));
    System.out.println(testPrisAaBetale(hvit,200));
    System.out.println(testPrisAaBetale(militaer,0));
    System.out.println(testPrisAaBetale(p,92));
    System.out.println(testPrisAaBetale(blaa,50));
    System.out.println(paracet);
    System.out.println(hvit);
    System.out.println(militaer);
    System.out.println(p);
    System.out.println(blaa);


}
  // lager testmetoder som tester hver metode.
  public static boolean testHentId(Resept resept, int forventetReseptId){
    return resept.hentId() == forventetReseptId;
  }

  public static boolean testHentLegemiddel(Resept resept, Legemiddel forventetLegemiddel){
    return resept.hentLegemiddel() == forventetLegemiddel;
  }

  public static boolean testHentLege(Resept resept, Lege forventetLege){
    return resept.hentLege() == forventetLege;
  }

  public static boolean testHentPasientId(Resept resept, int forventetPasientId){
    return resept.hentPasientId() == forventetPasientId;
  }

  public static boolean testHentReit(Resept resept, int forventetReit){
    return resept.hentReit() == forventetReit;
  }

  public static boolean testBruk(Resept resept, boolean forventetResultat){
    return resept.bruk() == forventetResultat;
  }

  public static boolean testFarge(Resept resept, String forventetFarge){
    return resept.farge() == forventetFarge;
  }

  public static boolean testPrisAaBetale(Resept resept, int forventetPrisAaBetale){
    return resept.prisAaBetale() == forventetPrisAaBetale;
  }

}
