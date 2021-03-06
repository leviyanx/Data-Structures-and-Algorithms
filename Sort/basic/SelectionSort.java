package sort.basic;

import sort.utils.ArrayUtil;

public class SelectionSort implements Sort {
    /**
     * 选择排序
     * 先选择无序区中下标最小的元素[1]，
     * 从无序区中选出值最小的元素[2]，
     * 将[1]和[2]交换。
     */
    public void sort(int arr[]) {
        // 如果数组为空，或者数组只有1个元素就不用排序
        if (arr == null || arr.length < 2) {
            return;
        }
        // i从0开始，找出最小的和0交换，然后i++
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 如果有新元素比minIndex所在元素小，就交换下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            // 交换minIndex下标和i下标所在元素
            ArrayUtil.swap(arr, i, minIndex);
        }
    }

    @Override
    public String validateSort(int[] arr) {
        // 对数器
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
                ArrayUtil.printArray(arr3);
                break;
            }
        }
        return success ? "Nice" : "Fucking fucked";
    }


    // 对数器
    public static void main(String[] args) {

    }
}
