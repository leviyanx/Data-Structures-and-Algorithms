package sort.basic;

import sort.utils.ArrayUtil;

/**
 * the first step: build the heap in linear time
 * then, perform N-1 DeleteMaxes by swapping the last element in the heap with the first,
 * decrementing the heap size, percolating down
 */
public class HeapSort implements Sort{

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        else {
            // 建立大根堆
            for (int i = 0; i < arr.length; i++) {
                heapInsertion(arr, i);
            }
            // now, arr[0] is the largest, swap arr[0] with the last element;
            int size = arr.length;
            ArrayUtil.swap(arr, 0, --size);

            while (size > 0) {
                heapify(arr, 0, size); // 排序大根堆
                ArrayUtil.swap(arr, 0, --size); // 将arr[0]扔出大根堆，并减小大根堆的规模
            }
        }
    }

    /**
     * 形成大根堆
     * @param arr：数组
     * @param index：新加进大根堆的元素下标
     */
    public void heapInsertion(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) { // 当 arr[index] 比他的父节点大
            ArrayUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 大根堆排序
     * @param arr：数组
     * @param index：指针
     * @param size：无序区的大小
     */
    public void heapify(int[] arr, int index, int size) {
        int leftChild = 2 * index + 1;
        while (leftChild < size ) {
            int largest = arr[leftChild] <= arr[leftChild + 1] && leftChild + 1 < size ? leftChild + 1 : leftChild; // 左右孩子中的较大者
            largest = arr[largest] < arr[index] ? index : largest; // 父节点与左右孩子中的较大者比较，选出最大者
            if (largest == index) // 如果父节点、左右孩子中，最大元素为父节点，跳出循环
            {
                break;
            }
            // 如果是左右孩子中的一个为最大者，继续循环
            ArrayUtil.swap(arr, largest, index);
            index = largest;
            leftChild = index * 2 + 1;
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

    // 对数器
    public static void main(String[] args) {


/*        // 正常测试 heapSort
        int size = 10;
        int value = 20;
        int[] arr1 = arrayGenerator(size, value);
        int[] arr2 = copyArray(arr1);
        heapSort(arr1);
        System.out.println("原始样本");
        for(int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println("\n待测试方法");
        for(int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }*/
    }
}
