
public class Node{

  private int minnestorrelse;
  private int prosessorantall;


  public Node(int minne, int prosessor){
    minnestorrelse = minne;
    prosessorantall = prosessor;
    }


  public int antProsessorer(){

    return prosessorantall;
  }


  public boolean nokMinne(int paakrevdMinne){

    if (minnestorrelse >= paakrevdMinne){
      return true;
    }
    else{
      return false;
    }
  }
}
