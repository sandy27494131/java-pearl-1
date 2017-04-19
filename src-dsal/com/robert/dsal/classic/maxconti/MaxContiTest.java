package com.robert.dsal.classic.maxconti;

public class MaxContiTest {
	public static void main(String[] args) {
		MaxConti mc = new MaxContiImpl();

		int num = mc.maxConti("00222222111".toCharArray());

		System.out.println(num);
	}
}
