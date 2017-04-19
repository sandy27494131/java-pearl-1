package com.robert.dsal.lookup.app.findk;

import com.robert.dsal.util.AlUtil;

public class KthFinderRecursion implements KthFinder {

	// return index of element in an array which is the k minimum
	int partition(int[] a, int l, int r) {
		int v = a[l], last = l;

		for (int i = l + 1; i <= r; i++)
			if (a[i] < v)
				AlUtil.swap(a, ++last, i);

		AlUtil.swap(a, last, l);

		return last;
	}

	int findKth(int a[], int l, int r, int k) {
		if (l > r)
			return -1;

		int t = partition(a, l, r);

		if (k - 1 == t)
			return a[t];

		if (k - 1 < t)
			return findKth(a, l, t - 1, k);
		else
			return findKth(a, t + 1, r, k);
	}

	public int findKth(int[] seq, int k) {
		return findKth(seq, 0, seq.length - 1, k);
	}

}
