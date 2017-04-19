package com.robert.dsal.string.maxpalindrome;

import java.util.Arrays;

/**
 * 
 * 使用两个指针，一个开始指针，一个结尾指针，计算两个指针之间是不是回文。
 * 
 * O(n^2), 由于每次对比需要从开始字符往后对比，所以，还有个常系数，O(c*n^2), c是字符的平均相似长度
 *
 */
public class MaxPalindromeBruteForce implements MaxPalindrome {

	public char[] findMaxPalindrome(char[] str) {
		int start = -1;
		int count = 0;

		for (int i = 0; i < str.length - 1; i++) {
			for (int j = i + 1; j < str.length; j++) {
				if (isPalindrome(str, i, j) && j - i + 1 > count) {
					start = i;
					count = j - i + 1;
				}

			}
		}

		if (start != -1)
			return Arrays.copyOfRange(str, start, start + count);

		return null;
	}

	private boolean isPalindrome(char[] str, int i, int j) {
		while (i < j) {
			if (str[i++] != str[j--])
				return false;
		}

		return true;
	}

}
