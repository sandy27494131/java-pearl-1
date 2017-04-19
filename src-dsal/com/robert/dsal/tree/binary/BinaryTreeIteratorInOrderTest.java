package com.robert.dsal.tree.binary;

import com.robert.dsal.util.DataUtil;
import com.robert.dsal.util.DisplayUtil;
import com.robert.dsal.util.TestUtil;

public class BinaryTreeIteratorInOrderTest{

	public void run() {
		BinaryTreeIteratorInOrder btipo = new BinaryTreeIteratorInOrderDefault();

		BinaryTreeIteratorInOrder btipor = new BinaryTreeIteratorInOrderRecusion();

		int[] seq = DataUtil.genSeq(10);
		BinaryTreeNode tree = DataUtil.genBinaryTree(seq);

		int[] inResult = btipo.iterateBinaryTreeInOrder(tree);
		DisplayUtil.printSeq("InOrder Non-recusion", inResult);

		int[] inResultr = btipor.iterateBinaryTreeInOrder(tree);
		DisplayUtil.printSeq("InOrder Recusion", inResultr);

		TestUtil.assertEqual(inResult, inResultr);

	}

	public static void main(String[] args) {
		new BinaryTreeIteratorInOrderTest().run();
	}

}
