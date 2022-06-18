package sort.basic;

import sort.utils.ArrayUtil;

public class MergeSort implements Sort {
    public void sort(int[] arr) {
        // 数组为null，或只有一个元素
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }


    public void mergeSort(int[] arr, int L, int R) {
        // base case
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) / 2); // 中点
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        // true part of sorting
        merge(arr, L, mid, R);
    }

    // merge the left and right parts that have been sorted separately
    public void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int p1 = L; // 左指针
        int p2 = mid + 1; // 右指针

        int i = 0;
        // 不越界情况
        while (p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 越界情况
        // p2越界
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        // p1越界
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }
        // 将arr部分重新排好
        for (i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }

    /**
     * 对数器
     * @param arr
     * @return
     */
    @Override
    public String validateSort(int[] arr) {

        boolean success = true;
        int testTimes = 50000;
        int size = 10;
        int value = 20;
        // 测试testTimes次
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = ArrayUtil.arrayGenerator(size, value); // 待测试方法
            int[] arr2 = ArrayUtil.copyArray(arr1); // 正确方法
            int[] arr3 = ArrayUtil.copyArray(arr1); // 原始样本
            sort(arr1);
            Sort.rightMethod(arr2);
            if (!ArrayUtil.isEquals(arr1, arr2)) {
                success = false;
                // 打印原始样本
                System.out.print("出错样本：");
                ArrayUtil.printArray(arr3);
                // 打印排序方法的执行结果
                System.out.print("我的执行结果：");
                ArrayUtil.printArray(arr1);
                // 正确执行结果
                System.out.print("正确执行结果：");
                ArrayUtil.printArray(arr2);
                break;
            }
        }
        return success ? "Nice" : "Fucking fucked";
    }

    public static void main(String[] args) {

    }
}
