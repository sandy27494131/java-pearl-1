package com.robert.dsal.tree.binary;

import com.robert.dsal.util.DataUtil;
import com.robert.dsal.util.DisplayUtil;

public class PreOrderVerifierTest {

	public void run() {
		BinaryTreeIteratorPreOrderMyImpl pre1 = new BinaryTreeIteratorPreOrderMyImpl();

		BinaryTreeNode btn = DataUtil.genBinaryTree(DataUtil.genSeq(10));

		DisplayUtil.printBinaryTree(btn);

		int[] no = pre1.iterateBinaryTreePreOrder(btn);

		DisplayUtil.printSeq("@", no);

	}

	public static void main(String[] args) {
		new PreOrderVerifierTest().run();
	}

}
