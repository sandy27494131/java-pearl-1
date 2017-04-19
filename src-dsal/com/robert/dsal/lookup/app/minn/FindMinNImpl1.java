package com.robert.dsal.lookup.app.minn;

import java.util.Arrays;

/**
 * 
 * 考虑到数组有正数有负数，也就是范围在-N...N，则需要特殊处理，严格的N+M次操作是不能完成的，但是复杂度可控制在O(N+M)范围内。
 * 
 */
public class FindMinNImpl1 implements FindMInN {

	public int[] findMInN(int[] x) {
		int[] result = new int[x.length];
		int count = 0;

		// 把负数放在前面，正数放在后面，k是最后一个负数
		int k = partition(x);

		// 把负数变成正数，因为k+1前面的值就是负数，这个信息自然存在
		for (int i = 0; i <= k; i++) {
			x[i] = -x[i];
		}

		// 处理负数范围
		for (int i = 0; i <= k; i++) {
			// 取得目标索引
			int v = x[i];
			if (v < 0)
				v = -v;
			v--;

			// 如果目标是负值，则表示是重复元素
			if (x[v] < 0)
				result[count++] = -(v + 1); // 因为k以前是负数，所以，需要加上负号输出，并且索引对齐

			// toggle标志位
			x[v] = -x[v];
		}

		// 重置所有的负数为正数
		for (int i = 0; i < result.length; i++) {
			if (x[i] < 0)
				x[i] = -x[i];
		}

		// 处理正数范围
		for (int i = k + 1; i < x.length; i++) {
			// 取得目标索引
			int v = x[i];
			if (v < 0)
				v = -v;
			v--;

			// 输出重复的正数
			if (x[v] < 0)
				result[count++] = v + 1;

			// toggle标志位
			x[v] = -x[v];
		}

		return Arrays.copyOfRange(result, 0, count);
	}

	private int partition(int[] x) {
		int k = -1;
		for (int i = 0; i < x.length; i++) {
			if (x[i] < 0)
				swap(x, ++k, i);
		}

		return k;
	}

	private void swap(int[] x, int i, int j) {
		int tmp = x[i];
		x[i] = x[j];
		x[j] = tmp;
	}

}
