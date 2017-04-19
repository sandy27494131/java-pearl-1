package com.robert.dsal.list;

import java.util.Stack;

import com.robert.dsal.list.ds.LinkedListNode;
import com.robert.dsal.util.DataUtil;
import com.robert.dsal.util.DisplayUtil;
import com.robert.dsal.util.TestUtil;

public class ReverseListTest {
	public void run() {
		LinkedListNode l = DataUtil.genSortLinkedList(10);
		DisplayUtil.printLinkedList("Before Inverse", l);

		LinkedListNode l1 = l;
		Stack<Integer> s = new Stack<Integer>();
		while (l1 != null) {
			s.push(l1.value);
			l1 = l1.next;
		}

		ReverseList impl = new ReverseListDefault();
		LinkedListNode i = impl.reverseList(l);

		DisplayUtil.printLinkedList("After Inverse", i);

		Integer value = null;
		while (i != null) {
			if ((value = s.pop()) != null) {
				TestUtil.assertEqual(value, i.value);
			}

			i = i.next;
		}

	}

	public static void main(String[] args) {
		new ReverseListTest().run();
	}
}