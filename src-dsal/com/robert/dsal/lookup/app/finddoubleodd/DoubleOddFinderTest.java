package com.robert.dsal.lookup.app.finddoubleodd;

import com.robert.dsal.util.DisplayUtil;
import com.robert.dsal.util.TestUtil;

public class DoubleOddFinderTest {
	public void run() {
		final int num = 10;
		final int result1 = 8888;
		final int result2 = 6666;
		int[] seq = new int[num];
		int i;
		for (i = 0; i < num / 2 - 1; i++) {
			seq[i] = seq[num - 1 - i] = i;
		}
		seq[i] = result1;
		seq[i + 1] = result2;
		DisplayUtil.printSeq("Data", seq);

		DoubleOddFinder sofMyImpl = new DoulbeOddFinderByBitOper1();
		int[] resultMyImpl = sofMyImpl.findDoubleOdd(seq);
		System.out.format("Find the target in myImpl: %d/%d", resultMyImpl[0],
				resultMyImpl[1]);
		System.out.println();

		TestUtil.assertContains(new int[] { resultMyImpl[0], resultMyImpl[1] },
				result1);
		TestUtil.assertContains(new int[] { resultMyImpl[0], resultMyImpl[1] },
				result2);
	}

	public static void main(String[] args) {
		new DoubleOddFinderTest().run();
	}
}
