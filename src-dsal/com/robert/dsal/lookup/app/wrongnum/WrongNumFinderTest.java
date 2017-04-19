package com.robert.dsal.lookup.app.wrongnum;

import com.robert.dsal.util.DisplayUtil;
import com.robert.dsal.util.TestUtil;

public class WrongNumFinderTest {

	public void run() {
		final int N = 10;
		int[] seq = new int[N];
		for (int i = 0; i < N; i++) {
			seq[i] = i + 1;
		}
		seq[3] = 8;
		DisplayUtil.printSeq("aaa", seq);

		WrongNumFinder wnf1 = new WrongNumFinderImpl();
		int[] pair1 = wnf1.findWrongNum(seq);
		System.out.println(pair1[0] + ":" + pair1[1]);

		WrongNumFinder wnf2 = new WrongNumFinderBitmap();
		int[] pair2 = wnf2.findWrongNum(seq);
		System.out.println(pair2[0] + ":" + pair2[1]);

		TestUtil.assertEqual(pair1[0], pair2[0]);
		TestUtil.assertEqual(pair1[1], pair2[1]);
	}

	public static void main(String[] args) {
		new WrongNumFinderTest().run();
	}

}
