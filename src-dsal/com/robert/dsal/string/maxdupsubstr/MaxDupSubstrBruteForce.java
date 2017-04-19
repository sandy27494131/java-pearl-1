package com.robert.dsal.string.maxdupsubstr;

import java.util.Arrays;

/**
 * 
 * O(n^2)，由于内层while循环，应该还有个常系数, O(c*n^2)
 * 
 */
public class MaxDupSubstrBruteForce implements MaxDupSubstr {
	public char[] maxCommStr(char[] source) {
		int maxStart = -1;
		int maxLength = 0;

		for (int i = 0; i < source.length; i++) {
			for (int j = i + 1; j < source.length; j++) {
				int k = 0;
				while (j + k < source.length && source[i + k] == source[j + k])
					k++;

				if (k > maxLength) {
					maxStart = i;
					maxLength = k;
					continue;

				}
			}
		}

		if (maxStart != -1)
			return Arrays.copyOfRange(source, maxStart, maxStart + maxLength);

		return null;
	}
}
