package sort.basic;

import sort.utils.ArrayUtil;

import static sort.utils.ArrayUtil.*;

public class QuickSort implements Sort {

    @Override
    public void sort(int[] arr) {
        // 数组为null，或只有一个元素
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }


    public void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            ArrayUtil.swap(arr, L + (int) ((R - L + 1) * Math.random()), R); // swap arr[random element's index] with arr[R]
            int[] p = partition(arr, L, R); // arr[R] is a random number; To get less part and more part
            quickSort(arr, L, p[0] - 1); // sort the partition that is less than pivot
            // ('p[0]-1' is the last element of the part)
            quickSort(arr, p[1] + 1, R); // sort the partition that is more than pivot
        }
    }

    // partition1 : pivot = arr[R]
    public int[] partition(int[] arr, int L, int R) {
        int pivot = arr[R]; // select the pivot
        int less = L - 1; // the partition that is smaller than pivot
        int more = R; // the part that is bigger than pivot
        while (L < more) {
            if (arr[L] < pivot) { // if element is less than pivot, then swap element with arr[less+1], and less+1;
                ArrayUtil.swap(arr, ++less, L++);
            } else if (arr[L] > pivot) { // if element is more than pivot, then swap element with arr[more-1], and more-1;
                ArrayUtil.swap(arr, --more, L);
            } else { // if element is equal to pivot, skip if.
                L++;
            }
        }

        ArrayUtil.swap(arr, more, R); // swap pivot with the first element of big part (R is the pivot)
        return new int[]{less + 1, more}; // the left and right margin of equal part
    }

    @Override
    public String validateSort(int[] arr) {
        boolean success = true;
        int testTimes = 50000;
        int size = 10;
        int value = 20;
        // 测试testTimes次
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = arrayGenerator(size, value); // 待测试方法
            int[] arr2 = copyArray(arr1); // 正确方法
            int[] arr3 = copyArray(arr1); // 原始样本
            sort(arr1);
            Sort.rightMethod(arr2);
            if (!isEquals(arr1, arr2)) {
                success = false;
                // 打印原始样本
                System.out.print("出错样本：");
                printArray(arr3);
                // 打印排序方法的执行结果
                System.out.print("我的执行结果：");
                printArray(arr1);
                // 正确执行结果
                System.out.print("正确执行结果：");
                printArray(arr2);
                break;
            }
        }
        return success ? "Nice" : "Fucking fucked";
    }

    // 对数器
    public static void main(String[] args) {


    }
}

