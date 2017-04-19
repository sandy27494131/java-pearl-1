package com.robert.dsal.advance.minsumdiff;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 *  左边是数字个数，分成2组，用蛮力法求解，右面得出的两个集合的最小差值，我们发现当num > 10以后，差值是010101的循环，
 *  再详细点，当总共数字超过10，就是如果整个数组和是偶数，能均分，整个数组和是奇数，则和最小相差1。
 *  
 *  2->7   4->30   6->9   8->4   10->19   12->0   14->1   16->0   18->1   20->0   22->1   24->0   26->1
 *
 * 
 */
public class MinDiffBruteForce implements MinDiff {
	public Result minDiff(int start, int end, int power) {
		// 初始化
		int[] x = new int[end - start + 1];

		for (int i = 0; i < x.length; i++) {
			x[i] = (int) Math.pow(start + i, power);
		}

		// 求和
		long sum = sum(x);

		List<Integer> c1 = new ArrayList<Integer>();
		List<Integer> c2 = new ArrayList<Integer>();

		// 递归求解
		Result result = new Result();
		minDiff(x, c1, c2, 0, 0, result, 0, (int) sum / 2);

		return result;

	}

	private void minDiff(int[] x, List<Integer> c1, List<Integer> c2, int s1,
			int s2, Result result, int pos, int avg) {

		// 递归过程中，如果某个数组之和已经大于平均数，那么差值乘以2就是两个数组之差，如果大于已经求出的和之差最小值，则抛弃当前路径，回溯
		if (s1 > avg && (s1 - avg) * 2 > result.diff)
			return;
		if (s2 > avg && (s2 - avg) * 2 > result.diff)
			return;

		// 如果所有元素已分组
		if (c1.size() + c2.size() == x.length) {
			// 如果不是平分，则退出
			if (c1.size() != c2.size())
				return;

			// 求差值
			int diff = Math.abs(s1 - s2);

			// 如果差值比已有解还小，则保存当前最优解
			if (diff < result.diff) {

				result.diff = diff;
				result.c1 = new ArrayList<Integer>(c1);
				result.c2 = new ArrayList<Integer>(c2);
			}

			return;
		}

		// 当前元素放在第一集合递归
		c1.add(x[pos]);
		minDiff(x, c1, c2, s1 + x[pos], s2, result, pos + 1, avg);
		c1.remove((Integer) x[pos]);

		// 当前元素放在第二集合递归
		c2.add(x[pos]);
		minDiff(x, c1, c2, s1, s2 + x[pos], result, pos + 1, avg);
		c2.remove((Integer) x[pos]);

	}

	private long sum(int[] x) {
		int sum = 0;

		for (int i = 0; i < x.length; i++) {
			sum += x[i];
		}

		return sum;
	}
}
