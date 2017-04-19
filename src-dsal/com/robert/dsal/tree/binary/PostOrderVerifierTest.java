package com.robert.dsal.tree.binary;

import com.robert.dsal.util.DataUtil;
import com.robert.dsal.util.TestUtil;

public class PostOrderVerifierTest {

	public void run() {
		PostOrderVerifier pov = new PostOrderVerifierImpl();

		BinaryTreeNode btn = DataUtil.genBinaryTree(DataUtil.genSeq(10));
		int[] no = new BinaryTreeIteratorPreOrderDefault()
				.iterateBinaryTreePreOrder(btn);
		int[] yes = new BinaryTreeIteratorPostOrderDefault()
				.iterateBinaryTreePostOrder(btn);

		// boolean r1 = pov.verifyPostOrder(no);
		boolean r2 = pov.verifyPostOrder(yes);

		// TestUtil.assertFalse(r1);
		TestUtil.assertTrue(r2);

	}

	public static void main(String[] args) {
		new PostOrderVerifierTest().run();
	}

}
