package com.robert.dsal.advance.maxsubsum;

/**
 * 
 * 时间复杂度为： n^3
 * 
 */

public class MaxSubSumBruteForce implements MaxSubSum {

	public long maxSubSum(int[] seq) {
		int maxSum = 0;

		for (int i = 0; i < seq.length; i++) {
			for (int j = i; j < seq.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += seq[k];
				}
				if (sum > maxSum)
					maxSum = sum;
			}
		}

		return maxSum;
	}

}
