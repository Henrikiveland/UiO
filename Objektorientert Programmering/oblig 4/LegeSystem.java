import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException; 


class LegeSystem {
  public static void main(String[] args) {

    lesFraFil(args[0]);
    hovedmeny();

  }

    static Lenkeliste<Pasient> pasienter = new Lenkeliste<>();
    static Lenkeliste<Legemiddel> legemidler = new Lenkeliste<>();
    static public SortertLenkeliste<Lege> leger = new SortertLenkeliste<>();
    static Lenkeliste<Resept> resepter = new Lenkeliste<>();

    
    
    // Her lager vi en menymetode.
    // Forst skriver vi ut en meny og spor om hva de vil, for saa og kalle paa de
    // tilhorende metodene.
    public static void hovedmeny(){
         
      System.out.println("                 Hovedmeny                 ");
      System.out.println("0: Avbryt");
      System.out.println("1: Skriv ut fullstendig oversikt over pasienter, leger, legemidler og resepter");
      System.out.println("2: Opprette og legge til nye elementer");
      System.out.println("3: Bruke resept");
      System.out.println("4: Skriv all data til ny fil ");
      System.out.println("5: Se statistikk for systemet");
      System.out.println("6: Les inn fra fil");
      Scanner in = new Scanner(System.in);
      int i = in.nextInt();
      

      if(i == 1){
        System.out.println("Hva vil du skrive ut? ");
        System.out.println("0: Avbryt");
        System.out.println("1: Skriv ut oversikt over pasienter");
        System.out.println("2: Skriv ut oversikt leger");
        System.out.println("3: Skriv ut oversikt over legemidler");
        System.out.println("4: Skriv ut oversikt over resepter");
        System.out.println("5: Skriv ut alle");
        System.out.println("9: Gaa tilbake til hovedmeny");
        i = in.nextInt();

        if(i == 1){
          skrivUtPasienter();
        }
        else if (i == 2) {
          skrivUtLeger();
        }
        else if (i == 3) {
          skrivUtLegemidler();
        }
        else if (i == 4) {
          skrivUtResepter();
        }
        else if (i == 5) {
          skrivUtLegesystem();
        }
        
        hovedmeny();
      }
      
      else if (i == 2) {
        System.out.println("Hva vil du legge til? ");
        System.out.println("0: Avbryt");
        System.out.println("1: Legge til en pasient");
        System.out.println("2: Legge til en lege");
        System.out.println("3: Legge til en legemiddel");
        System.out.println("4: Legge til en resept");
        System.out.println("9: Gaa tilbake til hovedmeny");
        
        i = in.nextInt();
        
        if(i == 1){
          leggTilPasient();
        }
        else if (i == 2) {
          leggTilLege();
        }
        else if (i == 3) {
          leggTilLegemiddel();
        }
        else if (i == 4) {
          leggTilResept();
        }
        
        hovedmeny();
      }

      else if (i == 3){
        System.out.println("1: Bruk resept:");
        System.out.println("9: Gaa tilbake til hovedmeny:");
        i = in.nextInt();
        if(i == 1){
          brukResept();
        }
        
        hovedmeny();
      }
      else if (i == 4){
        System.out.println("1: Skriv ny fil:");
        System.out.println("9: Gaa tilbake til hovedmeny:");

        i = in.nextInt();
        if(i == 1){

          lesTilFil();

        }
        
        hovedmeny();
      } 

      else if (i == 5) {
        System.out.println("1: Se statistikk for antall utskrevne vanedannende legemidler");
        System.out.println("2: Se statistikk for antall utskrevne narkotiske legemidler");
        System.out.println("3: Se statistikk for eventuell misbruk av narkotiske legemidler");
        System.out.println("9: Gaa tilbkae til hovedmeny");
        i = in.nextInt();
        if (i == 1){
          antallVanedannende();
        }
        else if(i == 2){
          antallNarkotisk();
        }
        else if (i == 3){
          narkortiskStatistikk();
        }
       
        hovedmeny();
      }

      else if (i == 6){
        System.out.println("1: Les inn fra fil:");
        System.out.println("9: Gaa tilbake til hovedmeny:");

        i = in.nextInt();
        if(i == 1){
          System.out.println("Hva heter filen du vil lese inn?(eksempel.txt)");
          Scanner tekst = new Scanner(System.in);
          String filNavn = tekst.nextLine();
          lesFraFil(filNavn);

        }
        
        hovedmeny();
      }
  }



