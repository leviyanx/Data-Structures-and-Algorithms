package queue;

public class TestQueue {

	public static void main(String[] args) throws Exception {

		Queue queue = new Queue(4);

		// 出队测试1：队列已空
		// queue.deQueue();

		// 入队测试1：正常入队
		 queue.enQueue(1);
		 queue.enQueue(2);
		 queue.enQueue(3);
		 queue.enQueue(4);

		// 打印测试
		 queue.print();

		// 大小测试
		// System.out.println(queue.size());

		// 入队测试2：队列已满
		// queue.enQueue(5);
		// queue.print();

		// 出队测试2：正常出队
		 queue.deQueue();
		 queue.print();

		// 清空队列测试
		 queue.clear();
		 queue.print();
	}

}
