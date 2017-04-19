package com.robert.dsal.lookup.app.minn;

/**
 * 
 * 数组有N+M个数字, 数字的范围为1 ... N, 打印重复的元素, 要求O(M + N), 不可以用额外的空间
 * 
 */

public interface FindMInN {
	// 接口定义中，由于N+M就是数组的长度，而且N和M都是未知，所以不是输入参数
	int[] findMInN(int[] x);
}
