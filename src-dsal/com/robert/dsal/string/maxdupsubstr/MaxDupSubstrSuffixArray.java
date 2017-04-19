package com.robert.dsal.string.maxdupsubstr;

import java.util.Arrays;

/**
 * 
 * 时间复杂度O(nlog2n), 主要用于排序，对比函数中有个while，所以，还有一个常系数, O(c*nlog2n), 看less() -> while循环
 * 
 */
public class MaxDupSubstrSuffixArray implements MaxDupSubstr {
	public char[] maxCommStr(char[] source) {
		int[] suffixes = new int[source.length];

		// 构造后缀数组
		for (int i = 0; i < source.length; i++) {
			suffixes[i] = i;
		}

		// 对后缀数组进行排序
		sort(source, suffixes);

		// 计算排序后相邻连个字符串的公共字串
		int maxstart = -1;
		int maxlength = 0;

		for (int i = 0; i < suffixes.length - 1; i++) {
			int prev = suffixes[i];
			int next = suffixes[i + 1];

			// 对相邻两个字符串统计相同字符个数
			int length = 0;
			while (prev < suffixes.length && next < suffixes.length
					&& source[prev++] == source[next++])
				length++;

			if (length > maxlength) {
				maxlength = length;
				maxstart = suffixes[i];
			}
		}

		if (maxstart != -1)
			return Arrays.copyOfRange(source, maxstart, maxstart + maxlength);

		return null;
	}

	private void sort(final char[] source, final int[] suffixes) {
		quicksort(source, suffixes, 0, suffixes.length);
	}

	private void quicksort(char[] source, int[] suffixes, int i, int j) {
		if (i >= j)
			return;

		int m = partition(source, suffixes, i, j);

		quicksort(source, suffixes, i, m);
		quicksort(source, suffixes, m + 1, j);
	}

	private int partition(char[] source, int[] suffixes, int i, int j) {
		int m = i;
		int f = i + 1;

		while (f < j) {
			if (less(source, suffixes, f, i)) {
				swap(suffixes, f, ++m);
			}
			f++;
		}

		swap(suffixes, i, m);

		return m;
	}

	private void swap(int[] suffixes, int i, int j) {
		int tmp = suffixes[i];
		suffixes[i] = suffixes[j];
		suffixes[j] = tmp;

	}

	private boolean less(char[] source, int[] suffixes, int i, int j) {
		int fi = suffixes[i];
		int mi = suffixes[j];

		while (fi < source.length && mi < source.length) {
			if (source[fi] < source[mi])
				return true;
			else if (source[fi] > source[mi])
				return false;
			fi++;
			mi++;
		}

		return true;
	}
}
