package com.robert.dsal.classic.steps;

/**
 * 
 * 一个数字n经过一些步骤得到1，那么经过的步数，是n的步长。
 * 
 * n是偶数：
 * 
 * n = n / 2;
 * 
 * n是奇数：
 * 
 * n = 3*n + 1;
 * 
 * 现在如何计算这个步长，输入可能是有多个这样的数字。
 * 
 */

public class Steps21 {
	public static void main(String[] args) {
		// 构造步长数组
		int[] buffer = new int[2000000];

		buffer[1] = 0;
		for (int i = 2; i < buffer.length; i++) {
			if (buffer[i] == 0)
				buffer[i] = fill(buffer, i);
		}

		for (int i = 0; i < buffer.length; i++) {
			System.out.println(i + ":" + buffer[i]);
		}
	}

	private static int fill(int[] buffer, int i) {
		if (i == 1)
			return 0;

		if (i % 2 == 0)
			return fill(buffer, i / 2) + 1;

		if (i % 2 != 0)
			return fill(buffer, i * 3 + 1) + 1;

		return 0;
	}
}
