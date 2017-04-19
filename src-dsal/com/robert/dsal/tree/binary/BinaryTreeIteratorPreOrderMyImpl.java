package com.robert.dsal.tree.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.robert.dsal.util.CollectionUtil;

public class BinaryTreeIteratorPreOrderMyImpl implements
		BinaryTreeIteratorPreOrder {

	private void iterateBinaryTreePreOrder(Stack<BinaryTreeNode> stack,
			List<Integer> result) {
		BinaryTreeNode last = null;
		while (!stack.isEmpty()) {
			BinaryTreeNode top = stack.pop();

			// 向前和向后都可能遇见叶子节点
			if (top.left == null && top.right == null) {
				result.add(top.value);
				last = top;
				continue;
			}

			// 向前推进
			if (last == null) {
				result.add(top.value);

				if (top.right != null) {
					stack.add(top.right);
				}

				if (top.left != null) {
					stack.add(top.left);

				}
				continue;
			}

			// 向后推进
			if (last != null) {
				if (top.left == last || top.right == last) {
					last = top;
					continue;
				}

				if (last != top.left && last != top.right) {
					last = null;
					stack.add(top);
					continue;
				}
			}
		}
	}

	public int[] iterateBinaryTreePreOrder(BinaryTreeNode tree) {
		List<Integer> result = new ArrayList<Integer>();

		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(tree);

		iterateBinaryTreePreOrder(stack, result);

		return CollectionUtil.convert(result);
	}
}
