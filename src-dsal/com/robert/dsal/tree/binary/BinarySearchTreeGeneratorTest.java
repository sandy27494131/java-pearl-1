package com.robert.dsal.tree.binary;

import com.robert.dsal.util.SeqUtil;
import com.robert.dsal.util.TreeUtil;

public class BinarySearchTreeGeneratorTest {

	public static void main(String[] args) {
		BinarySearchTreeGenerator bstg = new BinarySearchTreeGeneratorDefault();
		BinarySearchTreeGenerator bstg1 = new BinarySearchTreeGeneratorDefault1();

		int[] seq = SeqUtil.genRandomSeq(5);

		BinaryTreeNode btn = bstg.genBinarySearchTree(seq);
		BinaryTreeNode btn1 = bstg1.genBinarySearchTree(seq);

		TreeUtil.printBinaryTree(btn);
		TreeUtil.printBinaryTree(btn1);
	}

}
