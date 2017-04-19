package com.robert.dsal.math.app.intercept;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * O(n^2), n是区间的个数，适合区间比较少的，但是区间范围比较大的
 * 
 * 先把第一个区间和后面所有区间交集，然后，去掉无效区间，然后二维遍历，找到能够向前合并的所有元素，并且记录向前合并的索引，然后依次合并，最后取得并集。
 * 
 */
public class IntervalInterceptImpl1 implements IntervalIntercept {

	public List<Interval> intercept(Interval i1, List<Interval> c2) {
		// 合并标志初始化
		int[] flag = new int[c2.size()];

		for (int i = 0; i < c2.size(); i++) {
			// 用第一个区间和第二个集合中的每一个区间两两交集
			Interval it = c2.get(i);
			// 取交集
			it.x = Math.max(i1.x, it.x);
			it.y = Math.min(i1.y, it.y);

			// 如果交集不包含有效元素，则设置为-2，否则包含有效元素则设置-1
			if (it.x > it.y)
				flag[i] = -2;
			else
				flag[i] = -1;
		}

		// 对取得所有的交集结果取并集
		return merge(c2, flag);
	}

	private List<Interval> merge(List<Interval> c2, int[] flag) {
		for (int i = 0; i < c2.size() - 1; i++) {
			Interval it = c2.get(i);

			// 非有效区间
			if (flag[i] == -2)
				continue;

			for (int j = i + 1; j < c2.size(); j++) {
				Interval it1 = c2.get(j);

				// 非有效区间
				if (flag[j] == -2)
					continue;

				// 如果区间有交集，则记录要合并的目标元素，从后往前，如果flag>=0, 则表示当前元素要合并到flag[i]所在的区间
				if ((it.x >= it1.x && it.x <= it1.y)
						|| (it.y >= it1.x && it.y <= it1.y))
					flag[j] = i;
			}
		}

		// 从最后一个元素到第一个元素进行合并
		for (int i = flag.length - 1; i > 0; i--) {
			if (flag[i] != -2 && flag[i] != -1) {
				Interval c = c2.get(i);
				Interval t = c2.get(flag[i]);

				// 前面一步保证有交集，所以取并集
				t.x = Math.min(c.x, t.x);
				t.y = Math.max(c.y, t.y);

				// 合并到前面集合后，就标志-2，是个无效区间了
				flag[i] = -2;
			}

		}

		List<Interval> result = new ArrayList<Interval>();

		for (int i = 0; i < flag.length; i++) {
			// 打印所有有效区间
			if (flag[i] != -2)
				result.add(c2.get(i));
		}

		return result;
	}

}
