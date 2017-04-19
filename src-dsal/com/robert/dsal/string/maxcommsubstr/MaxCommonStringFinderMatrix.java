package com.robert.dsal.string.maxcommsubstr;

// Still can't understand

//TODO Move to string.maxcommonsubstr

//TODO 这是一种动态规划的方法求最大公共子序列

/**
 * 
 * 求两个字符串最长公共字串，
 * 算法：两个字符串形成一个矩阵，将两个字符不匹配的位置标记为0，c[i][j]中两个字符相匹配的位置标记为n,其中n=c[i-1][j-1]+1,
 * 其中沿正对角线方向最长的序列为两个字串的最长公共子序列
 * 
 * 生成二维矩阵：
 * 
 * 0 0 0 1 0 0 0 1 1 0 0 1 0 0 　 0 1 0 0 0 0 0 0 0 2 1 0 0 0 　 　1 0 2 0 1 0 1 0
 * 0 0 0 0 1 0 　 　0 2 0 0 0 0 0 0 0 1 1 0 0 0 　 　1 0 3 0 1 0 1 0 0 0 0 0 1 0 　
 * 　0 0 0 4 0 0 0 2 1 0 0 1 0 0 　　 1 0 1 0 5 0 1 0 0 0 0 0 2 0 　 　1 0 1 0 1 0 1
 * 0 0 0 0 0 1 0 　 　0 0 0 2 0 0 0 2 1 0 0 1 0 0 　 　0 0 0 0 0 0 0 0 0 0 0 0 0 1
 * 　　 0 0 0 0 0 0 0 0 0 0 0 0 0 1 　 　0 0 0 0 0 1 0 0 0 0 0 0 0 0
 */
public class MaxCommonStringFinderMatrix implements MaxCommonStringFinder {
	public String findMaxCommonString(String s1, String s2) {
		return findMaxCommonString(s1.toCharArray(), s2.toCharArray());
	}

	public String findMaxCommonString(char[] c1, char[] c2) {
		// TODO to be classified

		int[][] c = new int[c1.length][c2.length];
		int start = 0; // 记录公共子串的起始位置
		int end = 0;// 记录公共子串的结束位置
		int maxLength = 0;// 记录最长公共子串的长度

		for (int i = 0; i < c1.length; i++) {
			for (int j = 0; j < c2.length; j++) {
				if (c1[i] == c2[j]) {
					if (i == 0 || j == 0) {
						c[i][j] = 1;
					} else {
						c[i][j] = c[i - 1][j - 1] + 1;
					}
				} else {
					c[i][j] = 0;
				}

				if (c[i][j] > maxLength) {
					maxLength = c[i][j];
					end = j;
				}
			}
		}
		start = end - maxLength + 1;

		char[] p = new char[maxLength];

		for (int k = start; k <= end; k++) {
			p[k - start] = c2[k];
		}

		return String.valueOf(p);
	}

}
