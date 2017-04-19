package com.robert.dsal.math.app.xyzpower;

import java.util.Arrays;

/**
 * 
 * z*z最大是n^2, x*x最大是当y=0时， x^2 = n^2, 所以，x最大就是n
 * 
 * 算法时间复杂度： O(n^3)
 * 
 */
public class XyzPowerBruteForce implements XyzPower {

	public int[][] find(int n) {
		int[][] results = new int[n][];
		int count = 0;

		for (int i = 1; i <= n; i++)
			for (int j = i; j <= n; j++)
				for (int k = 1; k <= n; k++)
					if (i * i + j * j == k * k) {
						int[] result = new int[3];
						result[0] = i;
						result[1] = j;
						result[2] = k;
						results[count++] = result;
					}

		return Arrays.copyOfRange(results, 0, count);
	}

}
