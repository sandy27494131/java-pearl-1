package com.robert.dsal.string.palindrome.partition;

import java.util.List;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", return [["aa", "b"], ["a","a","b"]}
 */
public interface PalindromePartition {
	char[][][] partition(char[] s);

	List<List<String>> partition(String s);
}
