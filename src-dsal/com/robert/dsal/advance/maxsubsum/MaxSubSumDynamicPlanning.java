package com.robert.dsal.advance.maxsubsum;

/**
 * 
 * 传说中的动态规划，复杂度是O(n)
 * 
 * 保持一个最大和
 * 
 * 再保持一个当前元素之前的最大和，如果这最大和是负数，则会使后面的和减少，因此抛弃，重置为0，这也就是动态规划的意思
 * 
 */
public class MaxSubSumDynamicPlanning implements MaxSubSum {
	public long maxSubSum(int[] seq) {
		// 保持当前求出来的最大和
		long maxSum = seq[0];

		// 保持到当前元素为止的最大和
		long currSum = seq[0];

		for (int i = 1; i < seq.length; i++) {
			// 如果当前最大和是负数，那只能给后面的和减去值，因此抛弃，但是前面的最大和也可能是最终最大的，但是已经保存在maxSum了，所以呢，也没丢失
			// 如果后面还有更大的，还会更新masXum
			if (currSum < 0)
				currSum = 0;

			currSum += seq[i];

			if (currSum > maxSum)
				maxSum = currSum;
		}

		return maxSum;
	}
}
