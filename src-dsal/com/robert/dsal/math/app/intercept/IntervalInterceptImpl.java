package com.robert.dsal.math.app.intercept;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 时间复杂度：O(n) 空间复杂度: O(n), n是区间范围的大小，适合区间比较多，但是范围比较小的
 * 
 * 对第一个区间做位图，第二个区间如果与之有交集，则对位图赋值，最后打印所有的区间。
 * 
 */
public class IntervalInterceptImpl implements IntervalIntercept {
	public List<Interval> intercept(Interval i1, List<Interval> c2) {
		if (i1 == null || c2 == null || c2.isEmpty())
			return null;

		return doIntercept(i1, c2);
	}

	private List<Interval> doIntercept(Interval i1, List<Interval> c2) {
		// 按照第一个区间进行初始化标志区间
		int rleft = i1.x;
		int rsize = i1.y - i1.x + 1;

		// 标志区间全部自动初始化为false
		boolean[] frange = new boolean[rsize];

		// 对于第二个集合的每一个区间，如果和第一个区间重合，则设置为true
		for (Interval interval : c2) {
			mark(interval, i1, frange);
		}

		// 计算所有的true构成的区间集合
		return calcIntervals(rleft, frange);

	}

	private void mark(Interval interval, Interval range, boolean[] frange) {
		// 找到重合，然后设置为true
		for (int i = (interval.x > range.x ? interval.x : range.x); i <= (interval.y < range.y ? interval.y
				: range.y); i++) {
			int diff = i - range.x;
			frange[diff] = true;
		}
	}

	private List<Interval> calcIntervals(int left, boolean[] frange) {
		List<Interval> result = new ArrayList<Interval>();

		// 区间标志
		int start = -1;
		for (int i = 0; i < frange.length; i++) {
			// 区间开始
			if (start == -1 && frange[i]) {
				start = i;
			}

			// 区间结束
			if (start != -1 && !frange[i]) {
				result.add(new Interval(start + left, i - 1 + left));
				start = -1;
			}
		}

		// 最后一个区间
		if (start != -1)
			result.add(new Interval(start + left, frange.length - 1 + left));

		return result;
	}
}
