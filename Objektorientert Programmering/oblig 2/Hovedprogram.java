
// her i Hovedprogramet lager jeg en objekt av hver klasse og bruker toString
// metoden og skriver ut info om hvert objekt.

class Hovedprogram{
  public static void main(String[] args){


    Vanlig paracet = new Vanlig("Paracet",39,77);
    Narkotisk heroin = new Narkotisk("Heroin", 588, 55, 10);
    Vanedannende sobril = new Vanedannende("Sobril", 499, 66, 6);


    Lege dinLege = new Lege("doktor Hansen");
    Spesialist dinSpesialist = new Spesialist("Psykolog Skogstad", "pki230871");


    HvitResept hvit = new HvitResept(paracet, dinLege, 6, 1);
    MilitaerResept militaer = new MilitaerResept(heroin, dinSpesialist, 7, 5);
    PResept p = new PResept(sobril, dinLege, 8);
    BlaaResept blaa = new BlaaResept(sobril, dinSpesialist, 9, 5);


    System.out.println(paracet);
    System.out.println(heroin);
    System.out.println(sobril);
    System.out.println(dinLege);
    System.out.println(dinSpesialist);
    System.out.println(hvit);
    System.out.println(militaer);
    System.out.println(p);
    System.out.println(blaa);


// Alt ser ut til å funke som det skal.



  }
}
