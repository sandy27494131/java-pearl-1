package com.robert.dsal.sort;

public class RadixSort implements Sort {

	// 从个位到百位一直往上，每次确定一位的顺序，如果高位没有改变顺序则仍然保持这个顺序，否则按照高位算

	// 高位后处理，所以有优先级

	// 相对于BucketSort.java来说，每次分桶后，数据还是在一个集合中，不用递归，非递归算法

	public void sortRadix(int[] seq, int d) {
		int n = 1;
		int m = 1;
		int[][] temp = new int[10][seq.length];
		int[] order = new int[10];
		while (m <= d) {
			for (int i = 0; i < seq.length; i++) {
				int lsd = ((seq[i] / n) % 10);
				temp[lsd][order[lsd]] = seq[i];
				order[lsd]++;
			}
			int k = 0;
			for (int i = 0; i < 10; i++) {
				if (order[i] != 0)
					for (int j = 0; j < order[i]; j++) {
						seq[k] = temp[i][j];
						k++;
					}
				order[i] = 0;
			}
			k = 0;

			n *= 10;
			m++;
		}
	}

	public void sort(int seq[]) {
		// 只排序10位十进制数字
		sortRadix(seq, 10);
	}
}
