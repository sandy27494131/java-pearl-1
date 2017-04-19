package com.robert.dsal.lookup.app.findsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 时间复杂度为O(n^2)。
 * 
 * 如果数组已排序，利用两个数的解法，双指针遍历法，可以在O(n)的时间内找到两个数之和等于一个給定的数。
 * 
 * 我们假设找到的三个数ai,aj,ak有ai<=aj<=ak，要让ai+aj+ak=sum，也就是要ai+aj=sum-ak，设subsum=sum-ak，
 * 很容易发现subsum的值只有n个
 * ，而确定ai+aj=subsum中的ai,aj只需要O(n)的时间，所以总的时间复杂度为O(nlogn+n*n)=O(n^2)
 * 
 * 降解：三个数的和减去每一个元素，一共n种情况，然后在剩余元素中找到另外两个元素的和O(n), 所以是O(nlog2n)。
 * 
 * 
 */
public class Find3SumImpl implements Find3Sum {
	public List<int[]> find3Sum(int[] nums, int sum) {
		Find2Sum find2Sum = new Find2SumHash();

		Set<String> filted = new HashSet<String>();

		List<int[]> result = new ArrayList<int[]>();
		for (int i = 0; i < nums.length; i++) {
			int t = nums[i];
			nums[i] = Integer.MIN_VALUE;
			List<int[]> coll2 = find2Sum.find2Sum(nums, sum - t);
			nums[i] = t;

			for (int j = 0; j < coll2.size(); j++) {
				int[] array2 = coll2.get(j);

				int[] array3 = new int[] { array2[0], array2[1], t };
				Arrays.sort(array3);

				String key = array3[0] + ":" + array3[1] + ":" + array3[2];

				// 去重
				if (!filted.contains(key))
					result.add(array3);

				filted.add(key);
			}
		}
		return result;
	}
}
