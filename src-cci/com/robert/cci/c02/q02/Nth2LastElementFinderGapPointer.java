package com.robert.cci.c02.q02;

/**
 * 
 * 最佳解法：取两个指针，一个指向表头，另外一个领先n-1的距离，然后同时往表尾走，前面指针到达表尾，则后面指针就是倒数第n个元素。
 * 
 * 最坏时间复杂度：O(n)
 * 
 */
public class Nth2LastElementFinderGapPointer implements Nth2LastElementFinder {

	public LinkedListNode findNth2LastElement(LinkedListNode head, int n) {
		if (head == null || n <= 0)
			return null;

		// 倒数第一个到倒数第n个元素之间距离是n-1,所以，让fast和head相差n-1的距离
		LinkedListNode fast = head;
		for (int i = 0; i < n - 1; i++) {
			fast = fast.next;
			if (fast == null)
				return null;
		}

		// 一直走到表尾
		while (fast.next != null) {
			head = head.next;
			fast = fast.next;
		}

		return head;
	}

}
