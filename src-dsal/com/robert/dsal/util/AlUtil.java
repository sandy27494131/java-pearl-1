package com.robert.dsal.util;

public class AlUtil {
	public static void swap(int[] seq, int i, int j) {
		int tmp = seq[i];
		seq[i] = seq[j];
		seq[j] = tmp;
	}

	public static void swap(int i, int j) {
		int tmp = i;
		i = j;
		j = tmp;
	}
}
