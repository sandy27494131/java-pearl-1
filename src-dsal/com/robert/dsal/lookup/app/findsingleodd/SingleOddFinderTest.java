package com.robert.dsal.lookup.app.findsingleodd;

import com.robert.dsal.util.DisplayUtil;
import com.robert.dsal.util.TestUtil;

public class SingleOddFinderTest {
	public void run() {
		final int num = 11;
		final int result = 8888;
		int[] seq = new int[num];
		int i;
		for (i = 0; i < num / 2; i++) {
			seq[i] = seq[num - 1 - i] = i;
		}
		seq[i] = result;
		DisplayUtil.printSeq("Data", seq);

		SignleOddFinder sof = new SignleOddFinderDefault();
		int target = sof.findSingleOdd(seq);
		System.out.println("Find the target: " + target);

		TestUtil.assertEqual(target, result);
	}

	public static void main(String[] args) {
		new SingleOddFinderTest().run();
	}
}
