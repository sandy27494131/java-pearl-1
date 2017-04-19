package com.robert.dsal.string.substrmatch;

import java.util.Arrays;

/**
 * 
 * O(n * m)
 *
 */
public class SubstrMatcherBruteForce1 implements SubstrMatcher {
	public int[] indexesOf(char[] source, char[] target) {
		int[] indexes = new int[source.length];
		int count = 0;

		for (int i = 0; i < source.length - target.length + 1; i++) {
			boolean match = true;
			for (int j = 0; j < target.length; j++) {
				if (source[i + j] != target[j]) {
					match = false;
					break;
				}
			}
			if (match)
				indexes[count++] = i;
		}

		return Arrays.copyOf(indexes, count);
	}

	public int indexOf(char[] source, char[] target) {

		for (int i = 0; i < source.length - target.length; i++) {
			boolean match = true;
			for (int j = 0; j < target.length; j++) {
				if (source[i + j] != target[j]) {
					match = false;
					break;
				}
			}
			if (match)
				return i;
		}

		return -1;
	}
}
