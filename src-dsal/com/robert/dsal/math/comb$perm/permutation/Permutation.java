package com.robert.dsal.math.comb$perm.permutation;

import java.util.List;

public interface Permutation {
	public List<String> permutation(String s, int count);
	
	public List<int[]> permutation(int[] nums, int count);
}
