package sort.basic;

import sort.utils.ArrayUtil;

import static sort.utils.ArrayUtil.isEquals;
import static sort.utils.ArrayUtil.printArray;

public class InsertionSort implements Sort {
    /**
     * 插入排序
     */
    @Override
    public void sort(int arr[]) {
        // 数组为空或只有一个元素，不需要排序。
        if (arr == null || arr.length < 2) {
            return;
        }
        // i从1开始，因为从0开始已经被排除；i遍历到最后一个数组元素；
        for (int i = 1; i < arr.length; i++) {
            // j从i-1开始，即从待排序区域的倒数第二个元素开始；如果j元素比j+1元素大就交换；j循环向前，直到j=0、j元素比j+1元素小；
            // 实质是最后一个元素（即arr[i]）循环比较，遇到比他小的就不再继续插入。
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                ArrayUtil.swap(arr, j, j + 1);
            }
        }
    }

    /**
     * 对数器
     *
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
            if (!isEquals(arr1, arr2)) {
                success = false;
                printArray(arr3);
                break;
            }
        }
        return success ? "Nice" : "Fucking fucked";
    }


    // 对数器
    public static void main(String[] args) {


    }


}
