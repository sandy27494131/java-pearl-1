package com.robert.dsal.lookup.app.finddoubleodd;

/**
 * 提高了方法 findFirstDiffBit()
 */
public class DoulbeOddFinderByBitOper1 extends DoulbeOddFinderByBitOper {

	protected int findFirstDiffBit(int[] seq) {
		int s = seq[0];

		for (int i = 0; i < seq.length; i++) {
			s ^= seq[i];
		}

		int i = 0;

		while (i < 32) {
			if ((s & 1 << i) != 0)
				return i;

			i++;
		}

		return -1;
	}
}
