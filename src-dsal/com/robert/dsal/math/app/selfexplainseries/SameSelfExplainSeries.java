package com.robert.dsal.math.app.selfexplainseries;

import java.util.List;

public class SameSelfExplainSeries implements SameSeries {

	/**
	 * 方法1：当前方法，对两个元素边合并边找到最小的，看看最小的能不能到达次小的
	 * 方法2：还有一种方法，因为两个序列都是有序的，可以进行一次归并，然后求相邻两个元素是否前一个能到达后一个
	 */
	public boolean isSameSeries(List<Element> s1, List<Element> s2) {

		if (s1 == null || s2 == null)
			return true;

		// 假设s1, s2都是排序的

		// 假设每个集合是在各自的同一个序列
		if (s1.size() == 0 || s2.size() == 0)
			return true;

		Element e1 = s1.get(0);
		Element e2 = s2.get(0);

		// 假设两个序列元素不重复，如果重复则不是同一个序列了
		if (e1.compareTo(e2) == 0)
			return false;

		// 找到两个头元素最小的一个
		Element ecurr = null;
		int i = 0, j = 0;
		if (e1.compareTo(e2) > 0) {
			ecurr = e2;
			j++;
		} else {
			ecurr = e1;
			i++;
		}

		Element emin = null;
		while (i < s1.size() && j < s2.size()) {
			e1 = s1.get(i);
			e2 = s2.get(j);

			// 假设两个序列元素不重复，如果重复则不是同一个序列了
			if (e1.compareTo(e2) == 0)
				return false;

			// 找到两个头元素中最小的一个
			if (e1.compareTo(e2) > 0) {
				emin = e2;
				j++;
			} else {
				emin = e1;
				i++;
			}

			// 看看从上一个最小的能不能到这一个最小的
			if (!reachable(ecurr, emin))
				return false;

			ecurr = emin;

		}

		if (i < s1.size()) {
			if (reachable(ecurr, s1.get(i)))
				return true;
		}

		if (j < s2.size()) {
			if (reachable(ecurr, s2.get(j)))
				return true;
		}

		return false;
	}

	private boolean reachable(Element ecurr, Element emin) {
		while (ecurr.compareTo(emin) < 0) {
			ecurr = ecurr.next();
		}

		if (ecurr.compareTo(emin) == 0)
			return true;

		return false;
	}
}
