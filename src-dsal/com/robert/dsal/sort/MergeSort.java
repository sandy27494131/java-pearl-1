package com.robert.dsal.sort;

public class MergeSort implements Sort {

	public void sort(int[] seq) {
		int[] tmp = new int[seq.length];
		sort(seq, 0, seq.length, tmp);
	}

	private void sort(int[] seq, int start, int end, int[] tmp) {
		// 如果剩下一个元素，自然是排序的
		if (start + 1 == end) {
			tmp[start] = seq[start];
			return;
		}

		int mid = (start + end) / 2;

		// 分成两组，分别排列，排列后结果放入seq， tmp永远是个临时空间
		sort(seq, start, mid, tmp);
		sort(seq, mid, end, tmp);

		int i = start, j = mid;

		// 两路归并
		int c = start;
		while (i != mid && j != end) {
			if (seq[i] < seq[j])
				tmp[c++] = seq[i++];
			else
				tmp[c++] = seq[j++];

		}

		if (i == mid)
			for (int k = j; k < end; k++)
				tmp[c++] = seq[k];

		if (j == end)
			for (int k = i; k < mid; k++)
				tmp[c++] = seq[k];

		// 将排序后的数据归并到原数组
		for (int k = start; k < end; k++)
			seq[k] = tmp[k];

	}

}
