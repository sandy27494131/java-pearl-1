package com.robert.dsal.lookup.app.findsingleodd;

public class SignleOddFinderDefault implements SignleOddFinder {
	public int findSingleOdd(int[] seq) {
		if (seq.length % 2 == 0)
			return -1;

		int result = seq[0];
		for (int i = 1; i < seq.length; i++) {
			result ^= seq[i];
		}

		return result;
	}
}
