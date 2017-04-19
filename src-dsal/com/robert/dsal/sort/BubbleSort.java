package com.robert.dsal.sort;

public class BubbleSort implements Sort {

	public void sort(int[] seq) {
		for (int i = seq.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (seq[j] > seq[j + 1])
					swap(seq, j, j + 1);
			}
		}
	}

	private void swap(int[] seq, int i, int j) {
		int t = seq[i];
		seq[i] = seq[j];
		seq[j] = t;
	}

}
