package com.robert.dsal.string.palindrome;

/**
 * 
 * O(n)
 * 
 * 时间上需要n/2的堆栈空间，开销大
 * 
 */
public class PalindromeRecursion implements Palindrome {

	private boolean isPalindrome(char[] str, int start, int end) {
		if (start == end)
			return true;

		if (start + 1 == end)
			if (str[start] == str[end])
				return true;
			else
				return false;

		if (str[start] == str[end])
			return isPalindrome(str, start + 1, end - 1);

		return false;
	}

	public boolean isPalindrome(char[] str) {
		return isPalindrome(str, 0, str.length - 1);
	}

}
