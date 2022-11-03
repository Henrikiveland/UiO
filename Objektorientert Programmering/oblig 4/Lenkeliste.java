import java.util.Iterator;

// Lager en klasse lenkeliste<T>. Klassen implementerer grensesnittet liste<T>.
class Lenkeliste<T> implements Liste<T>{
  
  
  // Lager en klasse node for aa holde styr paa liseobjekter og rekkefolge.
  // Lager en neste- og forrige node.
  class Node {
    Node neste = null;
    Node forrige = null;
    T data;
    Node(T x){
      data = x;
    }
  }

  public class LenkelisteIterator implements Iterator<T> { //implementerer en listeiterator som vi bruker senere
      int i = 0;

      @Override
      public boolean hasNext() {
        return (i < stoerrelseTeller);
      }
      
      @Override
      public T next(){
        return hent(i++); //henter neste og oker i med 1
      }

      @Override
      public void remove(){
        fjern(i--); //fjerner og senker i med 1


      }
  }
  
  @SuppressWarnings("unchecked")
  public Iterator iterator(){ //oppretter en iterator

    return new LenkelisteIterator(); //returnerer 

  }
 

  // lager en teller for storrelse og lager en start- og siste mode.
  protected int stoerrelseTeller = 0;
  protected Node start = null;
  protected Node siste = null;



  // Overrider metode fra grensesnittet, returnerer storrelsen.
  @Override
  public int stoerrelse(){
    return stoerrelseTeller;
  }



  // Overrider metode fra grensesnittet.
  // Her legges et element inn i lista paa en gitt posisjon.
  // Her kan det hende det blir kasta en exeption
  @Override
  public void leggTil(int pos, T x) throws UgyldigListeIndeks{

    // Sjekker om posisjonen er under null eller over antall elementer i lista.
    // Da blir det eventuelt kastet en feilmelding.
    if (pos<0 || pos>stoerrelseTeller){
      throw new UgyldigListeIndeks(pos);
    }

    // Sjekker om posisjon eller storrelsen paa lista er paa null eller om
    // posisojn er bakerts i lista, da kaller leggtil metoden som ikke tar inn
    // posisjon og legger elementet bakerst i lista.
    else if  (pos == 0 && stoerrelseTeller == 0 || pos == stoerrelseTeller){
        this.leggTil(x);
      }


    // Her legges elemtentet helt forst i lista.
    else if (pos == 0){

        Node nyNode = new Node(x);
        nyNode.neste = start;
        start.forrige = nyNode;
        start = nyNode;
        stoerrelseTeller++;
    }


    else{

      // Her gaar vi gjennom en for lokke som finner riktig posisojn og
      // legger elemtentet der og flytter naboer dit de skal vaere.
    Node peker = start;
    Node nyNode = new Node(x);
    for (int i = 0; i<pos; i++){
      peker = peker.neste;
      }

    peker.forrige.neste = nyNode;
    nyNode.forrige = peker.forrige;
    nyNode.neste = peker;
    peker.forrige = nyNode;
    stoerrelseTeller++;
    }
  }


  // Overrider metode fra grensesnittet.
  // Her legges et element paa slutten av listen, altsaa sistenoden blir
  // endret og forrige og neste node blir byttet saa det stemmer.
  @Override
  public void leggTil(T x){

    Node nyNode = new Node(x);
    if (start == null){
      start = nyNode;
      siste = nyNode;
    }
    else {
      nyNode.forrige = siste;
      siste.neste = nyNode;
      siste = nyNode;
    }
    stoerrelseTeller++;
  }



  // Overskriver en metode fra grensesnittet.
  // Her blir data til et element paa en gitt posisjon
  // byttet med en annen gitt data.
  // denne metoden kan ogsaa faa en feilmelding.

  @Override
  public void sett(int pos, T x) throws UgyldigListeIndeks{

    // sjekker om vi maa kaste en feilmelding.
    if (pos<0 || pos>=stoerrelseTeller){
      throw new UgyldigListeIndeks(pos);
    }

    // Finner riktig posisjon og endrer dataen.
    Node peker = start;
    for (int i = 0; i<pos; i++){
      peker = peker.neste;
      }

      peker.data = x;
  }


  // Overrider metode fra grensesnittet.
  // Metode som returnerer data fra element paa gitt posisjon.
  @Override
  public T hent(int pos) throws UgyldigListeIndeks{

    if (pos<0 || pos>=stoerrelseTeller){
      throw new UgyldigListeIndeks(pos);
    }


    // Sjekker om posisojn er henholdsvis forste eller siste element i lista
    // og returnerer datenen.
    else if (pos == 0){
      return start.data;
    }

    else if (pos == stoerrelseTeller-1){
      return siste.data;

    }

    // Finner riktig posisjon og returnerer dataen.
    else{
    Node peker = start;
    for (int i = 0; i<pos; i++){
      peker = peker.neste;
      }
      return peker.data;

    }
  }


  // Fjerner element paa gitt posisjon.
  @Override
  public T fjern(int pos) throws UgyldigListeIndeks{

    if (stoerrelseTeller==0){
      throw new UgyldigListeIndeks(-1);
    }

    else if (pos<0 || pos>=stoerrelseTeller){
      throw new UgyldigListeIndeks(pos);
    }

    // Hvis posisjon er 0, kaller vi paa fjern metoden som fjerner det forste
    // elemtnet i lista.
    else if (pos == 0){
      return this.fjern();
      }

      // Maa passe pa at hvis posisjonen er det siste elementet i lista
      // saa maa vi sette neste til aa veare null.
    else if (pos == stoerrelseTeller-1){

      Node peker = start;
      for (int i = 0; i<pos; i++){
        peker = peker.neste;
        }

        peker.forrige.neste = null;
        stoerrelseTeller--;
        return peker.data;
    }

    else{

      Node peker = start;
      for (int i = 0; i<pos; i++){
        peker = peker.neste;
        }

        peker.neste.forrige = peker.forrige;
        peker.forrige.neste = peker.neste;
        stoerrelseTeller--;
        return peker.data;
      }





    }

    // fjerner det forste elementet i lista.
  @Override
  public T fjern()throws UgyldigListeIndeks{

    if (stoerrelseTeller==0){
      throw new UgyldigListeIndeks(-1);
    }


    T fjernes = start.data;
    start = start.neste;
    stoerrelseTeller--;
    return fjernes;
  }


// Overrider toString metoden og skriver ut all dataen til alle elementene.
@Override
  public String toString(){
    String allData = "";
    Node peker = start;
    for (int i = 0; i<stoerrelseTeller; i++){
      peker = peker.neste;
      allData += ""+ peker.data;
    }
    return allData;

  }











}
