package com.robert.dsal.lookup.classic;

import java.util.Arrays;

/**
 * 算法名称：
 * 
 * 二分查找或者折半查找
 * 
 * 算法描述：
 * 
 * 1.取整数序列中间的值，如果等于目标整数，则找到。 　 　　　　　　 2.如果目标整数小于中间的整数，调整索引在l到m-1子序列查找。
 * 3.否则，调整索引在m+1到h子序列查找。
 * 
 * 时间复杂度：
 * 
 * O(logN) 经过1次剩余 n/2 经过2次剩余 n/4 经过3次剩余 n/8 .......... 经过x次剩余n/2^x 2^x = n => x=
 * logN
 * 
 * 关键点：
 * 
 * 1.1000个数据需要10步，1000000个数据需要20步，可见数据越多二分查找越快，logN随着数据的增大复杂度增加的趋势变小，小于线性。
 * 2.二分查找要求输入序列是排序过的序列。 3.循环终止条件是l > r。
 * 
 */
public class BinaryChopLookup extends AbstractLookup {
	@Override
	public void setup(int[] seq) {
		super.setup(seq);

		Arrays.sort(seq);
	}

	@Override
	public int lookup(int t) {
		return lookup(seq, 0, seq.length - 1, t);
	}

	private int lookup(int[] seq, int l, int r, int t) {
		// 这里是>=, 对于=其实是判断了一次seq[l] == t，重用了循环里面的判断
		while (l <= r) {
			// 分成三个区间 l - m-1, m, m+1 - r
			int m = (l + r) / 2;
			if (seq[m] == t)
				return m;

			if (t < seq[m])
				r = m - 1;
			else
				l = m + 1;
		}
		return -1;
	}
}
