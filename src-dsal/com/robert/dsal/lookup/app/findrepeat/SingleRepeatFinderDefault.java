package com.robert.dsal.lookup.app.findrepeat;

/**
 * 
 * 1-1000放在含有1001个元素的数组中，只有唯一的一个元素值重复，其它均只出现一次。每个数组元素只能访问一次，设计一个算法，将它找出来；
 * 不用辅助存储空间，能否设计一个算法实现？
 * 
 */
public class SingleRepeatFinderDefault implements SingleRepeatFinder {

	public int findSingleRepeat(int[] seq) {
		int sum = seq[0];
		for (int i = 1; i < seq.length; i++)
			sum += seq[i];

		int result = sum - ((seq.length - 1) + 1) * (seq.length - 1) / 2;

		return result;
	}
}
