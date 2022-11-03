import java.util.*;
import java.io.*;

class BalanceArray2 {
    public static void main(String[] args) throws IOException { 
        BufferedReader inn = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> liste = new ArrayList<>();
        String T;
        while((T = inn.readLine()) != null){
            liste.add(Integer.parseInt(T));
        }
        int[] array = new int[liste.size()];
        for (int i = 0; i < liste.size(); i++) {
            array[i] = liste.get(i);
        }
        balance(0, array.length-1, array);    
    } 

    static void balance(int start, int slutt, int[] array) {
        if (slutt < start) {
            return;
        }
        int mid = (start+slutt)/2;
        System.out.println(array[mid]);
        balance(mid+1, slutt, array);
        balance(start, mid-1, array);
    }
}