package com.robert.dsal.math.comb$perm.permutation.full;

import java.util.LinkedList;
import java.util.List;

/**
 * 这种方法每次递归都先求n-1的排列，递归结束条件仍然是剩下一个字符的排列就是它自己，
 * 然后把当前字符排列在n-1的排列的前面，需要太多的空间，不推荐使用，请看FullPermutationByExchange.java， 此实现不被推荐
 * 
 * 
 * 
 * 第二种思路：求字符串a{n}的全排列，首先将a[0]和a[n]调换，然后求前面长度为n -
 * 1的字符串的全排列，完成后，将a{n}序列恢复原样，再将a[1]和a[n]调换，以此类推，直到a[n]和a[n]调换，去求前面长度为n -
 * 1的字符串的全排列
 * ，至此所有的结果均已得到。例如：求abc的全排列，可以先将a和c调换并固定a，即cba，此时求cb的全排列，将c和b调换并固定c，即bca
 * ，由于b是一个单独的字符串
 * ，此次递归到底层，输出一个结果bca，返回，回归原样为cba，此时下一个需要处理的值是b，即b和b调换【即a[i]和a[n]调换，
 * 但此时i恰好等于n】，得到cba
 * ，由于c是单独的字符串，递归到底层，输出一个结果cba，返回，回归原样为cba，因为i已经等于n，则继续返回，回归原样abc
 * ，此时a已经处理完毕，再将b放在最末尾固定
 * ，进行处理，以此类推，得到所有全排列结果。这个思路有一个好处，即付出少量的空间代价即可达到去重处理的要求，对于重复的字符
 * ，程序只要发现这个字符曾经在i位置固定过
 * ，就不再进行此轮处理，因为对于任意字符m，在i位置固定过，则可知m在i位置的前提下整个字符串的全排列结果已经得到，那么相同的字符再一次固定在相同的位置
 * ，处理的全排列必然导致结果重复。总结：这是基于调换操作的算法！
 * 
 */
public class FullPermutationByExchange1 implements FullPermutation {

	public List<String> fullPermutation(String s) {
		// 左闭右开
		return fullPermutation(new StringBuffer(s), 0, s.length());
	}

	public List<String> fullPermutation(StringBuffer sb, int start, int end) {
		List<String> results = new LinkedList<String>();

		if (start + 1 == end) {
			results.add(sb.substring(start, end));
			return results;
		}

		for (int i = start; i < end; i++) {
			swap(sb, start, i);

			List<String> resultsSub = fullPermutation(sb, start + 1, end);

			for (String sSub : resultsSub) {
				results.add(sb.charAt(start) + sSub);
			}

			swap(sb, start, i);
		}

		return results;
	}

	private void swap(StringBuffer sb, int i1, int i2) {
		char c = sb.charAt(i1);
		sb.setCharAt(i1, sb.charAt(i2));
		sb.setCharAt(i2, c);
	}

}
