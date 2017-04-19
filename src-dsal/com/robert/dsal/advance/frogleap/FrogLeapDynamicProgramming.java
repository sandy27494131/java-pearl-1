package com.robert.dsal.advance.frogleap;

/**
 * 
 * O(n*l), l是元素的平均数，也就是每次尝试的平均长度
 * 
 */
public class FrogLeapDynamicProgramming implements FrogLeap {
	public int[] fropLeap(int[] x) {
		// 保存跳到最后一个元素需要跳过步骤最小的步骤数
		int[] vector = new int[x.length];
		vector[vector.length - 1] = 0;

		// 保存跳到最后一个元素需要跳过步骤最小的步骤书的下一个元素索引
		int[] next = new int[x.length];
		next[next.length - 1] = -1;

		for (int i = x.length - 2; i >= 0; i--) {
			// 如果当前元素是0，则不能跳到最后一个元素，跳过此元素
			if (x[i] == 0) {
				vector[i] = -1;
				next[i] = -1;
				continue;
			}

			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			// 此循环里面的内容就是一个动态规划函数，每一次循环是一个阶段，每个阶段要决策怎么跳能跳得最快，每次能够向前移动一个元素，符合最优字结构的特点
			/** 动态规划函数
			 * if (canJump2End())
			 *	 minSteps[i] = 1;
			 * else 
			 *   minSteps[i] = min(1 + minSteps[i + x]); // x is [1,value[i]]
			**/
			for (int j = 1; j <= x[i]; j++) {
				if (i + j >= x.length - 1) {
					// 如果一步能跳到最后一个元素
					min = 1;
					minIndex = x.length - 1;
				} else if (x[i + j] != -1 && vector[i + j] + 1 < min) {
					// 找到跳到那个元素到最后一个元素是最少步骤的
					min = vector[i + j] + 1;
					minIndex = i + j;
				}
			}

			if (minIndex != -1) {
				// 找到一个最小步骤
				vector[i] = min;
				next[i] = minIndex;
			} else {
				// 没有找到最小步骤
				vector[i] = -1;
				next[i] = -1;
			}
		}

		// 拷贝结果
		int[] results = new int[vector[0] + 1];

		results[0] = 0;
		for (int i = 1; i < results.length; i++) {
			results[i] = next[results[i - 1]];
		}

		return results;
	}
}
