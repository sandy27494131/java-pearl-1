package com.robert.dsal.advance.maxsubsum;

/**
 * 
 * 时间复杂度为： n^2
 * 
 * 算法：对于任何一个元素，求出以此元素开始的任何子序列的和，因此是双重循环
 * 
 */

public class MaxSubSumImprove implements MaxSubSum {

	public long maxSubSum(int[] seq) {
		long maxSum = 0;

		for (int i = 0; i < seq.length; i++) {
			// 以i元素开始的所有子数组的组合
			long currSum = 0;
			for (int j = i; j < seq.length; j++) {
				currSum += seq[j];

				if (currSum > maxSum)
					maxSum = currSum;
			}
		}

		return maxSum;
	}

}