    public static void lesTilFil(){

      String filnavn = null;
      
      
      try {
        System.out.println("Hva vil du kalle filen?");
        Scanner in = new Scanner(System.in); //importerer scanner
        filnavn = in.nextLine(); 
        
        File nyFil = new File(filnavn);
        if (nyFil.createNewFile()) {//leser inn neste linje og oppretter en ny fil med det filnavnet
          System.out.println("Laget fil: " + nyFil.getName());
        } else {
          System.out.println("Fil eksisterer allerede"); 
        }
      } catch (IOException e) {
        System.out.println("Noe gikk galt med aa lage ny fil."); //catcher IOException ved eventuelle feil
      }
        
      
          
      try{
        FileWriter skriver = new FileWriter(filnavn); //opner en FileWriter slik vi kan skrive inn i opprettet fil
        skriver.write("# Pasienter (navn, fnr)\n");
        for (Pasient i : pasienter) { //itererer gjennom liste av pasienter
          String navn = i.hentNavn();
          String fodselsnummer = i.hentFodselsNr();
          skriver.write(navn + "," + fodselsnummer+"\n"); //skriver over i selve filen(samme for de andre metodene);
 
        }
        skriver.write("# Legemidler (navn,type,pris,virkestoff,[styrke])\n"); //skriver "overskriften" for hver liste
        for (Legemiddel l : legemidler) {
          String navn = l.hentNavn();
          int pris = l.hentPris();
          double virkestoff = l.hentVirkestoff();
          
          if (l instanceof Narkotisk){ //om legemiddelet er av en viss type så har den andre "parametere" enn t.d. vanlig
            Narkotisk nark = (Narkotisk) l;
            int narkotiskStyrke = nark.hentNarkotiskStyrke();
            skriver.write(navn + ",narkotisk," + pris+","+ virkestoff +","+narkotiskStyrke+"\n"); //har derfor e annen innlesning
            

          }
          else if (l instanceof Vanedannende){
            Vanedannende vane = (Vanedannende) l;
            int vanedannendeStyrke = vane.hentVanedannendeStyrke();
            skriver.write(navn + ",vanedannende," + pris+","+ virkestoff +","+vanedannendeStyrke+"\n");
          }

          else{
            skriver.write(navn + ",vanlig," + pris+","+ virkestoff+"\n");
          }
        
        }

        skriver.write("# Leger (navn,kontrollid / 0 hvis vanlig lege)\n");
        for (Lege i : leger) { 
          String navn = i.hentNavn();
          String kontrollId = "0";
          if(i instanceof Spesialist){
            Spesialist spes = (Spesialist) i;
            kontrollId = spes.hentKontrollID();
          }

          skriver.write(navn + "," + kontrollId+"\n");
 
        }
        skriver.write("# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])\n");
        
        for (Resept r : resepter) {
          try{
            int legemiddelNr = r.hentLegemiddel().hentId();
            String legeNavn = r.hentLege().hentNavn();
            int pasientId = r.hentPasient().hentId();
            String type = r.hentType();
            if (r instanceof PResept){
              skriver.write(legemiddelNr + "," + legeNavn + "," + pasientId + "," + type+"\n");
            }
            else{
            int reit = r.hentReit();
            skriver.write(legemiddelNr + "," + legeNavn + "," + pasientId + "," + type + "," + reit+"\n");
            }
          
          }
        catch(NullPointerException e){ //catcher NullPointerExceptions om noen av hent-metodene gir null
          System.out.println("Kunne ikke kjoere for formatering...");
        }
      }
        
      skriver.close(); //lukker skriveren 
      }
      

      catch (IOException e) { 
        System.out.println("Noe gikk galt med aa lage ny fil.");
      }
      
    }






    // Her ittererer vi gjennom lege listen og teller antall vanedannene Legemiddler
    // som hver lege har skrivd resept paa. Skriver til slutt ut sluttsummen.
    public static void antallVanedannende() {
      int vanedannendeTeller = 0;
      for (Lege lege : leger) { 
        lege.tellVanedannende(); 
        vanedannendeTeller += lege.tellVanedannende();
      }
      System.out.println("Antall utskrevne resepter paa vanedannende legemidler: " + vanedannendeTeller);
      System.out.println("");
    }


