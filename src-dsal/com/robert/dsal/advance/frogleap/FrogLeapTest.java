package com.robert.dsal.advance.frogleap;

public class FrogLeapTest {

	public static void main(String[] args) {
		FrogLeap fl = new FrogLeapBacktrace();
		FrogLeap f2 = new FrogLeapBranchbound();
		FrogLeap f3 = new FrogLeapDynamicProgramming();

		int[] result1 = fl.fropLeap(new int[] { 3, 2, 1, 1, 1, 5, 10 });
		int[] result2 = f2.fropLeap(new int[] { 3, 2, 1, 1, 1, 5, 10 });
		int[] result3 = f3.fropLeap(new int[] { 3, 2, 1, 1, 1, 5, 10 });

		for (int i : result1)
			System.out.println(i + ":");

		for (int i : result2)
			System.out.println(i + ":");

		for (int i : result3)
			System.out.println(i + ":");

	}

}
