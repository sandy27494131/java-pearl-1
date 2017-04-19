package com.robert.dsal.lookup.classic;

/**
 * 算法名称：
 * 
 * 顺序查找
 * 
 * 算法描述：
 * 
 * 对于数组中的元素从前往后逐个向后对比，直到找到相等元素，或者到达数组尾部。
 * 
 * 时间复杂度：
 * 
 * O(N)
 */
public class SequenceLookup extends AbstractLookup {

	@Override
	public int lookup(int t) {
		for (int i = 0; i < seq.length; i++)
			if (seq[i] == t)
				return i;
		return -1;
	}

}
