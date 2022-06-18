package list;

import java.util.Scanner;

public class TestSingleLinkedList {

	public static void main(String[] args) throws Exception {

		SingleLinkedList list = new SingleLinkedList();
		Node p = list.head.next;
		p = null;// 链表置空

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 输入链表长度

		// 头插法测试
		while (N-- > 0) {
			int ele = sc.nextInt();
			list.head = list.headInsertion(ele);
		}

		// 尾插法测试
		// while (N-- > 0) {
		// int ele = sc.nextInt();
		// p = list.tailInsertion(ele);
		// }

		// 打印测试
		list.display(list.head);

		// 插入测试
		 list.add(1, 0);
		// list.add(8, 0);
		 list.display(list.head);

		// 大小测试
		// System.out.println(list.size());

		// 删除测试
		list.delete(3);
		list.display(list.head);

		// 转置链表测试
		list.display(list.inversionList());
		sc.close();
	}

}
