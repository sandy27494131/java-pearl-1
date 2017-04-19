package com.robert.dsal.math.comb$perm.permutation.full;

import java.util.List;

/**
 * 
 * 插入法和交换位置法
 * 
 * 插入法还能用于求普通排列（n个元素中m个元素的排列，m < n）和组合
 */
public interface FullPermutation {
	List<String> fullPermutation(String s);
}
