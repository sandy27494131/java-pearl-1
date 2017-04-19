package com.robert.dsal.lookup;

import com.robert.dsal.util.DisplayUtil;

public class BinaryChopLookupTest {
	public void run() {
		int[] sortSeq = { 5, 5, 5, 5, 5, 5, 5};
		int target = 5;

		Lookup lookup = new BinaryChopLookup();
		Lookup lookupr = new BinaryChopRecursiveLookup();
		int i0 = lookup.lookup(sortSeq, target);
		int i1 = lookupr.lookup(sortSeq, target);

		int i2 = lookup.lookupFirst(sortSeq, target);
		int i3 = lookupr.lookupFirst(sortSeq, target);

		int i4 = lookup.lookupLast(sortSeq, target);
		int i5 = lookupr.lookupLast(sortSeq, target);

		DisplayUtil.printSeq("Look for " + target, sortSeq);
		System.out.println(i0 + ":" +i1 + ":" +i2 + ":" +i3 + ":" +i4 + ":" +i5);
	}

	public static void main(String[] args) {
		new BinaryChopLookupTest().run();
	}
}
