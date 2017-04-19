package com.robert.cci.c02.q02;

/**
 * 
 * 简单解法：对于单链表中每个元素，如果从当前元素往表尾走，走过n-1个元素到达表尾，则返回当前元素。
 * 
 * 最坏的时间复杂度: O(n^2)
 * 
 */
public class Nth2LastElementFinderDualLoop implements Nth2LastElementFinder {

	public LinkedListNode findNth2LastElement(LinkedListNode head, int n) {
		if (head == null || n <= 0)
			return null;

		while (head != null) {
			LinkedListNode ihead = head;

			int count = 0;
			while (ihead.next != null) {
				ihead = ihead.next;
				count++;
			}
			if (count == n - 1)
				return head;

			head = head.next;
		}

		return null;
	}
}
