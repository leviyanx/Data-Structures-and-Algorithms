package sort.advanced;

import sort.utils.ArrayUtil;

/**
 * 从第一个元素开始
 * 向左比较
 * 如果元素比左边元素大，那么就加上这个比当前元素小的元素，继续往左直到 i=0.
 * 然后当前元素往右跳一个，直到遍历完整个数组。
 * =======================================
 * 运用 MergeSort 的思路
 */
public class SmallSum {
    public static int sum;

    public static void smallSum(int[] arr) {
        if (arr == null || arr.length < 2) // if the array is null or its length < 2, this method is stopped and return
            return;
        int left = 0; // left border
        int right = arr.length - 1; // right border
        ArrayUtil.printArray(smallSum(arr, left, right)); // print the Array
        System.out.println("sum : " + sum); // print the answer of sum
    }

    public static int[] smallSum(int[] arr, int L, int R) {
        // base case
        if (L == R) {
            return arr;
        }
        int mid = L + ((R - L) / 2);

        smallSum(arr, L, mid);
        smallSum(arr, mid + 1, R);
        return merge(arr, L, mid, R);
    }

    public static int[] merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1]; // temp array used to sort
        int p1 = L; // left pointer
        int p2 = mid + 1; // right pointer
        int i = 0;
        while (p1 <= mid && p2 <= R){ // not over the border
            sum += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1]: 0; // get the sum
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++]; // sort

        }
        while (p1 <= mid) { // p2 over the border
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) { // p1 over the border
            temp[i++] = arr[p2++];
        }

        for(i = 0; i < temp.length; i++) { // copy to the original array
            arr[L + i] = temp[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 1, 2};
        smallSum(a);
    }
}
