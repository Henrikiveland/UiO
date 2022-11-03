//Valgfri
//O(n^2)
class Selection extends Sorter {

    @Override
    void sort() {
        for (int i = 0; lt(i, n-1); i++) {
            int k = i;
            for (int j = i+1; lt(j, n); j++) {
                if(lt(A[j], A[k])){
                    k = j;
                } 
            }
            if (!eq(i, k)){
                swap(i, k);
            }
        }
    }

    @Override
    String algorithmName() {
        return "selection";
    }
}