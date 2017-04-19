package com.robert.dsal.math.app.selfexplainseries;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SelfExplainSeriesTest {

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			boolean b = test(new byte[] { 1 }, new Random(new Date().getTime() * i).nextInt(5) + 5);
			System.out.println();

			// TODO Still can't pass through the test case, possible byte out of
			// scope
			if (!b)
				System.err.println("Error!");
		}
	}

	private static boolean test(byte[] init, int num) {
		SelfExplainSeries ses = new SelfExplainSeries(init, num);

		List<Element> s1 = new ArrayList<Element>();
		List<Element> s2 = new ArrayList<Element>();

		int count = 0;
		Iterator<Element> iter = ses.iterator();
		while (iter.hasNext()) {
			boolean b = new Random(new Date().getTime() * count++)
					.nextBoolean();
			if (b)
				s1.add(iter.next());
			else
				s2.add(iter.next());
		}

		System.out.println(s1);
		System.out.println(s2);

		SameSeries ss = new SameSelfExplainSeries();
		boolean b = ss.isSameSeries(s1, s2);

		return b;
	}

}
