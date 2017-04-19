package com.robert.dsal.list;

import com.robert.dsal.list.ds.LinkedListNode;

public class MergeListDefault implements MergeList {
	public LinkedListNode mergeList(LinkedListNode m, LinkedListNode n) {
		LinkedListNode h = null, t = null;

		while (m != null && n != null) {
			LinkedListNode tmp = null;
			// 每次拿出一个小的插到尾部
			if (m.value < n.value) {
				tmp = m;
				m = m.next;
			} else {
				tmp = n;
				n = n.next;
			}

			if (h == null) {
				h = t = tmp;
			} else {
				t.next = tmp;
				t = tmp;
			}
		}
		
		//把剩余的部分直接连接到尾部
		if (m == null)
			t.next = n;

		if (n == null)
			t.next = m;

		return h;
	}
}
