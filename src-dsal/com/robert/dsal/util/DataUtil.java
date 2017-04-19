package com.robert.dsal.util;

import com.robert.dsal.list.ds.LinkedListNode;
import com.robert.dsal.sort.QuickSort;
import com.robert.dsal.sort.Sort;
import com.robert.dsal.tree.binary.BinarySearchTreeGenerator;
import com.robert.dsal.tree.binary.BinarySearchTreeGeneratorDefault;
import com.robert.dsal.tree.binary.BinaryTreeNode;

public class DataUtil {
	public static int[] genSeq(int n) {
		int[] seq = new int[n];

		for (int i = 0; i < n; i++) {
			seq[i] = (int) (Math.random() * (n + 1));
		}

		return seq;
	}

	public static void sortSeq(int[] seq) {
		Sort sort = new QuickSort();
		sort.sort(seq);
	}

	public static int[] genSortSeq(int n) {
		int[] seq = genSeq(n);
		sortSeq(seq);

		return seq;
	}

	public static LinkedListNode genSortLinkedList(int n) {
		int[] seq = genSortSeq(n);
		LinkedListNode h = null;

		for (int i = seq.length - 1; i >= 0; i--) {
			LinkedListNode t = new LinkedListNode();
			t.value = seq[i];

			t.next = h;
			h = t;
		}

		return h;
	}

	public static LinkedListNode genRingLinkedList(int n, int f) {
		int[] seq = genSortSeq(n);
		LinkedListNode h = null, t = null;

		for (int i = seq.length - 1; i >= 0; i--) {
			LinkedListNode tmp = new LinkedListNode();
			tmp.value = seq[i];

			if (h == null) {
				h = t = tmp;
			} else {
				t.next = tmp;
				t = tmp;
			}
		}

		LinkedListNode tmp = h;
		for (int i = 0; i < f; i++) {
			tmp = tmp.next;
		}
		t.next = tmp;

		return h;
	}

	public static LinkedListNode cloneLinkedList(LinkedListNode o) {
		LinkedListNode h = null, t = null;

		while (o != null) {
			LinkedListNode tmp = new LinkedListNode();
			tmp.value = o.value;

			if (h == null) {
				h = t = tmp;
			} else {
				t.next = tmp;
				t = tmp;
			}

			o = o.next;
		}

		return h;
	}

	public static BinaryTreeNode genBinaryTree(int[] seq) {
		BinarySearchTreeGenerator binaryTreeGenerator = new BinarySearchTreeGeneratorDefault();

		return binaryTreeGenerator.genBinarySearchTree(seq);
	}

	public static int[][] genMatrix(int row, int col) {
		int[][] matrix = new int[row][col];

		for (int i = 0; i < row; i++)
			matrix[i] = genSeq(col);

		return matrix;
	}

	public static BinaryTreeNode genIndexBinaryTree(int[] seq) {
		// TODO not sure why this is useful
		return null;
	}

}
