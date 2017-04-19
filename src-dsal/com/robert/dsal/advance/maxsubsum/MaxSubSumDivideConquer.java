package com.robert.dsal.advance.maxsubsum;

/**
 * 
 * 第一次遍历n，分成2份； 第二次遍历n，分成4份； 第三次遍历n，分成8份； 第四次遍历n， 分成16份； 第五次遍历n，分成32份；
 * 
 * 第x次便利n，分成2^x份
 * 
 * 一共遍历x次，x = log2n， 每次便利n个元素，因此时间复杂度是O(nlog2n)
 * 
 */

public class MaxSubSumDivideConquer implements MaxSubSum {
	public long maxSubSum(int[] seq) {
		return maxSubSum(seq, 0, seq.length);
	}

	private long maxSubSum(int[] seq, int start, int end) {
		// 参数是左闭右开，剩下一个元素时候不用再递归
		if (start + 1 == end)
			return seq[start];

		// 求出中间元素， 最闭右开
		int mid = (start + end) / 2;

		// 分别递归求出左边最大和右边最大的和
		long maxLeft = maxSubSum(seq, start, mid);
		long maxRight = maxSubSum(seq, mid, end);

		// 求出跨过中间元素的最大和，那么跨过中间元素的最大和就是左边以中间元素开始的向左推进的最大和，
		// 和右边以中间元素开始的向右推进的最大和，的最大的那一个
		long maxLeftPart = maxLeftPart(seq, start, mid);
		long maxRightPart = maxRightPart(seq, mid, end);

		// 求出左边最大和，右边最大和，和跨过中间元素的最大和，中最大的那个
		return max(maxLeft, maxRight, maxLeftPart + maxRightPart);
	}

	private long maxLeftPart(int[] seq, int start, int mid) {
		long maxSum = 0;
		long currSum = 0;

		for (int i = mid - 1; i >= 0; i--) {
			currSum += seq[i];

			if (currSum > maxSum)
				maxSum = currSum;
		}

		return maxSum;
	}

	private long maxRightPart(int[] seq, int mid, int end) {
		long maxSum = 0;
		long currSum = 0;

		for (int i = mid; i < end; i++) {
			currSum += seq[i];

			if (currSum > maxSum)
				maxSum = currSum;
		}

		return maxSum;
	}

	private long max(long m1, long m2, long m3) {
		long max = m1;

		if (m2 > max)
			max = m2;

		if (m3 > max)
			max = m3;

		return max;
	}
}
