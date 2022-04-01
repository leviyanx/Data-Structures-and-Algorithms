package stack;

public interface IStack {
	
	//清空栈
	public void clear();
	
	//判断栈是否为空
	public boolean isEmpty();
	
	//返回栈的大小
	public int size();
	
	//返回栈顶值
	public Object peak();
	
	//入栈
	public void push(Object x) throws Exception;
	
	//出栈
	public Object pop() throws Exception;
	
	//打印
	public void print();

}
