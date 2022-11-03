import java.util.*;
import java.io.*;

class BalanceHeap2 {
    public static void main(String[] args) throws IOException { 
        BufferedReader inn = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        String T;
        while((T = inn.readLine()) != null){
            heap.offer(Integer.parseInt(T));
        }
        printTree(0, heap.size()-1, heap);    
    }

    static void printTree(int start, int slutt, PriorityQueue<Integer> heap) {
        if (slutt < start) {
            return;
        }
        PriorityQueue<Integer> venstreHeap = new PriorityQueue<>();
        int mid = (start+slutt)/2;
        for (int i = 0; i < mid; i++) {
            venstreHeap.offer(heap.poll());
        }
        System.out.println(heap.poll());
        printTree(0, heap.size()-1, heap);
        printTree(0, venstreHeap.size()-1, venstreHeap); 
    }
}