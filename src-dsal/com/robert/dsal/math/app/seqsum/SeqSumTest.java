package com.robert.dsal.math.app.seqsum;

public class SeqSumTest {
	public static void main(String[] args) {
		SeqSum ss = new SeqSumImpl();

		int sum = ss.sumSeq(2, 3);
		if (sum != 246) {
			System.err.println("Failed(2,3)");
		}

		sum = ss.sumSeq(-1, 3);
		if (sum != -1) {
			System.err.println("Failed(-1,3)");
		}

		sum = ss.sumSeq(2, -1);
		if (sum != -1) {
			System.err.println("Failed(2,-1)");
		}
	}
}
