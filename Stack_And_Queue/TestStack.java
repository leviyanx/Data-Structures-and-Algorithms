package stack;

public class TestStack {

	public static void main(String[] args) throws Exception {

		Stack stack = new Stack(4);

		// 出栈1：栈已空
		// stack.pop();

		// 入栈1：正常入栈
		 stack.push(1);
		 stack.push(2);
		 stack.push(3);
		 stack.push(4);

		// 打印
		 stack.print();

		// 入栈2：栈已满
		// stack.push(5);

		// 栈顶：输出栈顶值
		 System.out.println(stack.peak());

		// 出栈2：正常出栈
		 System.out.println(stack.pop());
		// stack.print();

		// 大小：返回栈的大小
		// System.out.println(stack.size());
	}
}
