package list;

public class SingleLinkedList implements ISingleLinkedList {

	Node head = new Node(); // 头结点，不存储数据
	int size; // 一共几个结点

	/* 大小 */
	public int size() {
		return size;
	}

	/* 获取指定位置的数据 */
	public int get(int index) {
		Node p = head;
		for (int j = 1; j <= index; j++) {// 指针移动到指定位置
			p = p.next;
		}
		return p.data;
	}

	/* 头插法 */
	public Node headInsertion(int data) {

		Node newNode = new Node(data);// 为输入的数据创造新的结点

		// 如果链表中没有数据，就把新结点赋给head.next
		if (head.next == null) {
			head.next = newNode;
		} else {
			newNode.next = head.next;
			head.next = newNode;
		}

		size++;// 链表大小+1

		return head;// 返回头结点
	}

	/* 尾插法 */
	public Node tailInsertion(int data) {

		Node newNode = new Node(data);

		// 先判断首元结点是否为空
		Node p = head;
		if (p.next == null) { // 首元节点为空
			head.next = newNode;
		} else // 不空
		{
			while (p.next != null) {
				p = p.next;
			}
			p.next = newNode;
		}

		size++; // 链表长度加1

		return head;
	}

	/* 倒置链表 */
	public Node inversionList() {

		Node newHead = new Node();// 新的头结点
		Node p = head;// head为原来的头结点

		// 新的头结点接到原来的尾结点上
		for (int i = 1; i <= size; i++) {
			p = p.next;
		}
		newHead.next = p;

		for (int i = size; i > 1; i--) {// 指定p1的位置（在需要调整结点的前一个结点）
			Node p1 = head;
			for (int j = 1; j < i; j++) {// 指针指到需要调整的结点的前一个结点
				p1 = p1.next;
			}
			p1.next.next = p1;// 将需要调整的结点的next接到前一个结点上
		}

		head.next.next = null;// 将原来的首元节点调整为尾节点

		return newHead;
	}

	/* 插入 */
	public void add(int index, int data) throws Exception {

		if (index <= 0 || index > size) {
			throw new Exception("数组指针越界异常 " + index);
		} else {
			Node newNode = new Node(data);
			Node p = head;

			for (int i = 1; i < index; i++) {
				p = p.next;
			}

			newNode.next = p.next; // 将新结点指向p的下一个结点
			p.next = newNode; // newNode放入链表

			size++; // 链表长度加1
		}

	}

	/* 删除 */
	public void delete(int index) throws Exception {

		if (index <= 0 || index > size) {
			throw new Exception("数组指针越界 " + index);
		} else {
			Node p = head;

			// p移到删除位的前一位
			for (int i = 1; i < index; i++) {
				p = p.next;
			}
			Node q = p.next;
			p.next = q.next;
		}

		size--;
	}

	/* 打印 */
	public void display(Node head) {

		Node p = head.next;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
	}
}
