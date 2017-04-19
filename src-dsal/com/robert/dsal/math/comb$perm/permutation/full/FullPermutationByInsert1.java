package com.robert.dsal.math.comb$perm.permutation.full;

import java.util.LinkedList;
import java.util.List;

/**
 * 插入法 - 递归结束条件是剩下一个字符的排列就是它自己，只有一个，然后把第二个字符插入到这个字符的左右，这种解法是每次递归都有大量的临时空间，不推荐使用，
 * 请看FullPermutationByInsert.java， 此实现不被推荐
 * 
 * 第一种思路：求字符串a{n}的全排列，可以分解为求a{n - 1}的全排列，对于a{n - 1}的每一个全排列结果，只要将a[n]插入到a{n -
 * 1}序列的n个位置中
 * ，即可得到a{n}的全排列结果。例如：求abc的全排列，可以先求ab的全排列，再将c插入到第0,1,2位即可得到abc的全排列，而对于ab的全排列
 * ，可以先求a的全排列
 * ，再将b插入到第0,1位即可得到ab全排列结果，因为a是单个字符，它的全排列结果只有一个：a，所以递归开始返回，层层向上，得到abc的全排列的解
 * 。总结：这是基于插入操作的算法！
 * 
 */
public class FullPermutationByInsert1 implements FullPermutation {

	public List<String> fullPermutation(String s) {
		return fullPermutation(s, 0, s.length());
	}

	public List<String> fullPermutation(String s, int start, int end) {
		List<String> results = new LinkedList<String>();

		// 如果就剩下一个字符了，那全排列就只有一种了
		if (start == end - 1) {
			results.add(s.substring(start, end).toString());
			return results;
		}

		// 留下开始字符，对于后面的所有字符求全排列，对于每个排列的每个位置插入当前字符成为新的排列
		List<String> resultsSub = fullPermutation(s, start + 1, end);

		for (String sSub : resultsSub) {
			StringBuffer sbSub = new StringBuffer(sSub);
			for (int i = 0; i <= sbSub.length(); i++) {
				sbSub.insert(i, s.charAt(start));
				results.add(sbSub.toString());
				sbSub.deleteCharAt(i);
			}
		}

		// 缺点是没法去重

		return results;
	}

}
