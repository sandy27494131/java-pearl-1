package com.robert.dsal.math.comb$perm.combination;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 对于每个字符，当前字符存在则递归，不存在再递归, 结束条件是到最后一个字符或者缓冲区到达期待数量
 * 
 * 对于集合中的每个字符只有2种情况，存在或者不存在，递归深度为字符串长度
 * 
 * 算法复杂度为指数级别，O(2^n)，效率很差
 * 
 */
public class CombinationBruteForce implements Combination {
	public List<String> combination(String s, int count) {
		List<String> results = new LinkedList<String>();
		StringBuffer result = new StringBuffer();

		combination(results, result, s, 0, count);

		return results;
	}

	private void combination(List<String> results, StringBuffer result,
			String s, int current, int count) {
		if (result.length() == count) {
			results.add(result.toString());
			return;
		}

		if (current == s.length())
			return;

		char c = s.charAt(current);

		// 当前字符存在
		result.insert(0, c);
		combination(results, result, s, current + 1, count);

		// 当前字符不存在
		result.deleteCharAt(0);
		combination(results, result, s, current + 1, count);
	}
}
