package com.robert.dsal.sort;

public class SelectionSort implements Sort {

	public void sort(int[] seq) {
		for (int i = 0; i < seq.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < seq.length; j++) {
				if (seq[j] < seq[min])
					min = j;
			}

			if (min != i)
				swap(seq, i, min);
		}
	}

	private void swap(int[] seq, int i, int j) {
		int t = seq[i];
		seq[i] = seq[j];
		seq[j] = t;
	}

}
