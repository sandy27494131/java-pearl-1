package com.robert.dsal.string.maxcommsubstr;

import java.util.Arrays;

/**
 * 
 * O(n^2) => 还有个常系数O(c*n^2), c取决于字符的相似程度，看下面while循环
 * 
 */
public class MaxCommonSubstrBruteForce implements MaxCommonSubstr {
	public char[] maxCommonSubstr(char[] s1, char[] s2) {
		int maxStart = -1;
		int maxLength = 0;

		for (int i = 0; i < s1.length; i++) {
			for (int j = 0; j < s2.length; j++) {
				int k = 0;
				while (i + k < s1.length && j + k < s2.length
						&& s1[i + k] == s2[j + k])
					k++;

				if (k > maxLength) {
					maxStart = i;
					maxLength = k;
				}

			}
		}

		if (maxStart != -1)
			return Arrays.copyOfRange(s1, maxStart, maxStart + maxLength);

		return null;
	}
}
