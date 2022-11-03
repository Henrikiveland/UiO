
// klassen SortertLenkeliste tar i bruk Comparable og
// er en subklasse av Lenkeliste.
class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T>{


// Overskriver metode fra lenkeliste.
// Her Legges hvert nye element i sortert rekkefolge.
// Bruker metode fra comparable og finner posison til hvert nye element og
// kaller på metoden fra superklassen.
@Override
public void leggTil(T x){

  if (stoerrelse()==0){
    super.leggTil(x);
    return;
  }

  for (int i = 0; i<stoerrelse(); i++){
    if (hent(i).compareTo(x)>0){
      super.leggTil(i, x);
      return;
    }
  }
    super.leggTil(x);


}
// fjerner det bakerste elementet i lista.
  @Override
  public T fjern(){


    if (stoerrelse() == 1){
      return super.fjern();
    }

    else{
      return super.fjern(stoerrelse()-1);
    }
  }


  // Overskriver metodene som bruker en gitt posisjon.
  // Disse metodene er ikke lov siden listen skal veare sortert.
  // Her kastes en feilmelding hvis metodene blir kalt paa.
  @Override
  public void sett(int pos, T x) throws UnsupportedOperationException{
    throw new UnsupportedOperationException();
  }

  @Override
  public void leggTil(int pos, T x) throws UnsupportedOperationException{
    throw new UnsupportedOperationException();

  }


}
