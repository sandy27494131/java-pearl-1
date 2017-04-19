package com.robert.dsal.util;

import com.robert.dsal.list.ds.LinkedListNode;
import com.robert.dsal.tree.binary.BinaryTreeNode;

public class DisplayUtil {

	public static void printSeq(String prefix, int[] seq) {
		System.out.format("%-20s", prefix + ":");
		for (int i = 0; i < seq.length; i++) {
			System.out.format((i == (seq.length - 1)) ? "%3d" : "%3d,", seq[i]);
		}
		System.out.println();
	}

	public static void printMatrix(String prefix, int[][] m) {
		System.out.format("%-20s", prefix + ":");
		System.out.println();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.format((j == (m[i].length - 1)) ? "%3d" : "%3d,",
						m[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printLinkedList(String prefix, LinkedListNode h) {
		System.out.format("%-20s", prefix + ":");
		System.out.println();
		while (h != null) {
			System.out.format((h.next == null) ? "%3d" : "%3d,", h.value);
			h = h.next;
		}
		System.out.println();
	}

	private static void printBinaryTreeNode(BinaryTreeNode root, int h) {
		while (h-- > 0) {
			System.out.print("    ");
		}
		System.out.println(root.value);
	}

	private static void printBinaryTree(BinaryTreeNode root, int h) {
		if (root == null)
			return;

		printBinaryTree(root.right, h + 1);
		printBinaryTreeNode(root, h);
		printBinaryTree(root.left, h + 1);
	}

	public static void printBinaryTree(BinaryTreeNode root) {
		printBinaryTree(root, 0);
	}

	public static void printMatrix(String prefix, char[][] coll) {
		System.out.format("%-20s", prefix + ":");
		System.out.println();
		for (int i = 0; i < coll.length; i++) {
			for (int j = 0; j < coll[i].length; j++) {
				System.out.format((j == (coll[i].length - 1)) ? "%3c" : "%3c,",
						coll[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
