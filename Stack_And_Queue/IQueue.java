package queue;

public interface IQueue {

	// 清空队列
	public void clear();

	// 判断队列是否为空
	public boolean isEmpty();
	
	// 返回队列大小
	public int size();

	// 入队
	public void enQueue(Object x) throws Exception;
	
	// 出队
	public Object deQueue() throws Exception;
	
	// 打印
	public void print();
	
	
}
