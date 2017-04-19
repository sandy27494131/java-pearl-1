package com.robert.dsal.string.substrmatch;

import java.util.Arrays;

/**
 * 
 * O(n * m)
 *
 */
public class SubstrMatcherBruteForce implements SubstrMatcher {
	public int[] indexesOf(char[] source, char[] target) {
		int[] indexes = new int[source.length];
		int count = 0;

		int i = -1, j = -1;
		int s = -1;

		while (i < source.length - 1) {
			if (source[++i] == target[++j]) {
				// 如果两个字符相等，则继续推进
				if (j == 0)
					// 如果是第一个字符相等，则保存开始位置
					s = i;
				else if (j == target.length - 1) {
					// 如果目标串的最后一个字符相等，则s就是其中的一个匹配
					indexes[count++] = s;

					// 继续搜索剩余字符串，则source在上次匹配开始向前推进一个字符，由于初始化是在-1，所以直接取s，也就是对比下一个字符，target应该回溯到第一个字符之前-1
					i = s;
					j = -1;
				}
			} else {
				// 如果两个字符不等，则source应该推进一个字符，也就是对比下一个字符，target应该回溯到第一个字符
				i -= j;
				j = -1;
			}
		}

		return Arrays.copyOf(indexes, count);
	}

	public int indexOf(char[] source, char[] target) {
		int i = -1, j = -1;
		int s = -1;

		while (i < source.length - 1) {
			if (source[++i] == target[++j]) {
				// 如果两个字符相等，则继续推进
				if (j == 0)
					// 如果是第一个字符相等，则保存开始位置
					s = i;
				else if (j == target.length - 1) {
					// 如果目标串的最后一个字符相等，则返回开始位置
					return s;
				}
			} else {
				// 如果两个字符不等，则source应该对比上次开始的推进一个字符，也就是下一个字符，target应该回溯到第一个字符
				i -= j;
				j = -1;
			}
		}

		return s;
	}
}
