package com.robert.dsal.advance.minsumdiff;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 现在有1-50个数字，对每个数字取立方，构成一个数组1^3 - 50^3, 现在要把这50个数分成两组，每组25个数字，求每组数组之和相差最小的分法。
 * 
 */

public interface MinDiff {
	class Result {
		int diff = Integer.MAX_VALUE;

		List<Integer> c1 = new ArrayList<Integer>();
		List<Integer> c2 = new ArrayList<Integer>();
	}

	public Result minDiff(int start, int end, int power);
}
