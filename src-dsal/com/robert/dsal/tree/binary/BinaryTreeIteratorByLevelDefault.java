package com.robert.dsal.tree.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.robert.dsal.util.CollectionUtil;

public class BinaryTreeIteratorByLevelDefault implements
		BinaryTreeIteratorByLevel {

	public int[] iterateBinaryTreeByLevel(BinaryTreeNode tree) {
		List<Integer> result = new ArrayList<Integer>();

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(tree);

		while (!queue.isEmpty()) {
			BinaryTreeNode tmp = queue.remove();

			result.add(tmp.value);

			if (tmp.left != null)
				queue.add(tmp.left);

			if (tmp.right != null)
				queue.add(tmp.right);
		}

		return CollectionUtil.convert(result);
	}

}
