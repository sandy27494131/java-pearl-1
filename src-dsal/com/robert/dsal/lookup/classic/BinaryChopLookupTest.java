package com.robert.dsal.lookup.classic;

import com.robert.dsal.util.DisplayUtil;

public class BinaryChopLookupTest {
	public void run() {
		int[] sortSeq = { 5, 5, 5, 5, 5, 5, 5 };
		int target = 5;

		Lookup lookup = new BinaryChopLookup();
		lookup.setup(sortSeq);
		int i0 = lookup.lookup(target);

		DisplayUtil.printSeq("Look for " + target, sortSeq);
		System.out.println(i0);
	}

	public static void main(String[] args) {
		new BinaryChopLookupTest().run();
	}
}
