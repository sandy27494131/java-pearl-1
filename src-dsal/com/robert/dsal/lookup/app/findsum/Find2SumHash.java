package com.robert.dsal.lookup.app.findsum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 使用Hash, 对每一个数，如果 sum - curr也在hash里，就是目标，然后从hash删除这两个数字
 * 
 * 时间复杂度O(n)， 空间复杂度O(n)
 * 
 */
public class Find2SumHash implements Find2Sum {
	public List<int[]> find2Sum(int[] nums, int sum) {
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			hash.put(new Integer(nums[i]), 1);
		}

		List<int[]> result = new ArrayList<int[]>();
		for (int i = 0; i < nums.length; i++) {
			int complement = sum - nums[i];
			if (hash.get(new Integer(complement)) != null) {
				result.add(new int[] { nums[i], complement });

				hash.remove(new Integer(nums[i]));
				hash.remove(new Integer(sum - complement));
			}
		}
		return result;
	}
}
