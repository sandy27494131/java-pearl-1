package com.robert.dsal.lookup.app.findsum;

import java.util.List;

import com.robert.dsal.util.DisplayUtil;
import com.robert.dsal.util.SeqUtil;

public class Find2SumTest {
	public static void main(String[] args) {
		Find2Sum fs = new Find2SumHash();
		Find2Sum fs1 = new Find2SumHash();

		int[] seq = SeqUtil.genRandomSeq(10);
		DisplayUtil.printSeq("", seq);
		List<int[]> result = fs.find2Sum(seq, seq[0] + seq[3]);
		List<int[]> result1 = fs1.find2Sum(seq, seq[0] + seq[3]);

		for (int i = 0; i < result.size(); i++) {
			int[] t = result.get(i);

			System.out.println(t[0] + ":" + t[1]);
		}

		for (int i = 0; i < result1.size(); i++) {
			int[] t = result1.get(i);

			System.out.println(t[0] + ":" + t[1]);
		}
	}
}
