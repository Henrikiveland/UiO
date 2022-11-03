import java.io.*;

class Teque2 {
    public static void main(String[] args) throws IOException {
        BufferedReader inn = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(inn.readLine());
        for (int i = 0; i < T; i++) {
            String[] linje = inn.readLine().split(" ");
            String kommando = linje[0];
            int y = Integer.parseInt(linje[1]);
            if (kommando.equals("get")) {
                get(y);
            }
            else if (kommando.equals("push_back")) {
                push_back(y);
            }
            else if (kommando.equals("push_middle")) {
                push_middle(y);
            }
            else if (kommando.equals("push_front")) {
                push_front(y);
            }            
        }
    }

    static int teller = 0; 

    static class Node {

        int data;
        Node neste;

        Node(int x) {
            data = x;
        }
    }

    static Node forste;
    static Node siste; 
     
    static int storrelse() {
        return teller;
    }
    static void skrivUt() {
        Node node = forste;
        for (int i = 0; i < storrelse(); i++) {
            System.out.println(node.data);
            node = node.neste;
        }
    }

    static void get(int i) {
        Node node = forste;
        for (int j = 0; j < i; j++) {
            node = node.neste;
        }
        System.out.println(node.data);
    }

    static void push_back(int x) {
        Node v = new Node(x);
        teller++;
        if (forste == null) {
            forste = v;
            siste = v;
        }
        else {
            siste.neste = v;
            siste = v;
        }
    }

    static void push_middle(int x) {
        Node v = new Node(x);
        if (forste == null) {
            forste = v;
            siste = v;
        }
        else {
            Node node = forste;
            for (int i = 0; i < (storrelse()-1)/2; i++) {
                node = node.neste;
            }
            v.neste = node.neste;
            node.neste = v;
        }   
        teller++;
    }

    static void push_front(int x) {
        Node v = new Node(x);
        teller++;
        if (forste == null) {
            forste = v;
            siste = v;
        }
        else {
            v.neste = forste;
            forste = v;
        }
    }
}