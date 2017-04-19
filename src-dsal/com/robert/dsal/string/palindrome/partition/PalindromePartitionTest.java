package com.robert.dsal.string.palindrome.partition;

import java.util.List;

import com.robert.dsal.util.DisplayUtil;

public class PalindromePartitionTest {
	public static void main(String[] args) {
		String s = "aabbaa";

		PalindromePartition pp = new PalindromePartitionDivideConquer();
		char[][][] r = pp.partition(s.toCharArray());
		for (int i = 0; i < r.length; i++) {
			DisplayUtil.printMatrix("Result " + (i + 1), r[i]);
		}

		List<List<String>> r1 = pp.partition(s);
		System.out.println(r1);

	}
}
