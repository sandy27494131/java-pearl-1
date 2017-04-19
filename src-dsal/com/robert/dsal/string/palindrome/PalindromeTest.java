package com.robert.dsal.string.palindrome;

import com.robert.dsal.util.TestUtil;

public class PalindromeTest {
	public void run() {

		Palindrome p = new PalindromeBruteForce();
		Palindrome p1 = new PalindromeBruteForce1();
		Palindrome p2 = new PalindromeRecursion();

		String source = "neveroddoreven";

		boolean isPalindrome = p.isPalindrome(source.toCharArray());
		boolean isPalindrome1 = p1.isPalindrome(source.toCharArray());
		boolean isPalindrome2 = p2.isPalindrome(source.toCharArray());

		TestUtil.assertTrue(isPalindrome);
		TestUtil.assertTrue(isPalindrome1);
		TestUtil.assertTrue(isPalindrome2);

		System.out.println(isPalindrome + ":" + isPalindrome1 + ":"
				+ isPalindrome2);

		String sourcea = "neveroddorevena";

		boolean isPalindromer = p.isPalindrome(sourcea.toCharArray());
		boolean isPalindromer1 = p1.isPalindrome(sourcea.toCharArray());
		boolean isPalindromer2 = p1.isPalindrome(sourcea.toCharArray());

		TestUtil.assertFalse(isPalindromer);
		TestUtil.assertFalse(isPalindromer1);
		TestUtil.assertFalse(isPalindromer2);

		System.out.println(isPalindromer + ":" + isPalindromer1 + ":"
				+ isPalindromer2);
	}

	public static void main(String[] args) {
		new PalindromeTest().run();
	}
}
