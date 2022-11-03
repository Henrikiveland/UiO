//Worst-case O(n^2), best-case O(nlog(n)), kommer ann paa valg pivotelementet
class Quick extends Sorter {

    void sort() {
        quicksort(0, n-1);
    }

     void quicksort(int low, int high){
         
        if(geq(low, high)){
            return;
        }
        
        int p = partition(low, high);
        quicksort(low, p-1);
        quicksort(p+1, high);
        return;
    }

    int partition(int low, int high){
        int p = choosePivot(low, high);
        swap(p, high);
        int pivot = A[high];
        int left = low;
        int right = high - 1;
        while(leq(left, right)){
            while(leq(left, right) && leq(A[left], pivot)){
                left++;
            }
            while(geq(right, left) && geq(A[right], pivot)){
                right--;
            }
            if(lt(left, right)){
                swap(left, right);
            }
        }
        swap(left, high);
        return left;
    }

    int choosePivot(int low, int high){
        //Denne kan(burde?) endres for aa velge et bedre pivot-element.
        return (low+high)/2;
    }

    String algorithmName() {
        return "quick";
    }
}