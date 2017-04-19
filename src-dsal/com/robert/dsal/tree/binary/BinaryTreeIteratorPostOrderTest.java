package com.robert.dsal.tree.binary;

import com.robert.dsal.util.DataUtil;
import com.robert.dsal.util.DisplayUtil;
import com.robert.dsal.util.TestUtil;

public class BinaryTreeIteratorPostOrderTest {

	public void run() {
		BinaryTreeIteratorPostOrder btipo = new BinaryTreeIteratorPostOrderDefault();

		BinaryTreeIteratorPostOrder btipor = new BinaryTreeIteratorPostOrderRecusion();

		int[] seq = DataUtil.genSeq(10);
		BinaryTreeNode tree = DataUtil.genBinaryTree(seq);

		int[] postResult = btipo.iterateBinaryTreePostOrder(tree);
		DisplayUtil.printSeq("PostOrder Non-recusion", postResult);

		int[] postResultr = btipor.iterateBinaryTreePostOrder(tree);
		DisplayUtil.printSeq("PostOrder Recusion", postResultr);

		TestUtil.assertEqual(postResult, postResultr);

	}

	public static void main(String[] args) {
		new BinaryTreeIteratorPostOrderTest().run();
	}

}
