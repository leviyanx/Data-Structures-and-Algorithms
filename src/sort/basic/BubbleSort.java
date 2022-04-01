package sort.basic;

import sort.utils.ArrayUtil;

import java.util.Arrays;

public class BubbleSort {
    /**
     * 冒泡排序
     * 是先确定当前无序区中的最大值，
     * 然后将无序区逐渐缩减。
     */
    public static void bubbleSotring(int arr[]) {
        // 数组为空或只有一个元素，不需要排序。
        if (arr == null || arr.length <= 1) {
            // 用来终止方法运行
            return;
        }
        else {
            for (int end = arr.length - 1; end > 0; end--) {
                for (int i = 0; i < end; i++) {
                    // 每两个数，如果前大后小，就要交换
                    if (arr[i] > arr[i+1]) {
                        ArrayUtil.swap(arr, i, i+1);
                    }
                }
            }
        }

    }

    /**
     * 比对的方法
     */
    public static void rightMethod(int arr[]) {
        Arrays.sort(arr);
    }

    // 对数器
    public static void main(String[] args) {
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
            bubbleSotring(arr1);
            rightMethod(arr2);
            if (!ArrayUtil.isEquals(arr1, arr2)) {
                success = false;
                ArrayUtil.printArray(arr3);
                break;
            }
        }
        System.out.println(success ? "Nice" : "Fucking fucked");

       /*正常测试bubbleSorting
        int size = 10;
        int value = 20;
        int[] arr1 = arrayGenerator(size, value);
        int[] arr2 = copyArray(arr1);
        bubbleSotring(arr1);
        for(int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        */
    }


}
