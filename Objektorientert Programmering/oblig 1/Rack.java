import java.util.ArrayList;

public class Rack{

  public ArrayList<Node> nodeListe;


  public Rack(){
    nodeListe = new ArrayList<Node>();
  }


  public void settInn(Node node){
    nodeListe.add(node);
  }


  public int getAntNoder(){
    int antNoder = nodeListe.size();
    return antNoder;
  }


  public int antProsessorer(){          //Legger sammen antall prossesorer i alle nodene tilsammen.
    int antall = 0;
    for (int i = 0; i<nodeListe.size(); i++){
      antall += nodeListe.get(i).antProsessorer();
      }
    return antall;
  }


  public int noderMedNokMinne(int paakrevdMinne){     //Legger sammen antall noder som har nok minne.
    int antall = 0;
    for (int i = 0; i<nodeListe.size(); i++){
      if (nodeListe.get(i).nokMinne(paakrevdMinne)){
        antall ++;
      }
    }
    return antall;
  }


}
