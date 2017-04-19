package com.robert.cci.c02.q02;

/**
 * 
 * 解法：第一次遍历求出链表长度m，然后此题转化为查找从第一个元素开始的第m - n + 1个元素。
 * 
 * 最坏的时间复杂度: O(2n)
 * 
 */
public class Nth2LastElementFinderTraverseTwice implements
		Nth2LastElementFinder {

	public LinkedListNode findNth2LastElement(LinkedListNode head, int n) {
		if (head == null || n <= 0)
			return null;

		// 计算长度
		int m = 0;
		LinkedListNode chead = head;
		while (chead != null) {
			m++;
			chead = chead.next;
		}

		if (n > m)
			return null;

		// 查找正向 m - n + 1
		int k = m - n + 1;
		chead = head;
		while (k-- > 0) {
			chead = chead.next;
		}

		return chead;
	}
}
