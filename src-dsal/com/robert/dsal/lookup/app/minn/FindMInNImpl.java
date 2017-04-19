package com.robert.dsal.lookup.app.minn;

import java.util.Arrays;

/**
 * 
 * 不能有额外空间，那就得在原数组上做文章，使用符号位表示状态，并假设数组元素>=0, 题目要求也是1 .. N,注意从1开始，需要索引边缘转换
 * 
 * 如果能有额外的空间可以用位图和hash等，位图最多用n + m那么长
 * 
 */

public class FindMInNImpl implements FindMInN {
	public int[] findMInN(int[] x) {
		// 未知结果
		int[] result = new int[x.length];
		int count = 0;

		// 遍历一次O(N + M)
		for (int i = 0; i < x.length; i++) {
			// 当前元素的值是映射目标元素的索引
			int v = x[i];
			// 这里面的值可能已经被设置成负值，所以，负号用来记录其他元素的出现情况，所以，抛弃负号
			if (v < 0)
				v = -v;
			// 值从1开始，所以，要减1，向0对其
			v--;

			// 如果某个位置的值已经是负数了，那这个值就存在了，就输出
			if (x[v] < 0)
				result[count++] = v + 1;

			// toggle这个位置，这样出现3次的元素只输出一次
			x[v] = -x[v];

			// 下面这段是容易理解的写法，代码功能相同
			/**
			 * 
			 * if (x[v] >= 0) x[v] = -x[v]; else { x[v] = -x[v]; result[count++]
			 * = x[v]; }
			 * 
			 */

		}

		return Arrays.copyOfRange(result, 0, count);
	}
}
