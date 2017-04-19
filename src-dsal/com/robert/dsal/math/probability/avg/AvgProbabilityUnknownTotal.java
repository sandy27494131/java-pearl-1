package com.robert.dsal.math.probability.avg;

import java.util.Random;

/**
 * 
 * 在未知总数量的时候，还要确保对于每个元素的选择概率是相同的
 * 
 */
public class AvgProbabilityUnknownTotal {

	public int getProbability(int max) {
		int probablity = -1;

		Random random = new Random();
		for (int i = 0; i < max; i++) {
			int rand = random.nextInt();
			if (rand < 0)
				rand = -rand;

			if (rand % (i + 1) == 0) {
				probablity = i;
			}
		}

		return probablity;
	}
}