    // Her ittererer vi gjennom lege listen og teller antall narkotiske Legemiddler
    // som hver lege har skrivd resept paa. Skriver til slutt ut sluttsummen.
    public static void antallNarkotisk() { 
      int narkotiskTeller = 0;
      
       for (Lege lege : leger) {
          narkotiskTeller += lege.tellNarkotisk();
      }
      System.out.println("Antall utskrevne resepter paa narkortiske legemidler: " + narkotiskTeller);
      System.out.println("");
    }






    // Sjekker statistikken paa narkotiske legemidler
    //Skriver forst ut alle legene som har skrevet ut narkotiske resepter + antall saanne resepter
    // saa skrives alle pasientene som har en narkotisk resept ut + antall saanne resepter.
    public static void narkortiskStatistikk(){
      
      for (Lege lege : leger){
        if (lege.tellNarkotisk() > 0){
          if(lege.tellNarkotisk() == 1){
            System.out.println(lege.hentNavn() + " har skrevet ut ett narkotisk legemiddel.");
          }
          else{
              System.out.println(lege.hentNavn() + " har skrevet ut " + lege.tellNarkotisk() + " narkotiske legemidler.");
          }
        }
      }
      System.out.println("");


      for (Pasient pasient : pasienter){
        if (pasient.tellNarkotisk() > 0){
            System.out.println(pasient.hentNavn() + " har " + pasient.tellNarkotisk() + " gyldig resept paa narkotiske legemidler.");  
        }
      }
      System.out.println("");
      
    }

    





    public static void brukResept(){
      
      Scanner in = new Scanner(System.in);
      Pasient pasient = null;
      Resept resept = null;
      
        System.out.println("Hvilken pasient vil du se resepter for?");
        System.out.println("");
        
        for (Pasient i : pasienter) { //itererer gjennom listen med pasienter
          System.out.println(i);
          System.out.println("");
        }
        System.out.println("Skriv inn pasientid: ");
        int svar = in.nextInt(); //finner hvilken person sine resepter vi vil ha
        
        for (Pasient i : pasienter) {
          if (i.hentId() == svar) {
            System.out.println("Valgt pasient: " + i.hentNavn());
            pasient = i; //setter pasienten lik i
          }
        }

        try{

          if (pasient.hentReseptListe().stoerrelse() != 0){ //saa lenge listen til pasienten ikke er tom fortsetter vi
          System.out.println("Hvilken resept vil du bruke");
          for (Resept r : pasient.hentReseptListe()) {
            System.out.println(r.hentId() +": "+ r.hentLegemiddel().hentNavn() +" ("+ r.hentReit() + " reit)");
          }
          int svarResept = in.nextInt();
          for (Resept i : pasient.hentReseptListe()){
            if (i.hentId() == svarResept){
                resept = i; //finner hvilken resept og setter i lik resepten vi vil ha
            }
            
          }
          if(resept.bruk()){ //bruker bruk-metoden til resept for å hente ut resepten
            System.out.println("Bruker resept paa " + resept.hentLegemiddel().hentNavn() + " antall reit igjen: " + resept.hentReit());
          }
          else{
            System.out.println("Kunne ikke bruke resept paa " + resept.hentLegemiddel().hentNavn()+" (Ingen gjenvaerende reit).");
          } //om der ikke var flere resepter på legemiddelet saa vil vi ikke kunne hente ut 
        }
        else{
          System.out.println("Ingen resepter tilgjengelig..."); //om pasienten ikke hadde noen resepter
        }
          }
          catch(NullPointerException e){ //catcher eventuelle feil
            System.out.println("Feil i bruk resept, resept eller pasient ikke tilgjengelig");
          }
        
        }
      




