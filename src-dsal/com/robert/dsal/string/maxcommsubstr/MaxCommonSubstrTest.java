package com.robert.dsal.string.maxcommsubstr;

public class MaxCommonSubstrTest {
	public static void main(String[] args) {
		MaxCommonSubstr mcs = new MaxCommonSubstrBruteForce();
		MaxCommonSubstr mcs1 = new MaxCommonSubstrSuffixArray();
		char[] comm = mcs.maxCommonSubstr("abcdexxxx".toCharArray(),
				"yyyabcdeyy".toCharArray());
		char[] comm1 = mcs1.maxCommonSubstr("abcdexxxx".toCharArray(),
				"yyyabcdeyy".toCharArray());
		System.out.println(new String(comm));
		System.out.println(new String(comm1));
	}
}
