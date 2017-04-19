package com.robert.dsal.lookup.app.wrongnum;

import com.robert.dsal.sort.QuickSort;

public class WrongNumFinderImpl implements WrongNumFinder {

	public int[] findWrongNum(int[] seq) {
		int[] sortedSeq = seq.clone();
		new QuickSort().sort(sortedSeq);

		int[] result = new int[2];
		for (int i = 0; i < seq.length; i++)
			if (i + 1 < seq.length) {
				if (sortedSeq[i] == sortedSeq[i + 1])
					result[0] = sortedSeq[i];

				if (sortedSeq[i + 1] - sortedSeq[i] == 2)
					result[1] = sortedSeq[i] + 1;
			}

		return result;
	}

}
