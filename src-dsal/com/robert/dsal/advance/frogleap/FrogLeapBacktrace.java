package com.robert.dsal.advance.frogleap;

import java.util.Arrays;

/**
 * 
 * l^n, l就是元素的平均大小，也是平均弹跳长度， 这里有回溯，效率提高
 * 
 */

public class FrogLeapBacktrace implements FrogLeap {

	public int[] fropLeap(int[] arrays) {
		int[] result = new int[arrays.length + 1];
		result[result.length - 1] = arrays.length;

		int[] buffer = new int[arrays.length + 1];
		buffer[buffer.length - 1] = 0;

		fropLeap(result, buffer, arrays, 0);

		return Arrays.copyOf(result, result[result.length - 1]);
	}

	private void fropLeap(int[] result, int[] buffer, int[] arrays, int index) {
		if (index >= arrays.length - 1) {
			if (buffer[buffer.length - 1] < result[result.length - 1]) {
				copyResult(result, buffer);
				result[result[result.length - 1]++] = arrays.length - 1;
			}
			return;
		}

		// 如果已经走过的步骤比当前最好还长，那就回溯
		if (buffer[buffer.length - 1] > result[result.length - 1])
			return;

		// 题目要求的回溯
		if (arrays[index] == 0)
			return;

		buffer[buffer[buffer.length - 1]++] = index;

		// 递归加循环其实是一个n元树，树的每个非叶子节点都是一个状态，每个叶子节点都是一个解的终点状态，焦点就是判断从根到叶子节点的各个状态是否满足各种约束条件
		for (int i = 1; i <= arrays[index]; i++) {
			fropLeap(result, buffer, arrays, index + i);
		}

		buffer[buffer.length - 1]--;
	}

	private void copyResult(int[] result, int[] buffer) {
		for (int i = 0; i < buffer[buffer.length - 1]; i++)
			result[i] = buffer[i];

		result[result.length - 1] = buffer[buffer.length - 1];
	}

}
