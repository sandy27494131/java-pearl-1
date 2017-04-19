package com.robert.dsal.string.maxdupsubstr;

public class MaxDupSubstrTest {
	public static void main(String[] args) {
		String str = "bcabcefabcd";
		
		MaxDupSubstr mcs = new MaxDupSubstrSuffixArray();
		char[] common = mcs.maxCommStr(str.toCharArray());
		
		MaxDupSubstr mcs1 = new MaxDupSubstrBruteForce();
		char[] common1 = mcs1.maxCommStr(str.toCharArray());

		System.out.println(new String(common));
		System.out.println(new String(common1));
	}
}
