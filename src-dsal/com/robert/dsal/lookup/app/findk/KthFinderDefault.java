package com.robert.dsal.lookup.app.findk;

import com.robert.dsal.util.AlUtil;

/**
 * 
 * Find the nth minimum element. Use the binary chop to find one element in its
 * position. O(log2N) 平均一次可以去掉一半的元素。
 * 
 */

public class KthFinderDefault implements KthFinder {
	// return index of element in array a which is the k min
	private int partition(int[] a, int l, int r) {
		int v = a[l], last = l;

		for (int i = l + 1; i <= r; i++) {
			if (a[i] < v)
				AlUtil.swap(a, ++last, i);
		}

		AlUtil.swap(a, last, l);
		return last;
	}

	private int findKth(int a[], int l, int r, int k) {
		while (l <= r) {
			int t = partition(a, l, r);

			if (t == k - 1)
				return a[t];

			if (k - 1 < t) {
				r = t - 1;
			} else {
				l = t + 1;
			}
		}
		return -1;
	}

	public int findKth(int[] seq, int k) {
		return findKth(seq, 0, seq.length - 1, k);
	}
}
