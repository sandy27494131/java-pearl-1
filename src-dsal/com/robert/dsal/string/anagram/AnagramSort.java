package com.robert.dsal.string.anagram;

public class AnagramSort implements Anagram {
	public boolean isAnagramPalindrome(char[] str) {
		sort(str);

		int count = 0;
		for (int i = 0; i < str.length; i++) {
			// 注意最后一个字符
			if (i + 1 >= str.length || str[i] != str[i + 1])
				count++;
			else {
				i++;
			}
		}

		if (count == 0 || count == 1)
			return true;
		return false;
	}

	private void sort(char[] str) {
		qsort(str, 0, str.length - 1);
	}

	private void qsort(char[] str, int i, int j) {
		if (i >= j)
			return;

		int m = partition(str, i, j);
		qsort(str, i, m - 1);
		qsort(str, m + 1, j);
	}

	private int partition(char[] str, int i, int j) {
		int m = i;
		for (int k = i + 1; k <= j; k++) {
			if (str[k] < str[i])
				swap(str, ++m, k);
		}
		swap(str, m, i);
		return m;
	}

	private void swap(char[] str, int m, int n) {
		char t = str[m];
		str[m] = str[n];
		str[n] = t;
	}
}
