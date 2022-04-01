package queue;

public class Queue implements IQueue {

	private Object [] queueElement;
	private int front, rear;
	
	public Queue(int maxSize)
	{
		queueElement = new Object[maxSize];
		front = -1;
		rear = -1;
	}
	
	/* 清空队列 */
	public void clear() {
		front = rear;		
	}

	/* 判断队列是否为空 */
	public boolean isEmpty() {
		return front == rear;
	}

	/* 返回队列大小 */
	public int size() {
		return rear - front;
	}

	/* 入队 */
	public void enQueue(Object x) throws Exception {
		if (rear == queueElement.length-1 )
		{
			throw new Exception("队列已满");
		}
		else
		{
			queueElement[++rear] = x;
		}
		
	}

	/* 出队 */
	public Object deQueue() throws Exception {
		if (isEmpty())
		{
			throw new Exception("队列已空");
		}
		else
		{
			return queueElement[++front];
		}
	}

	/* 打印 */
	public void print() {
		if (isEmpty())
		{
			System.out.println("队列为空");
		}
		else
		{
			for (int i=front+1; i<=rear; i++)
			{
				System.out.printf(queueElement[i] + " ");
			}
			System.out.println();
		}

	}

}
