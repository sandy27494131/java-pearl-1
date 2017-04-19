package com.robert.dsal.advance.queens8;

import java.util.ArrayList;
import java.util.List;

import com.robert.dsal.util.CollectionUtil;

public class QueensCarry implements Queens {
	public int[][] calcPos(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		// TODO to be implemented by the octal or any carry system, the
		// complecity is 8^8 * 2 - 1

		// 2 ^ 11 * 2 = 2 ^ 12 , the recursion is 2^64, therefore, it is more
		// efficient

		return CollectionUtil.convertArray(result);
	}

}