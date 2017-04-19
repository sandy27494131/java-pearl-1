package com.robert.dsal.math.app.intercept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * 时间复杂度O(nlog2n), n是区间的个数，因为需要排序
 * 
 */
public class IntervalInterceptImpl2 implements IntervalIntercept {

	public List<Interval> intercept(Interval i1, List<Interval> c2) {
		// 相互取交集
		List<Interval> inter = doIntercept(i1, c2);

		// 按照第一个元素排序
		Collections.sort(inter, new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				return o1.x - o2.x;
			}
		});

		List<Interval> result = new ArrayList<Interval>();

		for (int i = 0; i < c2.size() - 1; i++) {
			Interval it = c2.get(i);
			Interval it1 = c2.get(i + 1);

			// 相邻元素合并
			if (it.y >= it1.x) {
				it1.x = Math.min(it.x, it1.x);
				it1.y = Math.max(it.y, it1.y);
			} else {
				result.add(it);
			}
		}

		// 最后一个元素一定在结果集里面
		result.add(c2.get(c2.size() - 1));

		return result;
	}

	private List<Interval> doIntercept(Interval i1, List<Interval> c2) {
		for (int i = c2.size() - 1; i >= 0; i--) {
			Interval it = c2.get(i);
			it.x = Math.max(i1.x, it.x);
			it.y = Math.min(i1.y, it.y);

			if (it.x > it.y)
				c2.remove(i);
		}

		return c2;
	}

}
