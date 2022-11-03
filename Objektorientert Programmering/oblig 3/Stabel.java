
//Klassen stabel er en subklasse av lenkeliste.
// Denne listen skal legge til og fjerne elementer fra slutten av listen.
class Stabel<T> extends Lenkeliste<T>{

  public void leggPaa(T x){
    this.leggTil(x);
  }

  public T taAv(){
    return this.fjern(stoerrelseTeller-1);

  }











}
