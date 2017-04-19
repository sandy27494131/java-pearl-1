package com.robert.dsal.advance.minsumdiff;

import com.robert.dsal.advance.minsumdiff.MinDiff.Result;

public class MinDiffTest {
	public static void main(String[] args) {
		testDoubleWaySearch();

		// testBruteForce();
		// testSearch();
	}

	private static void testDoubleWaySearch() {
		MinDiff minDiff = new MinDiffDoubleWaySearch();

		Result result = minDiff.minDiff(1, 50, 3);
		System.out.println("最小差值: " + result.diff);
		System.out.println(result.c1);
		System.out.println(result.c2);
	}

	private static void testSearch() {
		MinDiff minDiff = new MinDiffSearch();

		Result result = minDiff.minDiff(1, 50, 3);
		System.out.println("最小差值: " + result.diff);
		System.out.println(result.c1);
		System.out.println(result.c2);
	}

	private static void testBruteForce() {
		MinDiff minDiff = new MinDiffBruteForce();

		System.out.println("");
		System.out.println("BruteForce");
		for (int i = 2; i < 28; i += 2) {
			Result result = minDiff.minDiff(1, i, 3);
			System.out.print(i + "->" + result.diff + "   ");

		}
	}
}
