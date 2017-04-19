package com.robert.dsal.list.app.delrange;

import com.robert.dsal.list.ds.LinkedListNode;

/**
 * 
 * O(n)
 * 
 */
public class DeleteRangeImpl implements DeleteRange {
	public LinkedListNode deleteRange(LinkedListNode head, int start, int end) {
		if (start > end)
			return head;

		if (head == null)
			return null;

		// 只有一个元素切需要删除
		if (head.next == null && start < head.value && end > head.value) {
			return null;
		}

		LinkedListNode left = null;
		LinkedListNode right = null;

		LinkedListNode prev = null;
		LinkedListNode t = head;
		while (t != null) {
			// 找到左元素的前一个元素
			if (start <= t.value)
				left = prev;

			// 找到右元素的下一个元素
			if (end < t.value)
				right = t;
			else if (end == t.value)
				right = t.next;

			// 双指针向前移动
			prev = t;
			t = t.next;
		}

		// 左右都为空，就是整个链表都要删除
		if (left == null && right == null)
			return null;

		// 如果左元素是空，右元素不为空
		if (left == null)
			head = right;

		// 如果右元素是空，做元素不是空
		if (right == null)
			left.next = null;

		// 如果两个元素都不为空
		left.next = right;

		return head;
	}
}
