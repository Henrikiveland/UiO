import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Dataklynge{


  public ArrayList<Rack> rackListe;

  private int noderPerRack;


    public Dataklynge(String filNavn){    // Tar inn et filnavn og leser inn via Scanner.
      rackListe = new ArrayList<Rack>();
      rackListe.add(new Rack());
      File fil = new File(filNavn);
      Scanner input;
        try{              // Hvis det ikke finnes en fil med dette filnavnet, printes en setning ut og programmet kjører videre med en tom fil.
            input = new Scanner(fil);
        }
        catch(FileNotFoundException f){
            System.out.println("Finner ikke filen!");
            input = new Scanner("");
        }
        int teller = 1;
        while(input.hasNextLine()){   // En while løkke som setter antallNoderPerRack fra første innleste linje
                                      // deretter legger til noder via en forløkke
          if(teller == 1){
            String filNoderPerRack = input.nextLine();
            noderPerRack = Integer.parseInt(filNoderPerRack);
            teller = 2;
          }

          else {
          String linje = input.nextLine();
          String[] biter = linje.split(" ");
          int antallNoder = Integer.parseInt(biter[0]);
          int minnePerNode = Integer.parseInt(biter[1]);
          int antallProsPerNode = Integer.parseInt(biter[2]);

          for (int i = 0; i < antallNoder; i++){
            this.settInnNode((new Node(minnePerNode, antallProsPerNode)));
            }
          }
        }
    }


  public void settInnNode(Node node){   // setter inn noder. Hvis racken er full så lages det en ny.


    for (int i = 0; i<rackListe.size(); i++){
      if (rackListe.get(i).getAntNoder()<noderPerRack){

        rackListe.get(i).settInn(node);
        i = rackListe.size();

      }

      else  if (rackListe.get((rackListe.size() - 1)).getAntNoder()==noderPerRack){
        rackListe.add(new Rack());

      }
    }
  }



  public int antProsessorer(){    //Skriver ut hvor mange prossesorer som er tilsammen i alle nodene i alle rackene
    int antall = 0;
    for (int i = 0; i<rackListe.size(); i++){
        antall += rackListe.get(i).antProsessorer();
      }
    return antall;
  }


  public int noderMedNokMinne(int paakrevdMinne){   //Skriver ut hvor mange noder som har nok minne i alle rackene.
    int antall = 0;
    for (int i = 0; i<rackListe.size(); i++){
        antall += (rackListe.get(i)).noderMedNokMinne(paakrevdMinne);
      }
    return antall;
  }


  public int antRacks(){
    int antallRacks = rackListe.size();
    return antallRacks;
  }
}
