package com.robert.dsal.math.app.intercept;

import java.util.ArrayList;
import java.util.List;

public class IntervalInterceptTest {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	private static void test1() {
		IntervalIntercept ii = new IntervalInterceptImpl();

		Interval i1 = new Interval(6, 27);

		Interval i2 = new Interval(5, 7);
		Interval i3 = new Interval(21, 34);
		Interval i4 = new Interval(13, 25);
		List<Interval> c2 = new ArrayList<Interval>();
		c2.add(i2);
		c2.add(i3);
		c2.add(i4);

		List<Interval> result = ii.intercept(i1, c2);
		System.out.println(result);
	}

	private static void test2() {
		IntervalIntercept ii = new IntervalInterceptImpl1();

		Interval i1 = new Interval(6, 27);

		Interval i2 = new Interval(5, 7);
		Interval i3 = new Interval(21, 34);
		Interval i4 = new Interval(13, 25);
		List<Interval> c2 = new ArrayList<Interval>();
		c2.add(i2);
		c2.add(i3);
		c2.add(i4);

		List<Interval> result = ii.intercept(i1, c2);
		System.out.println(result);
	}

	private static void test3() {
		IntervalIntercept ii = new IntervalInterceptImpl2();

		Interval i1 = new Interval(6, 27);

		Interval i2 = new Interval(5, 7);
		Interval i3 = new Interval(21, 34);
		Interval i4 = new Interval(13, 25);
		List<Interval> c2 = new ArrayList<Interval>();
		c2.add(i2);
		c2.add(i3);
		c2.add(i4);

		List<Interval> result = ii.intercept(i1, c2);
		System.out.println(result);
	}
}
