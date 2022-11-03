// Tatt inspirasjon fra ukesoppgaver uke 8 sitt losningsforslag
// Et program som leser inn mange filer og spytter ut
// Subsekvenser som er mest typisk for syke folk.

// Har bestemt meg for aa ikke ha en monitor for aa holde styr paa traadene
// da alle traadene jobber uavhengig av hverandre og ikke trenger
// aa blir laast eller laast opp.

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Hovedprogram  {
    static int sekvensLengde = 3;
    // Lager to lister for aa holde orden på traadene.
    static ArrayList<Thread> traader1 = new ArrayList<Thread>();
    static ArrayList<Thread> traader2 = new ArrayList<Thread>();




    public static void main (String[] args) throws IOException {	
        String linje;
        // Lager to beholdere for aa holde styr paa syke og frikse folk.
        Beholder sykBeholder = new Beholder();
        Beholder friskBeholder = new Beholder();
       
        // Leser inn fra fil.
        try{
            Scanner scan = new Scanner(new File("Data/metadata.csv"));			
            System.out.println(" Velkommen til Oblig 5 \n Leser inn data...");

            while(scan.hasNextLine()) {

                linje = scan.nextLine();   
                String[] alleData = linje.split(",");
                // Sjekker om personen det er snakk om er syk eller frisk og 
                // persinen legges i riktig beholder. Det startes en traad for 
                // hver fil sånn at det går fortere å lese inn alt.
                if (alleData[1].contains("True")){
                    LesFil test = new LesFil(sekvensLengde, alleData[0], sykBeholder);
                    Thread traad = new Thread(test);
                    traad.start();
                    traader1.add(traad);
                
                    	
                    }

                else if (alleData[1].contains("False")){
                    LesFil test = new LesFil(sekvensLengde, alleData[0], friskBeholder);
                    Thread traad = new Thread(test);
                    traad.start();
                    traader1.add(traad);
                   
                }
            }
            scan.close();
        } catch (Exception e) {System.out.println(e.getMessage()); }
        System.out.println();	

        // Etter at alle filene har en traad som leser inn starter vi aa lukke traadene.
        System.out.println("Begynner aa lukke traadene...(*)");
        for (Thread traad : traader1) {
            
            try {
                traad.join();
                // Printer ut et lite prgresjons tegn
                System.out.print("*");
                
            } catch (Exception e) {
                System.out.println(e);
            }
            
            
        }
        
        System.out.println();
        System.out.println("\nAntall hashmapper i hver beholder:");
        System.out.println("SykBeholder:   "+sykBeholder.antall());
        System.out.println("FriskBeholder: "+friskBeholder.antall());
        System.out.println();

        // Starter aa slaa sammen alle hashmappene som er i samme beholder.
        // Starter en traad per beholder.
        System.out.println("Slaar sammen alle hashmappene...");

            Runnable flett1 = new SammenFletting(sykBeholder);
            Thread traad1 = new Thread(flett1);
            traad1.start();
            traader2.add(traad1);
            
            
            Runnable flett2 = new SammenFletting(friskBeholder);
            Thread traad2 = new Thread(flett2);
            traad2.start();
            traader2.add(traad2);

        // Lukker traadene naar de er ferdige.
        System.out.println();
        System.out.println("Lukker traadene...(*)");
        for (Thread traad : traader2) {
            try {
                traad.join();
                System.out.print("*");
                
            } catch (Exception e) {
                System.out.println(e);
            }
            
            
        }
        // Printer ut litt data.
        System.out.println();
        System.out.println("\nAntall hashmapper i hver beholder etter sammenslaaing:");
        System.out.println("SykBeholder:   "+sykBeholder.antall());
        System.out.println("FriskBeholder: "+friskBeholder.antall());
        System.out.println();

        System.out.println("Ferdig med aa samle inn data. ");


        HashMap<String,Subsekvens> Syke = sykBeholder.hentUt();	
        HashMap<String,Subsekvens> Friske = friskBeholder.hentUt();	
        System.out.println("\nDominante subsekvenser: ");

        // Sjekker hvilke av subsekvensene som er dominante for syke personer og printer ut.
        for (String key : Syke.keySet()) {
            if (Friske.containsKey(key)){
                if (((Syke.get(key).hentAntall())-(Friske.get(key).hentAntall())) >=5 ){
                System.out.println(key + " med antall syke : "+ (Syke.get(key).hentAntall())+".   Antall friske: "+ (Friske.get(key).hentAntall()));
            }
            }
        }
        System.out.println();
        System.out.println();
        

        
    }


}
