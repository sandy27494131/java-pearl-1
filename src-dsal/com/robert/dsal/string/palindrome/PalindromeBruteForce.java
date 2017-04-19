package com.robert.dsal.string.palindrome;

/*
 * O(n) 
 */
public class PalindromeBruteForce implements Palindrome {
	public boolean isPalindrome(char[] str) {

		for (int i = 0; i < str.length; i++) {
			if (str[i] != str[str.length - 1 - i])
				return false;
		}

		return true;
	}
}
