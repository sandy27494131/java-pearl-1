package com.robert.dsal.math.probability.randomnlines;

import java.util.Date;
import java.util.Iterator;
import java.util.Random;

public class SampleNImpl implements SampleN {

	/*
	 * 有重复元素，可以取2n个，然后再排序，取n个
	 */

	public int[] sample(Iterator<Integer> x, int n) {
		Random random = new Random(new Date().getTime());

		int[] results = new int[n];

		int count = 1;
		while (x.hasNext()) {
			for (int i = 0; i < n; i++) {
				int rand = random.nextInt();

				if (rand % count == 0) {
					results[i] = x.next().intValue();
				}
			}
			count++;
		}

		return results;
	}

}
