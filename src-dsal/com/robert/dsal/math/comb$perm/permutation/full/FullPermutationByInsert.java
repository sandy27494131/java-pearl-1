package com.robert.dsal.math.comb$perm.permutation.full;

import java.util.LinkedList;
import java.util.List;

/**
 * 插入法
 * 
 * 1. 循环0-n-1, 当前字符进入缓冲区
 * 2. 如果缓冲区有k个字符，那么需要尝试插入k+1个位置，然后继续递归剩下的字符，直到最后一个字符n-1插入了，打印所有的缓冲区内容
 * 3. 这是递归加循环，结束条件是递归到了最后一个字符
 * 
 * 
 */
public class FullPermutationByInsert implements FullPermutation {

	public List<String> fullPermutation(String s) {
		List<String> listResults = new LinkedList<String>();
		StringBuffer sbResult = new StringBuffer();

		fullPermutation(listResults, sbResult, s, 0);

		return listResults;

	}

	private void fullPermutation(List<String> listResults,
			StringBuffer sbResult, String s, int current) {
		if (current == s.length()) {
			listResults.add(sbResult.toString());
			return;
		}

		char c = s.charAt(current);
		for (int i = 0; i <= current; i++) {
			sbResult.insert(i, c);

			fullPermutation(listResults, sbResult, s, current + 1);

			sbResult.deleteCharAt(i);
		}

	}

}
