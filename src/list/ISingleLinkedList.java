package list;

public interface ISingleLinkedList {

	// 返回链表大小
	public int size();

	// 返回指定位置的值
	public int get(int index);

	// 头插法
	public Node headInsertion(int data);

	// 尾插法
	public Node tailInsertion(int data);

	// 链表倒置
	public Node inversionList();

	// 插入
	public void add(int index, int data) throws Exception;

	// 删除
	public void delete(int index) throws Exception;

	// 打印
	public void display(Node head);
}
