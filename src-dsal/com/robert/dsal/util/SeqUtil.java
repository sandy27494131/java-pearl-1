package com.robert.dsal.util;

import java.util.Date;
import java.util.Random;

public class SeqUtil {
	public static int[] genRandomSeq(int length) {
		int[] seq = new int[length];

		Random random = new Random();
		for (int i = 0; i < seq.length; i++) {
			random.setSeed(i * new Date().getTime());
			seq[i] = random.nextInt(100);
		}

		return seq;
	}
}
