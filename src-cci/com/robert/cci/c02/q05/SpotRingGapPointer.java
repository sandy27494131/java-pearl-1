package com.robert.cci.c02.q05;

/*
 k: 链接表头
 n: 环长
 x: 相遇点到环头

 相遇后，慢指针走了k + (n - x)步，快指针走了k + (2n -x)步，快指针走了慢指针的2倍的步数。

 根据推导得知，x = n

 2(k + n - x) = k + 2n - x 

 2k + 2n - 2x = k + 2n - x

 k  = x

 */

public class SpotRingGapPointer implements SpotRing {

	public int spotRing(LinkedListNode head) {
		// 空链表或者单元素链表返回-1
		if (head == null || head.next == null)
			return -1;

		// 单元素循环链表返回0
		if (head == head.next)
			return 0;

		// 慢指针走一步，快指针走两步，注意初始化这次也遵守这个步骤
		LinkedListNode slow = head.next;
		LinkedListNode fast = head.next.next;

		// slow != null是冗余的，因为快指针始终在前面
		while (slow != null && fast != null && fast.next != null
				&& slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// 先判断不等，就是遇到了链表尾端，这样程序代码比较清晰
		if (slow != fast)
			return -1;

		// 计算长度，从相遇点到环头，和链表头到环头的距离相等
		int count = 0;
		while (head != slow) {
			count++;

			head = head.next;
			slow = slow.next;
		}

		return count;
	}

}
