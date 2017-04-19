package com.robert.dsal.tree.binary;


public class BinarySearchTreeGeneratorDefault1 implements
		BinarySearchTreeGenerator {
	private void genBinarySearchTree(BinaryTreeNode root, int value) {
		// 如果比当前根节点小，则处理左子树
		if (value < root.value) {
			// 如果左子树不为空，则递归产生左子树
			if (root.left != null)
				genBinarySearchTree(root.left, value);

			// 如果左子树为空，则建立左子树
			else {
				BinaryTreeNode btn = new BinaryTreeNode();
				btn.value = value;
				root.left = btn;
			}

		} else {
			if (root.right != null)
				genBinarySearchTree(root.right, value);
			else {
				BinaryTreeNode btn = new BinaryTreeNode();
				btn.value = value;
				root.right = btn;
			}

		}
	}

	public BinaryTreeNode genBinarySearchTree(int[] seq) {
		if (seq == null || seq.length == 0)
			return null;

		BinaryTreeNode root = new BinaryTreeNode();
		root.value = seq[0];

		for (int i = 1; i < seq.length; i++) {
			genBinarySearchTree(root, seq[i]);
		}

		return root;
	}
}
