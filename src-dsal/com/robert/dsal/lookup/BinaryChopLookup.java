package com.robert.dsal.lookup;

/**
 * 算法描述： 
 * 
 * 1.取整数序列中间的值，如果等于目标整数，则找到。 　 　　　　　　 
 * 2.如果目标整数小于中间的整数，调整索引在l到m-1子序列查找。
 * 3.否则，调整索引在m+1到h子序列查找。
 * 
 * 时间复杂度： 
 * 
 * O(logN)
 * 经过1次剩余 n/2 经过2次剩余 n/4 经过3次剩余 n/8 .......... 经过x次剩余n/2^x
 * 2^x = n => x= logN
 * 
 * 关键点：
 * 
 * 1.1000个数据需要10步，1000000个数据需要20步，可见数据越多二分查找越快，logN随着数据的增大复杂度增加的趋势变小，小于线性。
 * 2.二分查找要求输入序列是排序过的序列。
 * 3.循环终止条件是l <= h。 
 * 
 */
public class BinaryChopLookup implements Lookup {
	public int lookup(int[] seq, int t) {
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

	public int lookupFirst(int[] seq, int t) {
		return lookupFirst(seq, 0, seq.length - 1, t);
	}

	private int lookupFirst(int[] seq, int l, int r, int t) {

		while (l < r) {
			int m = (l + r) / 2;

			//分成两个区间, t <=seq[m]意味着t可能在m位置或者之前，也就是遇到了m位置是t，但是也不返回，然后再去找前面看看有没有，逐渐缩小前面的区间
			if (t <= seq[m])
				r = m;
			else
				l = m + 1;
		}

		if (seq[l] == t)
			return l;

		return -1;
	}

	public int lookupLast(int[] seq, int t) {

		return lookupLast(seq, 0, seq.length - 1, t);
	}

	private int lookupLast(int[] seq, int l, int r, int t) {
		while (l < r) {
			// 因为每次除二取整，使中间值偏向左，要找到最右面一个，需要每次在和上加一，这样使中间值偏右
			int m = (l + r + 1) / 2;

			//分成两个区间, t >=seq[m]意味着t可能在m位置或者之后，也就是遇到了m位置是t，但是也不返回，然后再去找后面看看有没有，逐渐缩小后面的区间
			if (t >= seq[m])
				l = m;
			else
				r = m - 1;
		}

		if (seq[r] == t)
			return r;

		return -1;
	}
}
