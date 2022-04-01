package stackandqueue;

public class Array2Stack_Queue {


    public static void main(String[] args) {
        Array2Queue arrayQueue = new Array2Queue(3);
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        // arrayQueue.push(4);

        System.out.println(arrayQueue.peek());

        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());


    }
}

/**
 * stack
 */
class Array2Stack {
    private Integer[] arr;
    private Integer size;

    // init
    public Array2Stack(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0.");
        }
        arr = new Integer[initSize];
        size = 0;
    }
    // peek
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return arr[size - 1];
    }
    // push
    public void push(Integer newEle) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The stack is already full.");
        }
        arr[size++] = newEle;
    }
    // pop
    public Integer pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The stack is already empty");
        }
        return arr[--size];
    }
}

/**
 * circular sequence queue
 * the most important variable : size
 */
class Array2Queue {
    private Integer arr[];
    private int size;
    private int first;
    private int last;

    // init queue
    public Array2Queue(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
        first = 0;
        last = 0;
    }
    // peek
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return arr[last];
    }
    // push
    public void push(Integer newEle) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        arr[first] = newEle;
        first = (first + 1) % arr.length;
        size++;
    }
    // pop
    public Integer pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty.");
        }
        size--;
        Integer temp;
        temp = arr[last];
        last = (last + 1) % arr.length;
        return temp;
    }
}
