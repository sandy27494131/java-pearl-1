package com.robert.dsal.math.comb$perm.permutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 递归次数： 目标排列元素的个数
 * 每次工作：对于所有元素中拿出任意一个元素，放在其中一个位置上，下次递归遍历所有剩下的元素，放在下一个位置上，因此可能产生ab,
 * 但是下次产生ba，因此是排列
 * 
 */
public class PermutationByInsert implements Permutation {
	public List<String> permutation(String s, int count) {
		List<String> results = new LinkedList<String>();

		StringBuffer result = new StringBuffer(count);

		permutation(results, result, new StringBuffer(s), count, 0);

		return results;
	}

	private void permutation(List<String> results, StringBuffer buffer,
			StringBuffer currentBuffer, int count, int current) {
		if (current == count) {
			results.add(buffer.toString());
			return;
		}

		for (int i = 0; i < currentBuffer.length(); i++) {
			char c = currentBuffer.charAt(i);

			// 每次从所有字符中拿出来一个放到目标的当前位置上，那么下一次递归就是取剩下的放在下一个位置，那么，顺序是起作用的
			// 例如，abc，第一次取了a，然后取b，是ab， 下次取了b，然后还可以回来取a，就是ba，因此是排列
			// 这个组合的求法不一样，组合的求法是每次只能取右边的元素，因此就是组合，筛选掉了重复元素，看CombinationByRecursive.java
			currentBuffer.deleteCharAt(i);
			buffer.insert(current, c);

			permutation(results, buffer, currentBuffer, count, current + 1);

			buffer.deleteCharAt(current);
			currentBuffer.insert(i, c);
		}

	}

	public List<int[]> permutation(int[] nums, int count) {
		List<int[]> results = new ArrayList<int[]>();
		int[] buffer = new int[count];
		
		boolean[] mask = new boolean[nums.length];
		for (int i = 0; i < mask.length; i++) {
			mask[i] = true;
		}

		permutation(results, buffer, nums, mask, count, 0);

		return results;
	}

	private void permutation(List<int[]> results, int[] buffer, int[] nums,
			boolean[] mask, int count, int current) {
		if (current == count) {
			results.add(buffer.clone());
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!mask[i])
				continue;

			buffer[current] = nums[i];
			mask[i] = false;
			
			permutation(results, buffer, nums, mask, count, current + 1);
			mask[i] = true;
		}
	}

}
