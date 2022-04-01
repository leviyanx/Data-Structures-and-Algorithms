package sort.utils;

public class ArrayUtil {

    /**
     * 打印数组
     */
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    /**
     * 交换数组元素
     */
    public static void swap(int arr[], int i, int j) {
        int k;
        k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }

    /**
     * 随机数组生成器
     */
    public static int[] arrayGenerator(int size, int value) {
        // 数组长度：在[0,size]中随机生成
        int arraySize = (int) ((size + 1) * Math.random());
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            // 在[-value,value]内生成随机数
            array[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
        }
        return array;
    }

    /**
     * 复制数组
     */
    public static int[] copyArray(int arr[]) {
        // 数组为null的情况
        if (arr == null) {
            return null;
        }
        int[] tempArray = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            tempArray[i] = arr[i];
        }
        return tempArray;
    }

    /**
     * 比较两个数组元素是否都相等
     */
    public static boolean isEquals(int arr1[], int arr2[]) {
        boolean success = true;
        // 不同为null
        if ((arr1 == null && arr2 != null) ||(arr1 != null && arr2 == null)) {
            return false;
        }
        // 同为null
        if (arr1 == null && arr2 == null) {
            return true;
        }
        // 长度不一致
        if (arr1.length != arr2.length) {
            return false;
        }
        // 元素不相等
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
