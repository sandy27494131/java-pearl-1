package com.robert.dsal.math.app.selfexplainseries;

import java.util.List;

/**
 * 
 * 数列1 ， 1 1， 2 1， 1 2 1 1 ，1 2 3 1，1 2 1 3 2 1，3 1 2 2 1 3后一个是前一个解释，如 1 1 表示前面是1 个1。给定两个数列，编程判断它们是否属于同一个系列?
 *
 */
public interface SameSeries {
	public boolean isSameSeries(List<Element> s1, List<Element> l2);
}
