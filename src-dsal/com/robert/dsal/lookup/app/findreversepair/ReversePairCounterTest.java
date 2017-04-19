package com.robert.dsal.lookup.app.findreversepair;

import com.robert.dsal.util.DataUtil;
import com.robert.dsal.util.DisplayUtil;
import com.robert.dsal.util.TestUtil;

public class ReversePairCounterTest {

	public void run() {
		ReversePairCounter rpc1 = new ReversePairCounterDefault();
		ReversePairCounter rpc2 = new ReversePairCounterMerge();

		int[] seq = DataUtil.genSeq(100);
		DisplayUtil.printSeq("Data", seq);

		int count1 = rpc1.countReversePair(seq);
		int count2 = rpc2.countReversePair(seq);

		System.out.println(count1 + ":" + count2);
		TestUtil.assertEqual(count1, count2);
	}

	public static void main(String[] args) {
		new ReversePairCounterTest().run();
	}

}
