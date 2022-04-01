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
	
	/* ��ն��� */
	public void clear() {
		front = rear;		
	}

	/* �ж϶����Ƿ�Ϊ�� */
	public boolean isEmpty() {
		return front == rear;
	}

	/* ���ض��д�С */
	public int size() {
		return rear - front;
	}

	/* ��� */
	public void enQueue(Object x) throws Exception {
		if (rear == queueElement.length-1 )
		{
			throw new Exception("��������");
		}
		else
		{
			queueElement[++rear] = x;
		}
		
	}

	/* ���� */
	public Object deQueue() throws Exception {
		if (isEmpty())
		{
			throw new Exception("�����ѿ�");
		}
		else
		{
			return queueElement[++front];
		}
	}

	/* ��ӡ */
	public void print() {
		if (isEmpty())
		{
			System.out.println("����Ϊ��");
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
