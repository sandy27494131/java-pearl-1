package com.robert.dsal.lookup.app.findk;

import com.robert.dsal.util.DataUtil;
import com.robert.dsal.util.DisplayUtil;
import com.robert.dsal.util.TestUtil;

public class KthFinderTest {

	public void run() {
		KthFinder impl1 = new KthFinderDefault();
		KthFinder impl2 = new KthFinderRecursion();

		int[] seq = DataUtil.genSeq(10);
		DisplayUtil.printSeq("The Array", seq);

		int i1 = impl1.findKth(seq, 5);
		int i2 = impl2.findKth(seq, 5);
		System.out.println(i1 + ":" + i2);

		TestUtil.assertEqual(i1, i2);
	}

	public static void main(String[] args) {
		new KthFinderTest().run();
	}
}
