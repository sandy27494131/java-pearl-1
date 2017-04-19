package com.robert.dsal.tree.binary;


public class BinarySearchTreeGeneratorDefault implements
		BinarySearchTreeGenerator {
	private BinaryTreeNode genBinarySearchTree(BinaryTreeNode root, int[] seq,
			int index) {
		// 如果当前根节点是空则创建节点返回
		if (root == null) {
			root = new BinaryTreeNode();
			root.value = seq[index];

			return root;
		}

		// 递归创建左右子树
		if (seq[index] < root.value)
			root.left = genBinarySearchTree(root.left, seq, index);
		else
			root.right = genBinarySearchTree(root.right, seq, index);

		return root;
	}

	public BinaryTreeNode genBinarySearchTree(int[] seq) {
		if (seq == null || seq.length == 0)
			return null;

		BinaryTreeNode root = null;

		for (int i = 0; i < seq.length; i++) {
			root = genBinarySearchTree(root, seq, i);
		}

		return root;
	}
}
