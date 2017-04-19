package com.robert.dsal.string.maxpalindrome;

import java.util.Arrays;

/**
 * 
 * 1. 将串逆转，求原串和逆串的最大公共字串。 
 * 2. 将原串和逆串合并成一个串，然后，求出后缀数组，然后排序。 
 * 3. 求出相邻两个后缀字串的最大公共字串，并且两个串要分别在原串和逆串中。
 * 
 * 这个程序主要的时间用户后缀数组的排序，后缀数组排序需要O(nlog2n), 但是由于每次对比，需要从两个开始位置往后对比，看方法less()，所以，取决于串的相似程度，通常会有个常系数O(c*nlog2n), c是字符的平均相似程度
 * 
 */
public class MaxPalindromeSuffixArray implements MaxPalindrome {

	public char[] findMaxPalindrome(char[] str) {
		// 将串和逆串合并成一个单独的串
		char[] total = new char[str.length * 2];
		for (int i = 0; i < str.length; i++) {
			total[i] = str[i];
			total[total.length - 1 - i] = str[i];
		}

		// 初始化后缀数组
		int[] suffix = new int[total.length];
		for (int i = 0; i < suffix.length; i++) {
			suffix[i] = i;
		}

		// 排序后缀数组
		sort(total, suffix);

		// 找出后缀数组中相邻两个元素字符相同最长的那个字串
		return maxCommon(total, suffix);
	}

	private void sort(char[] total, int[] suffix) {
		qsort(total, suffix, 0, total.length - 1);
	}

	private void qsort(char[] total, int[] suffix, int i, int j) {
		if (i >= j)
			return;

		int m = partition(total, suffix, i, j);

		qsort(total, suffix, i, m - 1);
		qsort(total, suffix, m + 1, j);
	}

	private int partition(char[] total, int[] suffix, int i, int j) {
		int m = i;

		// 如果循环次数固定，没有回溯，有限考虑使用for循环，如果有回溯，考虑用while
		for (int k = i + 1; k <= j; k++) {
			int ii = suffix[i];
			int ik = suffix[k];

			if (less(total, ik, ii))
				swap(suffix, ++m, k);
		}

		swap(suffix, i, m);

		return m;
	}

	private boolean less(char[] total, int i, int j) {
		while (i < total.length && j < total.length) {
			// 如果某个字符小，那一定是小于，如果某个字符大一定是大于
			// 如果某个字符相等，则看下一个字符
			if (total[i] < total[j])
				return true;
			else if (total[i] > total[j])
				return false;

			// 对于任何一个while循环，请检查递增或递减条件，以免陷入死循环
			i++;
			j++;
		}

		return false;
	}

	private void swap(int[] suffix, int i, int j) {
		int t = suffix[i];
		suffix[i] = suffix[j];
		suffix[j] = t;
	}

	private char[] maxCommon(char[] total, int[] suffix) {
		int maxline = -1;
		int maxcount = 0;

		for (int i = 0; i < suffix.length - 1; i++) {
			int prev = suffix[i];
			int next = suffix[i + 1];

			// 确保一个串来自原串，一个串来自逆串
			if (prev < suffix.length / 2 && next < suffix.length / 2)
				continue;
			if (prev >= suffix.length / 2 && next >= suffix.length / 2)
				continue;

			int count = count(total, prev, next);
			if (count > maxcount) {
				maxline = prev;
				maxcount = count;
			}

		}

		if (maxline != -1)
			return Arrays.copyOfRange(total, maxline, maxline + maxcount);

		return null;
	}

	private int count(char[] total, int prev, int next) {
		int count = 0;

		while (prev < total.length && next < total.length)
			// 注意循环变量递增和递减，以免死循环
			if (total[prev++] == total[next++])
				count++;

		return count;
	}

}
