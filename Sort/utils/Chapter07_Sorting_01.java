package sort.utils;

public class Chapter07_Sorting_01 {
    /*
     *Sort the sequence 3, 1, 4, 1, 5, 9, 2, 6, 5 using insertion sort.
     */
    public static void InsertionSort(int[] arr) {
        // 1、arr为空或者长度小于2，直接返回。
        if (arr == null || arr.length < 2)
        {
            return;
        }
        int len = arr.length;
        // 2、For pass P = 1 throuth N -1
        for (int i = 1; i < len; i++)
        {
            // 3、ensure that the elements in position 0 through P are in sorted
            for (int j = i; j > 0; j--)
            {
                if (arr[j] >= arr[j - 1])
                {
                    break;
                }
                swap(arr, j, j - 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i =0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        InsertionSort(arr);
        printArray(arr);
    }
}
