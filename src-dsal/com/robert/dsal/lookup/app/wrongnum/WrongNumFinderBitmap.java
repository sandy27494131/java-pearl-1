package com.robert.dsal.lookup.app.wrongnum;

import java.util.BitSet;

public class WrongNumFinderBitmap implements WrongNumFinder {

	public int[] findWrongNum(int[] seq) {
		BitSet bs = new BitSet(seq.length);

		int[] result = new int[2];
		for (int i = 0; i < seq.length; i++) {
			if (bs.get(seq[i] - 1)) {
				result[0] = seq[i];
			}

			bs.set(seq[i] - 1);
		}

		for (int i = 0; i < seq.length; i++) {
			if (!bs.get(i)) {
				result[1] = i + 1;
			}
		}

		return result;
	}

}
