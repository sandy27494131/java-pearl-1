package com.robert.dsal.tree.binary;

import com.robert.dsal.util.DataUtil;
import com.robert.dsal.util.DisplayUtil;
import com.robert.dsal.util.TestUtil;

public class BinaryTreeIteratorPreOrderTest {

	public void run() {
		BinaryTreeIteratorPreOrder btipo = new BinaryTreeIteratorPreOrderDefault();

		BinaryTreeIteratorPreOrder btipor = new BinaryTreeIteratorPreOrderRecusion();

		int[] seq = DataUtil.genSeq(10);
		BinaryTreeNode tree = DataUtil.genBinaryTree(seq);

		int[] preResult = btipo.iterateBinaryTreePreOrder(tree);
		DisplayUtil.printSeq("PreOrder Non-recusion", preResult);

		int[] preResultr = btipor.iterateBinaryTreePreOrder(tree);
		DisplayUtil.printSeq("PreOrder Recusion", preResultr);

		TestUtil.assertEqual(preResult, preResultr);

	}

	public static void main(String[] args) {
		new BinaryTreeIteratorPreOrderTest().run();
	}

}
