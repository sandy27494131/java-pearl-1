package com.robert.dsal.sort;

public class InsertionSort implements Sort {

	public void sort(int[] seq) {
		for (int i = 1; i < seq.length; i++) {
			int t = seq[i];

			int j = i - 1;
			while (j >= 0 && t < seq[j]) {
				seq[j + 1] = seq[j];
				j--;
			}
			seq[j + 1] = t;
		}
	}

}
