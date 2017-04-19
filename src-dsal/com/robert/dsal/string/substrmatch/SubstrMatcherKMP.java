package com.robert.dsal.string.substrmatch;

import java.util.Arrays;

/**
 * 
 * abcdefg abcdefh
 * 
 * 索引为6的字符不等，索引为0到5的字符都相等，所以，第二个串的0索引上的字符和第二个串的1-5索引上的字符不等，但是1-5索引上的字符都相等，
 * 所以，第二个串的索引0不需要和第一个串1-5索引对比，一定不相等，直接和第六个对比
 * 
 * when i == 6, j == 6 a[i] != b[j] 
 * i不变 j回溯到0
 * 
 * 这是KMP的思想。
 * 
 * 
 * 更通用来讲，回溯到最大前后缀
 * 
 * abcabcg abcabch
 * 
 * when i == 6, j == 6 a[i] != b[j] 
 * i不变 j回溯到backtrace[j], j = backtrace[j];
 * 
 * backtrace数字其实就是当前字符前面最大的相等的前后缀
 * 
 * abcabch, h位的前后缀是abc = abc，因此h位取值为3
 * aaaaah, h前有5个a，那么h取值4，前后缀要至少比整个字串少一个字符，也就是aaa = aaa
 * 
 * 时间复杂度在原串和目标串相似较高的情况下能够接近于线性
 * 
 * 
 */

public class SubstrMatcherKMP implements SubstrMatcher {
	public int[] indexesOf(char[] source, char[] target) {
		int[] indexes = new int[source.length];
		int count = 0;

		int[] backtrace = getBacktrace(target);

		int i = 0, j = 0;

		while (i < source.length) {
			if (source[i] == target[j]) {
				if (j == target.length - 1) {
					// 获得一个解
					indexes[count++] = i - j;

					// 回溯
					i++;
					j = backtrace[j];
					continue;
				}

				// 两个字符相等，向前推进
				i++;
				j++;
			} else if (j == 0) {
				// 如果第一个字符不等，则source串向前推进1个字符
				i++;
			} else {
				// 如果从第二个字符开始某个字符不等，则目标串回溯
				j = backtrace[j];
			}
		}

		return Arrays.copyOf(indexes, count);
	}

	public int indexOf(char[] source, char[] target) {
		int[] backtrace = getBacktrace(target);

		int i = 0, j = 0;

		while (i < source.length && j < target.length) {
			if (source[i] == target[j]) {
				// 两个字符相等，向前推进
				i++;
				j++;
			} else if (j == 0) {
				// 如果第一个字符不等，则source串向前推进1个字符
				i++;
			} else {
				// 如果从第二个字符开始某个字符不等，则目标串回溯
				j = backtrace[j];
			}
		}

		if (j == target.length)
			return i - target.length;

		return -1;
	}

	/**
	 * 
	 * 取得回溯的索引数组
	 * 
	 *  ababcdef 
	 * -10012000
	 * 
	 * 1. 第一个字符的回溯索引是-1，这个没有用到
	 * 2. 对于任意一个字符，看它前面的所有字符，最大的前缀等于最大的后缀，那么前后缀的长度就是当前字符的回溯索引，前缀必须是小于整个字串的长度 
	 * 2.1 index = 1, 前面a，没有前后缀，所以是0 
	 * 2.2 index = 2, 前面ab，没有钱后缀，所以是0 
	 * 2.3 index = 3, 前面aba，前缀a等于后缀a，所以是1
	 * 
	 * 3. aaaab中的b，应该取值3，因为前面字符aaaa的前后缀均为3， 4 -1 = 3, 前后缀不能是整个串，至少少一个字符
	 * 
	 */
	private int[] getBacktrace(char[] chars) {
		int[] backtrace = new int[chars.length];

		// 第一个字符的回溯值为-1
		backtrace[0] = -1;
		// 初始化的时候i指向0索引前面的虚拟索引-1, j指向第一个索引0
		int i = -1, j = 0;

		while (j < chars.length - 1) {
			// 在i = -1的时候是初始化或者回溯到初始化的时候，或者i和j所在字符相等的时候，向前推进并且把i的索引复制给j所在的回溯索引
			if (i == -1 || chars[i] == chars[j]) {
				i++;
				j++;
				backtrace[j] = i;
			} else {
				// 如果i和j所在的字符不等，那么i需要回溯到之前没有前缀的时候
				i = backtrace[i];
			}
		}

		return backtrace;
	}

}
