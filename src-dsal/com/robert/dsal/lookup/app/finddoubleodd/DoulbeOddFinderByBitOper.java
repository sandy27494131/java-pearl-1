package com.robert.dsal.lookup.app.finddoubleodd;

import java.util.Arrays;

/**
 * 
 * 2、有N＋2个数，N个数出现了偶数次，2个数出现了奇数次（这两个数不相等），问用O（1）的空间复杂度，找出这两个数。 *
 * 
 * 解法：两个数字不同，必然后某一个二进制位不同，一个是0，
 * 一个是1，对于每一位异或后，如果结果仍然是1，那么就说明这一位这两个数字不同，根据这位分成2组，这两个数字分别在不同的组里，然后用异或求出来各自是谁
 */
public class DoulbeOddFinderByBitOper implements DoubleOddFinder {

	public int[] findDoubleOdd(int[] seq) {

		int pos = findFirstDiffBit(seq);

		int[][] colls = separate(seq, pos);

		int result1 = calculateOne(colls[0]);
		int result2 = calculateOne(colls[1]);

		int[] result = new int[2];

		result[0] = result1;
		result[1] = result2;

		return result;
	}

	private int calculateOne(int[] seq) {
		int result = seq[0];

		for (int i = 1; i < seq.length; i++) {
			result ^= seq[i];
		}

		return result;
	}

	private int[][] separate(int[] seq, int pos) {
		int mask = 1 << pos;

		int[][] result = new int[2][];
		result[0] = new int[seq.length];
		result[1] = new int[seq.length];
		int c1 = 0, c2 = 0;

		for (int i = 0; i < seq.length; i++) {
			if ((seq[i] & mask) != 0) {
				result[0][c1++] = seq[i];
			} else {
				result[1][c2++] = seq[i];
			}
		}

		result[0] = Arrays.copyOfRange(result[0], 0, c1);
		result[1] = Arrays.copyOfRange(result[1], 0, c2);

		return result;
	}

	protected int findFirstDiffBit(int[] seq) {
		int pos = 0;
		int mask = 1;

		while (true) {
			int sum = 0;

			for (int i = 0; i < seq.length; i++)
				sum ^= seq[i] & mask;

			if (sum != 0)
				return pos;

			mask <<= 1;
			pos++;
		}
	}
}
