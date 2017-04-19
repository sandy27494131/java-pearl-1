package com.robert.dsal.advance.bag01;

public class BagProblemTest {
	public static void main(String[] args) {
		Object[] objects = new Object[4];
		objects[0] = new Object(0, 3, 8);
		objects[1] = new Object(1, 10, 5);
		objects[2] = new Object(2, 2, 3);
		objects[3] = new Object(3, 8, 20);

		BagProblem bpBruteForce = new BagProblemBruteForce();
		BagProblem bpBackTrace = new BagProblemBackTrace();
		BagProblem bpBranchBound = new BagProblemBranchBound();
		BagProblem bpDynamicProgramming = new BagProblemDynamicProgramming();
		BagSolution bestBruteForce = bpBruteForce.bestSolution(objects, 13);
		BagSolution bestBackTrace = bpBackTrace.bestSolution(objects.clone(), 13);
		BagSolution bestBranchBound = bpBranchBound.bestSolution(objects.clone(), 13);
		BagSolution bestDynamicProgramming = bpDynamicProgramming.bestSolution(objects.clone(), 13);

		if (bestBruteForce.isValidSolution())
			System.out.println(bestBruteForce);
		else
			System.out.println("No Solution.");

		if (bestBackTrace.isValidSolution())
			System.out.println(bestBackTrace);
		else
			System.out.println("No Solution.");

		if (bestBranchBound.isValidSolution())
			System.out.println(bestBranchBound);
		else
			System.out.println("No Solution.");

		if (bestDynamicProgramming.isValidSolution())
			System.out.println(bestDynamicProgramming);
		else
			System.out.println("No Solution.");

	}
}
