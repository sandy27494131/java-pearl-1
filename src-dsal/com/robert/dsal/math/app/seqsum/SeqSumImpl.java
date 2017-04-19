package com.robert.dsal.math.app.seqsum;

public class SeqSumImpl implements SeqSum {
	public int sumSeq(int num, int times) {
		if (num <= 0 || num > 9 || times <= 0)
			return -1;

		return doSumSeq(num, times);
	}

	private int doSumSeq(int num, int times) {
		int weight = 1;

		int res = 0;

		for (int i = times; i >= 1; i--) {
			res += num * weight * i;
			weight *= 10;
		}

		return res;
	}
}
