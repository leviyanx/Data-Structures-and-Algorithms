package stackandqueue;

import java.util.Stack;

/**
 实现一个特殊的栈，在实现栈的的基本功能的基础上，再实现返回栈中最小元素的操作。
 【要求】
 1.pop、push、getMin操作的时间复杂度都是 O(1)。
 2.设计的栈类型可以使用现成的栈结构。
 （使用两个栈，一个存数据，一个存最小值）
 */
public class GetMinStack {
    /**
     * 方法1：
     * 只有新元素 <= minStack中原有的元素，才压入minStack
     */
    public static class Stack1 {
        private Stack<Integer> dataSatck;
        private Stack<Integer> minStack;

        public Stack1() {
            this.dataSatck = new Stack<Integer>();
            this.minStack = new Stack<Integer>();
        }
        // push
        public void push(Integer newEle) {
            if (this.minStack.isEmpty()) {
                this.minStack.addElement(newEle);
            } else if (newEle <= this.minStack.peek()) {
                this.minStack.addElement(newEle);
            }
            this.dataSatck.addElement(newEle);
        }
        // pop
        public Integer pop() {
            if (this.dataSatck.isEmpty()) {
                throw new RuntimeException("The stack is empty");
            }
            int value = this.dataSatck.pop();
            if (value == this.minStack.peek()) {
                this.minStack.pop();
            }
            return value;
        }
        // getMin
        public Integer getMin() {
            if (this.minStack.isEmpty()) {
                throw new RuntimeException("The stack is empty");
            }
            return this.minStack.peek();
        }

    }

    /**
     * 方法2：
     * 如果新元素 <= minStack中原有的元素，正常压入minStack
     * 如果是 ">" ,则复制一次最小元素当作新元素压入minStack
     */
    public static class Stack2 {
        private Stack<Integer> dataSatck;
        private Stack<Integer> minStack;

        public Stack2() {
            this.dataSatck = new Stack<Integer>();
            this.minStack = new Stack<Integer>();
        }
        // push
        public void push(Integer newEle) {
            if (this.minStack.isEmpty()) {
                this.minStack.addElement(newEle);
            } else if (newEle <= this.minStack.peek()) {
                this.minStack.addElement(newEle);
            } else {
                int value = this.minStack.peek();
                this.minStack.addElement(value);
            }
            this.dataSatck.addElement(newEle);
        }
        // pop
        public Integer pop() {
            if (this.dataSatck.isEmpty()) {
                throw new RuntimeException("The stack is empty");
            }
            int value = this.dataSatck.pop();
            this.minStack.pop();
            return value;
        }
        // getMin
        public Integer getMin() {
            if (this.minStack.isEmpty()) {
                throw new RuntimeException("The stack is empty");
            }
            return this.minStack.peek();
        }
    }

    public static void main(String[] args) {
        Stack1 stack1 = new Stack1();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());

        System.out.println("=============");

        Stack2 stack2 = new Stack2();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }
}
