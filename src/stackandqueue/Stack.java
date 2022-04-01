package stack;

public class Stack implements IStack{
	
	private Object [] stackElement;
	private int top;

	public Stack(int maxSize)
	{
		stackElement = new Object[maxSize];
		top = -1;
	}
	
	/* 清空栈 */
	public void clear()
	{
		top = -1;
	}
	
	/* 判断栈是否为空 */
	public boolean isEmpty()
	{
		return top == -1;
	}
	
	/* 返回栈的大小 */
	public int size()
	{
		return top++;
	}
	
	/* 返回栈顶的值 */
	public Object peak()
	{
		if (!isEmpty())
		{
			return stackElement[top];
		}
		else
		{
			return null;			
		}
		
	}
	/* 入栈 */
	public void push(Object x) throws Exception
	{
		if (top == stackElement.length-1)
		{
			throw new Exception("栈已满");
		}
		else
		{
			stackElement[++top] = x;
		}

	}
	/* 出栈 */
	public Object pop() throws Exception
	{
		if (isEmpty())
		{
			throw new Exception("栈已空");
		}
		else
		{
			return stackElement[--top];
		}
	}
	
	/* 打印（栈顶 -> 栈底）*/
	public void print()
	{
		for (int i=top; i>=0; i--)
		{
			System.out.print(stackElement[i] + " ");
		}
		System.out.println();
	}
	
	

}
