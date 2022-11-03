import java.util.ArrayList;
import java.io.*;

class Kattunge2 {
    public static void main(String[] args) throws IOException {
        ArrayList<Node> noder = new ArrayList<>();
        BufferedReader inn = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(inn.readLine());
        Node kattunge = new Node(start);
        noder.add(kattunge);
        Boolean ikkeIListe;
        String[] linje = inn.readLine().split(" ");
        int lengde = linje.length;
        int[] liste = new int[lengde];
        for (int i = 0; i < lengde; i++) {
            liste[i] = Integer.parseInt(linje[i]);
        }

        while (liste[0] != -1) {
            ikkeIListe = true;
            Node forelder = new Node(liste[0]);
            for (int i = 0; i < noder.size(); i++){
                if (liste[0] == noder.get(i).data) {
                    forelder = noder.get(i);
                    ikkeIListe = false;
                }
            }
            if (ikkeIListe) {
                noder.add(forelder);
            }
            for (int i = 1; i < liste.length; i++) {
                ikkeIListe = true;
                Node v = new Node(liste[i]);
                for (int j = 0; j < noder.size(); j++){
                    if (liste[i] == noder.get(j).data) {
                        v = noder.get(j);
                        ikkeIListe = false;
                    }
                }
                if (ikkeIListe) {
                    noder.add(v);
                }  
                v.settForelder(forelder); 
            }
            linje = inn.readLine().split(" ");
            lengde = linje.length;

            liste = new int[lengde];
            for (int i = 0; i < lengde; i++) {
                liste[i] = Integer.parseInt(linje[i]);
            }
        }
        finnSti(kattunge);
    }

    
    static class Node {

        int data;
        Node forelder;

        Node(int x) {
            data = x;
        }

        void settForelder(Node f) {
            forelder = f;
        }
    } 

    static void finnSti(Node x) {
        Node v = x;
        while (v.forelder != null) {
            System.out.println(v.data);
            v = v.forelder;
        }
        System.out.println(v.data);
    }
}