    // Metode som legger til en lege i lege-lista.
    public static void leggTilLege(){
      
      // Vi spor forst om de skal legge inn en lege eller spesialist og tar inn svaret med et scanner-objekt.
      System.out.println("Vil du legge til lege eller spesialist? \nS for Spesialist, L for lege");
      Scanner in = new Scanner(System.in);
      String linje = in.nextLine();

      // Hvis svaret er S, saa skal de legge inn en spesialist.
      // da trenger vi et navn og en kontrollid som vi tar inn med et scanner-object.
      // Tilslutt lager vi et nytt spesialist-objekt og legger det inn i lege-lista.
      if(linje.toLowerCase().equals("s")){
        System.out.println("Navn: ");
        String navn = "Dr. "+in.nextLine();
        System.out.println("KontrollId: ");
        String kontrollId = in.nextLine();
        Lege lege = new Spesialist(navn, kontrollId);
        leger.leggTil(lege);
      
      }
      // Hvis svaret er L, saa skal de legge inn en vanlig lege.
      // da trenger vi bare et navn som vi tar inn med et scanner-object.
      // Tilslutt lager vi et nytt lege-objekt og legger det inn i lege-lista.
      else if(linje.toLowerCase().equals("l")){
          System.out.println("Navn: ");
          String navn = "Dr. "+in.nextLine();
          Lege lege = new Lege(navn);
          leger.leggTil(lege);
      }
      // hvis de skriver inn noe annet enn L eller S saa for de prove paa nytt.
      else{
        System.out.println("Ugyldig input! Prov paa nytt!");
        leggTilLege();
      }
      
    }






    public static void leggTilPasient() {

      Scanner in = new Scanner(System.in); //oppretter scanner for brukers input
      System.out.println("Legger til pasient:");

      System.out.println("Navn: ");
      String navn = in.nextLine();
      System.out.println("Fodselsnr: ");
      String fodselsnr = in.nextLine();
      Pasient pasient = new Pasient(navn, fodselsnr); //oppretter en ny pasient med brukerens input
      pasienter.leggTil(pasient); //legger til ny pasient i listen med pasienter
      
    }






    public static void leggTilLegemiddel() {

      Scanner in = new Scanner(System.in);
      System.out.println("Legger til legemiddel:");

      System.out.println("Type: ");
      String type = in.nextLine();

      if (type.toLowerCase().equals("narkotisk")){

        System.out.println("Navn: ");
        String navn = in.nextLine();
        System.out.println("Pris:(Heltall) ");
        int pris = in.nextInt();
        System.out.println("Virkestoff:(Desimaltall m. komma) ");
        Double virkestoff = in.nextDouble();
        System.out.println("NarkotiskStyrke:(Heltall) ");
        int narkotiskStyrke = in.nextInt();
        Legemiddel middel = new Narkotisk(navn, pris, virkestoff, narkotiskStyrke);
        legemidler.leggTil(middel);

      }
      
      else if (type.toLowerCase().equals("vanedannende")){ //om bruker skriver med smaa/store bokstaver saa skal dette ikke skille
        System.out.println("Navn: ");
        String navn = in.nextLine();
        System.out.println("Pris:(Heltall) ");
        int pris = in.nextInt();
        System.out.println("Virkestoff:(Desimaltall m. komma) ");
        Double virkestoff = in.nextDouble();
        System.out.println("VanedannendeStyrke:(Heltall) ");
        int vanedannendeStyrke = in.nextInt();
        Legemiddel middel = new Vanedannende(navn, pris, virkestoff, vanedannendeStyrke);
        legemidler.leggTil(middel); //legger til nytt legemiddel i listen over legemidler
      }
      
      else if (type.toLowerCase().equals("vanlig")){
        System.out.println("Navn: ");
        String navn = in.nextLine();
        System.out.println("Pris:(Heltall) ");
        int pris = in.nextInt();
        System.out.println("Virkestoff:(Desimaltall m. komma) ");
        Double virkestoff = in.nextDouble();
        Legemiddel middel = new Vanlig(navn, pris, virkestoff);
        legemidler.leggTil(middel);
        
      }
      else{
        //om brukeren skriver feil vil den faa en feilmelding og blir spurt om den vil proeve på nytt
        System.out.println("Ugyldig input..."); 
        System.out.println("Navn på type(enter for avbryt)");
        String svar = in.nextLine();

        if(svar.equals("")){
          
          return;
        }
        leggTilLegemiddel(); //kjører metoden paa nytt dersom bruker onsker det
      }
      
    }
    



