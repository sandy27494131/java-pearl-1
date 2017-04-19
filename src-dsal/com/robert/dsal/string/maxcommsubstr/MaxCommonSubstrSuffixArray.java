package com.robert.dsal.string.maxcommsubstr;

import java.util.Arrays;

/**
 * 
 * O(nlog2n)， 主要用于排序，考虑到对比两个后缀数组指向的字串，O(c*nlog2n), c是对比时候的while循环，取决于字符相似度
 * 
 */
public class MaxCommonSubstrSuffixArray implements MaxCommonSubstr {
	public char[] maxCommonSubstr(char[] s1, char[] s2) {
		// 合并数组
		char[] source = new char[s1.length + s2.length];
		for (int i = 0; i < s1.length; i++) {
			source[i] = s1[i];
		}
		for (int j = 0; j < s2.length; j++) {
			source[s1.length + j] = s2[j];
		}

		// 初始化后缀数组
		int[] suffixes = new int[source.length];
		for (int i = 0; i < suffixes.length; i++) {
			suffixes[i] = i;
		}

		// 排序后缀数组

		sort(source, suffixes);

		// 计算排序后相邻连个字符串的公共字串
		int maxstart = -1;
		int maxlength = 0;

		for (int i = 0; i < suffixes.length - 1; i++) {
			int prev = suffixes[i];
			int next = suffixes[i + 1];

			if (prev < s1.length && next < s1.length)
				continue;

			if (prev >= s1.length && next <= s1.length)
				continue;

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
