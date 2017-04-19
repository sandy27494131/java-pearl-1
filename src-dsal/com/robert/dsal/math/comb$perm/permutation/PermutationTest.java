package com.robert.dsal.math.comb$perm.permutation;

import java.util.List;

public class PermutationTest {
	public static void main(String[] args) {
		Permutation pByInsert = new PermutationByInsert();

		List<String> results = pByInsert.permutation("abc", 2);

		System.out.println(results);

		List<int[]> results2 = pByInsert.permutation(new int[] { 0, 1, 2 }, 2);
		for (int[] solution : results2) {
			System.out.print("(");
			for (int i = 0; i < solution.length; i++) {
				System.out.print((char) ('a' + solution[i])
						+ (i == solution.length - 1 ? "" : ","));
			}
			System.out.print(") ");
		}

	}
}
