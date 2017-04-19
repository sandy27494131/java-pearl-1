package com.robert.dsal.math.comb$perm.permutation.full;

import java.util.Collections;
import java.util.List;

public class FullPermutationTest {
	public static void main(String[] args) {

		FullPermutation fpByInsert = new FullPermutationByInsert();
		FullPermutation fpByExchange = new FullPermutationByExchange();

		List<String> resultsByInsert = fpByInsert.fullPermutation("abc");
		List<String> resultsByExchange = fpByExchange.fullPermutation("abc");

		Collections.sort(resultsByInsert);
		Collections.sort(resultsByExchange);

		System.out.println(resultsByInsert);
		System.out.println(resultsByExchange);
	}
}
