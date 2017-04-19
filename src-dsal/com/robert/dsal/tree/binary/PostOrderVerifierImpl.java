package com.robert.dsal.tree.binary;

// TODO Still can't understand 
/**
 * 
 * 题目：输入一个整数数组，判断该数组是不是某二元查找树的后序遍历的结果。如果是返回true，否则返回false。
 * 例如输入5、7、6、9、11、10、8，由于这一整数序列是如下树的后序遍历结果：
 * 
 * 8 / \ 6 10 / \ / \ 5 7 9 11
 * 
 * 因此返回true。
 * 
 * 如果输入7、4、6、5，没有哪棵树的后序遍历的结果是这个序列，因此返回false。
 * 
 * 分析：这是一道trilogy的笔试题，主要考查对二元查找树的理解。
 * 
 * 在后续遍历得到的序列中，最后一个元素为树的根结点。从头开始扫描这个序列，比根结点小的元素都应该位于序列的左半部分；
 * 从第一个大于跟结点开始到跟结点前面的一个元素为止
 * ，所有元素都应该大于跟结点，因为这部分元素对应的是树的右子树。根据这样的划分，把序列划分为左右两部分，我们递归地确认序列的左
 * 、右两部分是不是都是二元查找树。
 * 
 * N +2 * N/2 + 4*N/4 ... 一共LGN项 = O(nlogn)
 * 
 */

public class PostOrderVerifierImpl implements PostOrderVerifier {
	public boolean verifyPostOrder(int[] data, int start, int end) {
		int root = data[end];

		int i = start;
		while (data[i] < root)
			i++;

		for (int j = i; j < end; j++) {
			if (data[j] < root)
				return false;
		}

		if (start < i - 1) {
			boolean isLeft = verifyPostOrder(data, start, i - 1);
			if (!isLeft)
				return false;
		}

		if (i < end - 1) {
			boolean isRight = verifyPostOrder(data, i, end - 1);
			if (!isRight)
				return false;
		}

		return true;
	}

	public boolean verifyPostOrder(int[] data) {
		return verifyPostOrder(data, 0, data.length - 1);
	}
}