    public static void leggTilResept() {
      // Metode der brukeren faar mulighet til aa legge til et nytt Resept-objekt
     
      Scanner in = new Scanner(System.in);
      System.out.println("Legger til resept:");
          
      Legemiddel legemiddel = null;
      Pasient pasient = null;
      Lege lege = null;

      System.out.println("Navn paa lege: ");
      String legeNavn = in.nextLine(); // Skriver inn navnet paa legen som skal skirve ut resepten

      while (lege == null) {
        for (Lege i : leger){            
          if (i.hentNavn().toLowerCase().equals(legeNavn.toLowerCase())){// bruke compareTo? 
          // Dersom navnet brukeren skrev inn finnes i listen, blir riktig lege satt      
            lege = i;
            }
          }    if (lege == null){ // Dersom navnet kke finnes, kan brukeren proeve paa nytt eller avbryte
    
           System.out.println("Legen finnes ikke!");
           System.out.println("Navn paa lege (enter for avbryt): ");
           legeNavn = in.nextLine();
           
           if(legeNavn.equals("")){
            
             return;
           }
          }
      }
        
      System.out.println("Legemiddel: ");
      String legemiddelNavn = in.nextLine(); // Skriver inn navnet paa legemiddel som skal i resepten

      while (legemiddel == null){
      for (Legemiddel i : legemidler){            
        if (i.hentNavn().toLowerCase().equals(legemiddelNavn.toLowerCase())){         
          // Dersom navnet brukeren skrev inn finnes i listen, blir riktig legemiddel satt      
          legemiddel = i;
          }
        }
          
        if (legemiddel == null){ // Dersom navnet kke finnes, kan brukeren proeve paa nytt eller avbryte
            System.out.println("Legemiddel finnes ikke!");
            System.out.println("Navn paa legemiddel (enter for avbryt): ");
            legemiddelNavn = in.nextLine();
            
            if(legemiddelNavn.equals("")){
              
              return;
            }              
         }
      }

      System.out.println("Pasientnavn: ");
      String navn = in.nextLine(); // Skriver inn navnet paa pasienten som skal i resepten

      while (pasient == null) {
      for (Pasient i : pasienter){            
        if (i.hentNavn().toLowerCase().equals(navn.toLowerCase())){  
           // Dersom navnet brukeren skrev inn finnes i listen, blir riktig pasient satt            
          pasient = i;
        }
      }
        
        if (pasient == null){ // Dersom navnet kke finnes, kan brukeren proeve paa nytt eller avbryte
          System.out.println("Pasienten finnes ikke!");
          System.out.println("Navn paa pasient (enter for avbryt): ");
          navn = in.nextLine();
          
          if(navn.equals("")){
            return;
          }
        }
      }

      System.out.println("Oppgi type resept:(hvit,blaa,militaer,p) ");
      String type = in.nextLine(); // Brukeren oppgir hvilken type resepten skal vaere

      if (type.toLowerCase().equals("hvit")){ // Sjekker om typen skal vaere hvit
        System.out.println("Oppgi reit"); 
        int reit = in.nextInt(); // Bruker oppgir antall reit paa resepten
        try {
        Resept resept = lege.skrivHvitResept(legemiddel,pasient,reit);
        resepter.leggTil(resept);
        }
        catch(Exception e){
          System.out.println(e);
        }
              
      }
      else if (type.toLowerCase().equals("blaa")){ // Sjekker om typen skal vaere blaa
      
        System.out.println("Oppgi reit: ");
        int reit = in.nextInt(); // Bruker oppgir antall reit paa resepten
        
        try{
            Resept resept = lege.skrivBlaaResept(legemiddel, pasient, reit);
            resepter.leggTil(resept);
          }
          catch(Exception e){
              System.out.println(e);
          }
            
      }
      else if (type.toLowerCase().equals("militaer")){ // Sjekker om typen skal vaere militaer

          System.out.println("Oppgi reit: ");
          int reit = in.nextInt(); // Bruker oppgir antall reit paa resepten
            
        try{
            Resept resept = lege.skrivMilitaerResept(legemiddel, pasient, reit);
            resepter.leggTil(resept);
        }
        catch(Exception e){
            System.out.println(e);
        }
            
      }
      else if (type.toLowerCase().equals("p")){ // Sjekker om typen skal vaere pResept
        try {
            Resept resept = lege.skrivPResept(legemiddel, pasient);
            resepter.leggTil(resept);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
    
    
  }
      
 



    public static void skrivUtLegesystem() {
      // Bruker metodene under og skriver ut all informajson om hele legesystemet

      skrivUtPasienter();
      skrivUtLegemidler();
      skrivUtLeger();
      skrivUtResepter();


    }



    public static void skrivUtPasienter(){
      // Metode som gaar igjennom alle pasient-objektene i listen og skriver ut informasjon om dem
      
      System.out.println("");
      System.out.println("Skriver ut alle Pasienter:");
      for (Pasient i : pasienter) { 
        System.out.println(i);
        System.out.println("");
      }

    }




    public static void skrivUtLegemidler(){
      // Metode som gaar igjennom alle legemiddel-objektene i listen og skriver ut informasjon om dem

      System.out.println("");
      System.out.println("Skriver ut alle Legemidler:");
      for (Legemiddel i : legemidler) {
        System.out.println(i);
        System.out.println("");
      }

    }




    public static void skrivUtLeger(){
      // Metode som gaar igjennom alle lege-objektene i listen og skriver ut informasjon om dem
      
      System.out.println("");
      System.out.println("Skriver ut alle Leger:");
      for (Lege i : leger) {
        System.out.println(i);
        System.out.println("");
      }

    }





    public static void skrivUtResepter(){
      // Metode som gaar igjennom alle resept-objektene i listen og skriver ut informasjon om dem
      
      System.out.println("");
      System.out.println("Skriver ut alle resepter:");
      for (Resept i : resepter) {
        try{
        System.out.println(i);
        System.out.println("");
      }
    catch(Exception e){
      //System.out.println("");
    }
    }
      
    }




    public static void lesFraFil(String filnavn) {

    String kontroll = "";   // Tekststreng som holder styr hvilket objekt informasjonen paa innlest linje skal brukes til
    File fil = new File(filnavn);
    Scanner scan;

    try {
      scan = new Scanner(fil);
    }

    catch(FileNotFoundException exception) {

      System.out.println("Fant ikke filen");
      scan = new Scanner("");
    }

    while(scan.hasNextLine()) {   // While-loop som kjører saa lenge det er en ny linje aa lese inn

      String linje = scan.nextLine();
      String[] alleData = linje.split(",|\\(");  // Splitter paa "," og "(" slik at det passer med filen det leses fra
      
      if (linje.startsWith("# Pasienter")) {
        kontroll = "# Pasienter";   // Gir tekststrengen for kontroll riktig verdi
      }

      else if (linje.startsWith("# Legemidler")) {
        kontroll = "# Legemidler";    // Gir tekststrengen for kontroll riktig verdi
      }

      else if (linje.startsWith("# Leger")) {
        kontroll = "# Leger";   // Gir tekststrengen for kontroll riktig verdi
      }

      else if (linje.startsWith("# Resepter")) {
        kontroll = "# Resepter";    // Gir tekststrengen for kontroll riktig verdi
      }

      else if (kontroll.equals("# Pasienter") && !linje.contains("#")) {
        // Sjekker hva informasjonen fra innlest linje skal brukes til ved hjelp av kontrollstrengen

        Pasient pasient = new Pasient(alleData[0],alleData[1]);
        pasienter.leggTil(pasient);
        // Oppretter Pasient-objekt og legger det til i rikitg liste.
      }


      else if (kontroll.equals("# Legemidler") && !linje.contains("#")) {
        // Sjekker hva informasjonen fra innlest linje skal brukes til ved hjelp av kontrollstrengen

        if (alleData[1].contains("vanlig")) {
              Vanlig vanlig = new Vanlig(alleData[0], (int)Math.round(Double.parseDouble(alleData[2])), Double.parseDouble(alleData[3]));
              legemidler.leggTil(vanlig);
              
            }
            else if (alleData[1].contains("narkotisk")) {
              Narkotisk narkotisk = new Narkotisk(alleData[0], (int)Math.round(Double.parseDouble(alleData[2])), Double.parseDouble(alleData[3]), Integer.parseInt(alleData[4]));
              legemidler.leggTil(narkotisk);
              
            }
            else if (alleData[1].contains("vanedannende")) {
              Vanedannende vane = new Vanedannende(alleData[0], (int)Math.round(Double.parseDouble(alleData[2])), Double.parseDouble(alleData[3]), Integer.parseInt(alleData[4]));
              legemidler.leggTil(vane);
              
            }
            // If-sjekkene over sjekker hvilken type legemiddelet skal være, foer den oppretter nytt objekt og legger det til i riktig liste.
            else{
              System.out.println("Legemiddel passer ikke beskrivelse.");
            }
      }


      else if (kontroll.equals("# Leger") && !linje.contains("#")) {
        // Sjekker hva informasjonen fra innlest linje skal brukes til ved hjelp av kontrollstrengen

        if (alleData[1].contains("0")) {
            Lege lege = new Lege(alleData[0]);
            leger.leggTil(lege);
          }

        else {
            Lege lege = new Spesialist(alleData[0], alleData[1]);
            leger.leggTil(lege);
          }
        // If-sjekken sjekker om lege-objektet skal vaere av typen vanlig eller spesialist
      }


      else if (kontroll.equals("# Resepter") && !linje.contains("#")) {
        // Sjekker hva informasjonen fra innlest linje skal brukes til ved hjelp av kontrollstrengen

        Legemiddel legemiddel = null;
        Pasient pasient = null;
        Lege lege = null;

        int legemiddelId = Integer.parseInt(alleData[0]);
        String legeNavn = alleData[1];
        int pasientId = Integer.parseInt(alleData[2]);
          
          
        for (Legemiddel i : legemidler){  // For-loop som finner riktig legemiddel-objekt          
            if (i.hentId() == legemiddelId){              
              legemiddel = i;
            }
        }

        for (Lege i : leger){   // For-loop som finner riktig lege-objekt        
            if (i.hentNavn().contains(legeNavn)){              
              lege = i;
            }
        }

        for (Pasient i : pasienter){    // For-loop som finner rigkitg pasient-objekt         
            if (i.hentId() == pasientId){              
              pasient = i;
            }
        }


        try{ // Sjekker om legen har lov til aa skrive ut legemiddelet i resepten 

          if (alleData[3].contains("hvit")){
            int reit = Integer.parseInt(alleData[4]);
            try {
            Resept resept = lege.skrivHvitResept(legemiddel,pasient,reit); // Oppretter riktig resept-objekt
            resepter.leggTil(resept); // Legger resepten til i listen for resepter
            }
            catch(UlovligUtskrift e){ // Catcher unntaket for ulovlig utskrift dersom legen ikke er spesilist
              System.out.println(e);
            }
              
          }
          else if (alleData[3].contains("blaa")){   

            int reit = Integer.parseInt(alleData[4]);
            try{
            Resept resept = lege.skrivBlaaResept(legemiddel, pasient, reit); // Oppretter riktig resept-objekt
            resepter.leggTil(resept); // Legger resepten til i listen for resepter
            }
            catch(UlovligUtskrift e){ // Catcher unntaket for ulovlig utskrift dersom legen ikke er spesilist
              System.out.println(e);
            }
            
          }
          else if (alleData[3].contains("millitaer")){

            int reit = Integer.parseInt(alleData[4]);
            
            try{
            Resept resept = lege.skrivMilitaerResept(legemiddel, pasient, reit); // Oppretter riktig resept-objekt
            resepter.leggTil(resept); // Legger resepten til i listen for resepter
            }
            catch(UlovligUtskrift e){ // Catcher unntaket for ulovlig utskrift dersom legen ikke er spesilist
              System.out.println(e);
            }
            

            
          }
          else if (alleData[3].contains("p")){

            try {
            Resept resept = lege.skrivPResept(legemiddel, pasient); // Oppretter riktig resept-objekt
            resepter.leggTil(resept); // Legger resepten til i listen for resepter
            }
            catch(UlovligUtskrift e){ // Catcher unntaket for ulovlig utskrift dersom legen ikke er spesilist
              System.out.println(e);
            }
            
        
          }
        }
        catch(NullPointerException e){
          System.out.println("Ulovlig resept: Resept passer ikke beskrivelse");
        }
 
        }
        //System.out.println(alleData[0]+" Resepter");
      }
      scan.close();
    }

    }
  

