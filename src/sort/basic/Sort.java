package sort.basic;

import java.util.Arrays;

public interface Sort {
    /**
     * 排序
     */
    public void sort(int[] arr);

    /**
     * 公共的比对的方法
     */
    public static void rightMethod(int arr[]) {
        Arrays.sort(arr);
    }

    public String validateSort(int[] arr);
}
