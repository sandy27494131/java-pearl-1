package com.robert.dsal.string.maxpalindrome;

public class MaxPalindromeTest {
	public static void main(String[] args) {
		char[] str = "xxxyabcbaxxxydsakfafsa".toCharArray();
		char[] str1 = "sadfasfdsaxabcbayjl;jlll".toCharArray();

		MaxPalindrome mp = new MaxPalindromeBruteForce();
		MaxPalindrome mp1 = new MaxPalindromeSuffixArray();

		char[] maxp = mp.findMaxPalindrome(str);
		char[] maxp1 = mp1.findMaxPalindrome(str1);
		System.out.println(maxp);
		System.out.println(maxp1);
	}
}
