package com.robert.dsal.string.substrmatch;

import com.robert.dsal.util.DisplayUtil;

public class SubstrMatcherTest {
	public void run() {
		String s = "abcdefgabcdgabcdg";
		String t = "abcdg";

		SubstrMatcher ksf = new SubstrMatcherBruteForce1();
		int[] results = ksf.indexesOf(s.toCharArray(), t.toCharArray());
		int result = ksf.indexOf(s.toCharArray(), t.toCharArray());

		DisplayUtil.printSeq("Brute Force: indexesOf", results);
		System.out.println("Brute Force: indexOf: 		" + result);

		SubstrMatcher ksf1 = new SubstrMatcherKMP();
		int[] results1 = ksf1.indexesOf(s.toCharArray(), t.toCharArray());
		int result1 = ksf1.indexOf(s.toCharArray(), t.toCharArray());

		DisplayUtil.printSeq("KMP: indexesOf", results1);
		System.out.println("KMP: indexOf: 		" + result1);
	}

	public static void main(String[] args) {
		new SubstrMatcherTest().run();
	}
}
