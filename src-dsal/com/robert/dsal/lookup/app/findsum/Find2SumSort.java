package com.robert.dsal.lookup.app.findsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 排序后，前后双指针推进，时间复杂度O(nlog2n), 主要用于排序
 * 
 */
public class Find2SumSort implements Find2Sum {
	public List<int[]> find2Sum(int[] nums, int sum) {
		Arrays.sort(nums);

		int i = 0;
		int j = nums.length - 1;

		List<int[]> result = new ArrayList<int[]>();
		while (i < j) {
			if (nums[i] + nums[j] == sum)
				result.add(new int[] { nums[i++], nums[j++] });
			else if (nums[i] + nums[j] > sum)
				j--;
			else
				i++;
		}

		return result;
	}
}
