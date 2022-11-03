import java.io.File;

public class test2 {
    public static void main(String[] args) {
        String filNavn = "2.in";
        File fil = new File(filNavn);
        

        try {
            Labyrint lab = new Labyrint(fil);
            System.out.println(lab);
            System.out.println(lab.finnUtveiFra(1,1));
            
        } catch (Exception e) {
            System.out.println(e);
            
        }
        
      
        


        
        
    }
    
}
