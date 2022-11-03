//Valgfri
//O(nlog(n))
public class Heap extends Sorter {

    @Override
    void sort() {
        buildMaxHeap(n);
        for (int i = n-1; geq(i, 0); i--) {
            swap(0, i);
            bubbleDown(0, i);
        }
    }

    void bubbleDown(int i, int n){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        int tmp;

        if(lt(left, n) && lt(A[largest], A[left])){
            //swaps++; // Usikker om dette gjelder som en swap
            tmp = largest;
            largest = left;
            left = tmp;
        }
        if(lt(right, n) && lt(A[largest], A[right])){
            //swaps++; // Usikker om dette gjelder som en swap
            tmp = largest;
            largest = right;
            right = tmp;
        }
        if (!eq(i, largest)){
            swap(i ,largest);
            bubbleDown(largest, n);
        }
    }

    void buildMaxHeap(int n){
        for (int i = n/2; geq(i, 0); i--) {
            bubbleDown(i, n);
        }
    }

    @Override
    String algorithmName() {
        return "heap";
    }
    
}
