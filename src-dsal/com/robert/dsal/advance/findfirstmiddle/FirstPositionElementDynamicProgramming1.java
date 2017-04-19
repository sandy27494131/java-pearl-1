package com.robert.dsal.advance.findfirstmiddle;

/**
 * 
 * 这个实现和FirstPositionElementDynamicProgramming是一样的，但是程序是自文档的，容易理解
 * 
 */
public class FirstPositionElementDynamicProgramming1 implements
		FirstPositionElementFinder {

	public int findFirstPositionElement(int[] seq) {
		// 第一个元素初始化为标杆元素和最大元素
		int flag = 0;
		int max = seq[0];

		// 循环所有其他元素
		for (int i = 1; i < seq.length; i++) {
			if (flag != -1) {
				// 有标杆元素
				if (seq[i] >= seq[flag])
					// 当前元素大于等于标杆元素
					max = seq[i];
				// 不需要改变标杆
				else
					// 当前元素小于标杆元素，则作废所有前面元素
					flag = -1;
				// 不需要改变最大值

			} else {
				// 无标杆元素，而且出现一个比以前最大值还大的元素，重新初始化为标杆元素
				if (seq[i] >= max) {
					flag = i;
					max = seq[i];
				}
			}
		}

		return flag != -1 ? seq[flag] : -1;

	}
}
