package com.robert.dsal.list;

import com.robert.dsal.list.ds.LinkedListNode;
import com.robert.dsal.util.DataUtil;
import com.robert.dsal.util.DisplayUtil;
import com.robert.dsal.util.TestUtil;

public class MergeListTest {
	public void run() {
		LinkedListNode m = DataUtil.genSortLinkedList(200);
		LinkedListNode n = DataUtil.genSortLinkedList(100);

		DisplayUtil.printLinkedList("List 1", m);
		DisplayUtil.printLinkedList("List 2", n);

		LinkedListNode m1 = DataUtil.cloneLinkedList(m);
		LinkedListNode n1 = DataUtil.cloneLinkedList(n);

		DisplayUtil.printLinkedList("Cloned List 1", m1);
		DisplayUtil.printLinkedList("Cloned List 2", n1);

		MergeList ml = new MergeListDefault();
		LinkedListNode k = ml.mergeList(m, n);
		DisplayUtil.printLinkedList("After Merge of List 1 and List 2", k);

		MergeList ml1 = new MergeListMyImpl();
		LinkedListNode k1 = ml.mergeList(m1, n1);
		DisplayUtil
				.printLinkedList(
						"After Merge of Cloned List 1 and List 2 with Implementation 1",
						k1);

		TestUtil.assertEqual(k, k1);
	}

	public static void main(String[] args) {
		new MergeListTest().run();
	}
}
