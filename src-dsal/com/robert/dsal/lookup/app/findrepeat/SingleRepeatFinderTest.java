package com.robert.dsal.lookup.app.findrepeat;

import com.robert.dsal.util.DisplayUtil;
import com.robert.dsal.util.TestUtil;

public class SingleRepeatFinderTest {
	public void run() {
		final int num = 1001;
		final int result = 888;
		int[] seq = new int[num];
		int i;
		for (i = 0; i < num - 1; i++) {
			seq[i] = i + 1;
		}
		seq[i] = result;
		DisplayUtil.printSeq("Data", seq);

		SingleRepeatFinder srf = new SingleRepeatFinderDefault();
		int target = srf.findSingleRepeat(seq);
		System.out.println("Find the target: " + target);

		TestUtil.assertEqual(target, result);
	}

	public static void main(String[] args) {
		new SingleRepeatFinderTest().run();
	}
}
