package com.robert.dsal.math.comb$perm.combination;

import java.util.Collections;
import java.util.List;

public class CombinationTest {
	public static void main(String[] args) {
		Combination fcByInsert = new CombinationBruteForce();
		Combination fcByArray = new CombinationByArray();
		Combination fcByRecusive = new CombinationByInsert();
		
		List<String> resultsInsert = fcByInsert.combination("abc", 2);
		List<String> resultsArray = fcByArray.combination("abc", 2);
		List<String> resultsRecusive = fcByRecusive.combination("abc", 2);
		
		Collections.sort(resultsInsert);
		Collections.sort(resultsArray);
		Collections.sort(resultsRecusive);
		
		System.out.println(resultsInsert);
		System.out.println(resultsArray);
		System.out.println(resultsRecusive);
	}
}
