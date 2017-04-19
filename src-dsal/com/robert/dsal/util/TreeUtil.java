package com.robert.dsal.util;

import com.robert.dsal.tree.binary.BinaryTreeNode;

public class TreeUtil {
	public static void printBinaryTree(BinaryTreeNode root) {
		printBinaryTree(root, 0);
	}

	private static void printBinaryTree(BinaryTreeNode root, int i) {
		if (root == null)
			return;

		printBinaryTree(root.right, i + 1);
		printBinaryTreeNode(root, i);
		printBinaryTree(root.left, i + 1);
	}

	private static void printBinaryTreeNode(BinaryTreeNode root, int i) {
		while (i-- > 0) {
			System.out.print("      ");
		}

		System.out.println(root.value);
	}
}
