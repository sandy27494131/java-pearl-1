package com.robert.dsal.math.probability.randomnlines;

import java.util.Date;
import java.util.Iterator;
import java.util.Random;

public class SampleNNoDup implements SampleN {

	public int[] sample(Iterator<Integer> x, int n) {
		Random random = new Random(new Date().getTime());

		int[] results = new int[n];

		for (int i = 0; i < results.length; i++) {
			int one = -1;
			// x is not reusable, need to refactor
			while (contains(results, (one = sampleOne(x, n, random))))
				;

			results[i] = one;
		}

		return results;
	}

	private boolean contains(int[] results, int t) {
		for (int j = 0; j < results.length; j++) {
			if (results[j] == t)
				return true;
		}
		return false;
	}

	public int sampleOne(Iterator<Integer> x, int n, Random random) {
		int ret = -1;

		int count = 1;
		while (x.hasNext()) {
			int rand = random.nextInt();

			if (rand % count == 0) {
				ret = x.next().intValue();
			}
			count++;
		}

		return ret;
	}

}
