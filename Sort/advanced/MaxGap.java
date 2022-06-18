package sort.advanced;

import sort.utils.ArrayUtil;

import java.util.Arrays;

public class MaxGap {
    public static int getMaxGap(int[] arr) {
        // 1、如果 arr 为空或者长度小于2，返回值为0
        if (arr == null || arr.length < 2) {
            return 0;
        }

        // 2、判断是否元素都相同，如果是，返回值0
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            max = arr[i] > max ? arr[i] : max;
            min = Math.min(arr[i], min);
        }
        if (max == min) {
            return 0;
        }

        // 3、分出 n+1 个桶，桶有3个属性：是否有值、桶内最大值、桶内最小值
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];

        // 4、遍历数组，判断当前元素属于哪个桶，将其放入，并更新 桶内最大值、桶内最小值、非否有值
        int bid = 0;
        int i = 0;
        for (; i < len; i++) {
            bid = bucket(arr[i], max, min, len);
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            hasNum[bid] = true;
        }

        // 5、遍历桶，后一个含元素得桶内最小值减去前一个含元素桶内最大值，迭代，得到最大相差
        int gap = Integer.MIN_VALUE; // 两桶最大差值
        int lastMax = maxs[0]; // 上一个有元素的桶内最大值
        for (i = 1; i < len + 1; i++) {
            if (hasNum[i]) {
                gap = Math.max(mins[i] - lastMax, gap);
                lastMax = maxs[i];
            }
        }
        return gap;
    }

    /**
     * 求出当前元素属于哪一个桶（相当关键的一步）
     * @param num 当前元素值
     * @param max 整个数组最大值
     * @param min 整个数组最小值
     * @param len 数组长度
     * @return
     */
    public static int bucket(long num, long max, long min, long len) { // 用long，防止用除法的时候出现问题
        return (int) ((num - min) * len / (max - min)); // 先将 max-min 分为len份，再计算 num 属于哪一个桶
    }

    // 6、一定正确的方法
    public static int rightMethod(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        Arrays.sort(arr);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            gap = Math.max(arr[i] - arr[i - 1], gap);
        }
        return gap;
    }

    // 数组生成器
    public static int[] generateRandomArrays(int size, int value) {
        int arrSize = (int) ((size + 1) * Math.random());
        int[] generatedArray = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            generatedArray[i] = (int)((value + 1) * Math.random()) - (int)((value + 1) * Math.random());
        }
        return generatedArray;
    }

    // 7、对数器
    public static void main(String[] args) {
        boolean success = true;
        int runTimes = 10000;
        int size = 10;
        int value = 20;
        int[] arr1;
        int[] arr2;
        int[] arr3;
        for (int i = 0; i < runTimes; i++) {
            arr1 = generateRandomArrays(size, value);
            arr2 = ArrayUtil.copyArray(arr1);
            arr3 = ArrayUtil.copyArray(arr1);
            int myGap = getMaxGap(arr2);
            int rightGap = rightMethod(arr1);
            if (myGap != rightGap) {
                success = false;
                ArrayUtil.printArray(arr3); // 初始样本
                /*
                printArray(arr1); // 正确方法
                printArray(arr2); // 我的方法*/
                System.out.println("rightGap : " + rightGap + " myGap : " + myGap);
                break;
            }
        }
        System.out.println(success);
    }
}
