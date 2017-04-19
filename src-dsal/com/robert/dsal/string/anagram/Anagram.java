package com.robert.dsal.string.anagram;

/**
 * 
 * Anapali - Problem description A string is a palindrome if it has exactly the
 * same sequence of characters when read left-to-right as it has when read
 * right-to-left. For example, the following strings are palindromes:
 * 
 * "kayak", "codilitytilidoc", "neveroddoreven". A string A is an anagram of a
 * string B if A can be obtained from B by rearranging the characters. For
 * example, in each of the following pairs one string is an anagram of the
 * other:
 * 
 * "mary" and "army", "rocketboys" and "octobersky", "codility" and "codility".
 * Write a function that, given a non-empty string S consisting of N characters,
 * returns 1 if S is an anagram of some palindrome and returns 0 otherwise.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..100,000]; string S consists only of
 * English lower-case letters (a-z). For example, given S = "dooernedeevrvn",
 * the function should return 1, because "dooernedeevrvn" is an anagram of the
 * palindrome neveroddoreven. Given S = "aabcba", the function should return 0.
 * 
 * 
 * Solution: 
 * 
 * 1. BruteForce: Recursion for permutation and check the palindrome.O(n!*n)  
 * 2. BitSet: Only one or zero single char, others are duplicated chars. O(n) 
 * 3. BitOper: Only one or zero single char, others are duplicated chars. O(n)
 * 4. Sort: Sort and then compute the number of single chars. O(nlog2n)
 */
public interface Anagram {
	public boolean isAnagramPalindrome(char[] str);
}
