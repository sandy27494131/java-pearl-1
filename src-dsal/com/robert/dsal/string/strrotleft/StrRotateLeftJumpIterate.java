package com.robert.dsal.string.strrotleft;

/**
 * 
 * Near to O(n)
 * 
 */
public class StrRotateLeftJumpIterate implements StrRotateLeft {
	public void rotateLeft(char[] source, int size) {
		int gcd = gcd(size, source.length);

		// 一共循环最大公约数的次数
		for (int i = 0; i < gcd; i++) {
			char t = source[i];

			// 每次走要移动的字符数量那么大
			int m = i;
			int n = m + size;

			while (true) {
				if (n >= source.length)
					n -= source.length;
				if (n == i) {
					source[m] = t;
					break;
				}

				source[m] = source[n];
				m = n;
				n = m + size;
			}
		}
	}

	private int gcd(int i, int j) {
		// 如果j比i大，则交换
		if (j > i) {
			i = i + j;
			j = i - j;
			i = i - j;
		}

		// 求最大公约数
		int r = i % j;

		while (r != 0) {
			i = j;
			j = r;

			r = i % j;
		}

		return j;
	}
}
