package com.robert.dsal.advance.findfirstmiddle;

import java.util.ArrayList;
import java.util.List;

public class FirstPostionElementFinderCumulativeSum implements
		FirstPositionElementFinder {
	private static boolean less(int i, int j) {
		return i < j;
	}

	public int findFirstPositionElement(int[] seq) {
		List<Integer> result = new ArrayList<Integer>();

		int left[] = new int[seq.length];
		int right[] = new int[seq.length];

		// 假设最左面的是最大的，左右面的是最小的
		int i, max = seq[0], min = seq[seq.length - 1];

		// 记录每个元素所在当前位置之前最小的值
		for (i = 0; i < seq.length; i++) {
			if (less(max, seq[i]))
				max = seq[i];
			left[i] = max;
		}

		// 记录每个元素所在当前位置之后最大的值
		// It is OK to use the only n extra space
		for (i = seq.length - 1; i > -1; i--) {
			if (less(seq[i], min))
				min = seq[i];
			right[i] = min;
		}

		// 如果某个元素最大和最小相同，也就是对于前面来说是最大的，对于后面来说是最小的所以就要求这个元素
		for (i = 0; i < seq.length; i++)
			if (left[i] == right[i])
				result.add(seq[i]);

		if (result.size() > 0)
			return result.get(0);
		return -1;
	}
}
