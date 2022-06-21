package selectionSort;
public class SelectionSort {

    public SelectionSort() {
    }
    
    public static int[] sort(int[] arr) {
        // exception
        if (arr.length <= 1) {
            return arr;
        }

        // normal condition
        for(int i=0; i < arr.length; i++ ) {

            // find
            int minIndex = i; // the index point to the most minimun number of rest of the arr (include i)
            for(int j=i+1; j < arr.length; j++ ) {
                // find the most minimun
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            // exchange
            exchange(arr, minIndex, i);
        }

        return arr;
    }

    // exchange
    public static void exchange(int[] arr, int mini, int curr) {
        int var = arr[mini];
        arr[mini] = arr[curr];
        arr[curr] = var;
    }

    public static void main(String[] args) {
        int n = 10;
        int rangeL = 2;
        int rangeR = 7;

        SortTestHelper sortTestHelper = new SortTestHelper();
        int[] arr = sortTestHelper.generateRandomArray(n, rangeL, rangeR);
        for(int var=0; var < n; var++ ) {
			System.out.print(arr[var] + "\t");
        }
        System.out.println();

        // int sort
        SelectionSort.sort(arr);
        for(int var=0; var < n; var++ ) {
			System.out.print(arr[var] + "\t");
		}
    }
}