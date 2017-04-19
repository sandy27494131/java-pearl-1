package com.robert.dsal.string.palindrome.partition;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 每次从左到右扫描，如果找到一个包含开始位置的回文，则递归求剩余元素的回文分区，然后把当前分区加入解决方案中。这是分治。
 * 
 */
public class PalindromePartitionDivideConquer implements PalindromePartition {

	public char[][][] partition(char[] s) {
		// 从0开始
		return partition(s, 0);
	}

	private char[][][] partition(char[] s, int start) {
		// 初始化结果集，第一维度是解决方案的个数，第二维度是每个解决方案包含的分区数，第二个维度是每个分区的字符数
		char[][][] currResult = new char[0][][];

		// 如果到了最右边一个元素，则递归返回，当前解就是最后一个元素
		if (start == s.length - 1) {
			currResult = new char[1][1][1];
			currResult[0][0][0] = s[start];

			return currResult;
		}

		// 从开始元素往后找到一个回文
		int i = start;
		while (i < s.length) {
			if (isPalindrome(s, start, i)) {
				// 找到回文后继续递归
				char[][][] nextResult = partition(s, i + 1);

				// 合并当前分区和后面的分区
				currResult = mergeResult(currResult, s, start, i, nextResult);
			}

			i++;
		}

		return currResult;
	}

	private char[][][] mergeResult(char[][][] currResult, char[] s, int start,
			int i, char[][][] nextResult) {
		char[][][] result = new char[currResult.length + nextResult.length][][];

		// 先拷贝已有的解决方案
		int j;
		for (j = 0; j < currResult.length; j++) {
			result[j] = currResult[j];
		}

		// 合并后面递归的解决方案
		for (int k = 0; k < nextResult.length; k++) {
			// 对于每一个解决方案
			char[][] partion = new char[nextResult[k].length + 1][];

			// 第一个分区就是当前回文
			partion[0] = new char[i - start + 1];
			for (int l = start; l <= i; l++) {
				partion[0][l - start] = s[l];
			}

			// 拷贝后面的分区
			for (int l = 0; l < nextResult[k].length; l++) {
				partion[l + 1] = nextResult[k][l];
			}
			result[j++] = partion;
		}

		return result;
	}

	private boolean isPalindrome(char[] s, int i, int j) {
		while (i < j && s[i++] != s[j--])
			return false;

		return true;
	}

	public List<List<String>> partition(String s) {
		return partition(s, 0);
	}

	private List<List<String>> partition(String s, int start) {
		List<List<String>> currResult = new ArrayList<List<String>>();

		if (start == s.length() - 1) {
			List<String> parts = new ArrayList<String>();
			parts.add(s.substring(s.length() - 1));

			currResult.add(parts);

			return currResult;
		}

		int i = start;

		while (i < s.length()) {
			if (isPalindrome(s.substring(start, i + 1))) {
				List<List<String>> nextResult = partition(s, i + 1);
				for (int j = 0; j < nextResult.size(); j++) {
					List<String> solution = nextResult.get(j);
					solution.add(0, s.substring(start, i + 1));
				}
				currResult.addAll(nextResult);
			}

			i++;
		}

		return currResult;
	}

	private boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;

		while (i < j && s.charAt(i++) != s.charAt(j--))
			return false;

		return true;
	}

}
