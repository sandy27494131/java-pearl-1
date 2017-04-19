package com.robert.dsal.tree.binary;

import com.robert.dsal.util.DataUtil;
import com.robert.dsal.util.DisplayUtil;
import com.robert.dsal.util.TestUtil;

public class BinaryTreeIteratorByLevelTest {

	public void run() {
		BinaryTreeIteratorByLevel btibl = new BinaryTreeIteratorByLevelDefault();

		int[] seq = DataUtil.genSeq(10);
		BinaryTreeNode tree = DataUtil.genBinaryTree(seq);
		DisplayUtil.printSeq("The Original Data", seq);

		int[] byLevelResult = btibl.iterateBinaryTreeByLevel(tree);
		DisplayUtil.printSeq("The Data by Level", byLevelResult);

		TestUtil.assertElementsEqual(seq, byLevelResult);

	}

	public static void main(String[] args) {
		new BinaryTreeIteratorByLevelTest().run();
	}

}
