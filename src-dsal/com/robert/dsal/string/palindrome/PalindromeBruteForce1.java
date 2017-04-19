package com.robert.dsal.string.palindrome;

/**
 * 
 * O(n)
 * 
 */
public class PalindromeBruteForce1 implements Palindrome {
	public boolean isPalindrome(char[] str) {
		int i = 0, j = str.length - 1;

		while (i < j) {
			if (str[i++] != str[j--])
				return false;
		}

		return true;
	}
}
