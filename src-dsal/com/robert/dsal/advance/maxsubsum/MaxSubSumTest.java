package com.robert.dsal.advance.maxsubsum;

import com.robert.dsal.util.SeqUtil;

public class MaxSubSumTest {

	public static void main(String[] args) {
		MaxSubSum mssBruteForce = new MaxSubSumBruteForce();
		MaxSubSum mssImprove = new MaxSubSumImprove();
		MaxSubSum mssRecursive = new MaxSubSumDivideConquer();
		MaxSubSum mssDynamicPlanning = new MaxSubSumDynamicPlanning();

		int[] seq = SeqUtil.genRandomSeq(100);

		long maxBruteForce = mssBruteForce.maxSubSum(seq);
		long maxImprove = mssImprove.maxSubSum(seq);
		long maxRecursive = mssRecursive.maxSubSum(seq);
		long maxDynamicPlanning = mssDynamicPlanning.maxSubSum(seq);

		System.out.println("Brute Force: " + maxBruteForce);
		System.out.println("Improve: " + maxImprove);
		System.out.println("Recursive: " + maxRecursive);
		System.out.println("Dynamic Planning: " + maxDynamicPlanning);
	}

}
