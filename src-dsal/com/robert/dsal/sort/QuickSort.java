package com.robert.dsal.sort;

import com.robert.dsal.util.AlUtil;

/**
 * <b>算法描述:</b><br>
 * 1. 第一次分区找到一个元素的正确位置。<br>
 * 2. 然后将序列分为两个子序列，此元素之前的序列和次元素之后的序列。<br>
 * 3. 递归排序着两个子序列。
 * <p>
 * <b>时间复杂度：</b><br>
 * O(NlogN)<br>
 * n + 2*n/2 + 4*n/4 + ....(一共logN项)， 因此是NLogN项。
 * 
 * 遍历1个N次，找到1个
 * 遍历2个N次，找到2个
 * 遍历3个N次，找到4个
 * 遍历4个N次，找到8个
 * 遍历5个N次，找到16个
 * 遍历6个N次，找到32个
 * 遍历x个N次，找到n个
 * 2^x = n
 * 一共便利logn次，每次执行N次对比，因此是NLogN
 * 
 */
public class QuickSort implements Sort {

	private int partition(int[] seq, int l, int r) {
		// 可随机选取来优化输入的特殊性造成的趋于O(n^2）的时间复杂度。
		int tmp = seq[l];
		int k = l;
		for (int i = l + 1; i <= r; i++)
			if (seq[i] < tmp)
				AlUtil.swap(seq, i, ++k);
		AlUtil.swap(seq, l, k);
		return k;
	}

	private void sort(int[] seq, int l, int r) {
		if (l > r)
			return;

		int index = partition(seq, l, r);

		sort(seq, l, index - 1);
		sort(seq, index + 1, r);
	}

	public void sort(int[] seq) {
		sort(seq, 0, seq.length - 1);
	}

}
