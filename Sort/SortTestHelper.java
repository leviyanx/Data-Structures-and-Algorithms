package sort;

public class SortTestHelper {
    public SortTestHelper(){
    };

    // generate random int number
    public int[] generateRandomArray(int n, int rangeL, int rangeR){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * (rangeR - rangeL + 1))% (rangeR - rangeL + 1) + rangeL;
        }
        return arr;
    }

    public static void main(String[] args){
        SortTestHelper sortTestHelper = new SortTestHelper();
        int n = 9;
        int rangeL = 0;
        int rangeR = 4;
        int[] arr = sortTestHelper.generateRandomArray(n, rangeL, rangeR);
        for(int var=0; var < n; var++ ) {
            System.out.println(arr[var]);
        }

    }
}

