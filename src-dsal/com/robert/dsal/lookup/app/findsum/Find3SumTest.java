package com.robert.dsal.lookup.app.findsum;

import java.util.List;

public class Find3SumTest {
	public static void main(String[] args) {
		Find3Sum fs = new Find3SumImpl();

		List<int[]> result = fs.find3Sum(new int[] { 10, 11, 12, 30, 1, 2 }, 33);
		for (int i = 0; i < result.size(); i++) {
			int[] comb = result.get(i);
			System.out.println(comb[0] + "£º" + comb[1] + "£º" + comb[2]);
		}
	}
}
