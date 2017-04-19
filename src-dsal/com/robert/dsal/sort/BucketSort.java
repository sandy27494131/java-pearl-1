package com.robert.dsal.sort;

import com.robert.dsal.util.AlUtil;

/**
 * 
 * 按照从左到右的每一个数字排序，每次排序分为三组，一组小的，一组相等的，还有一组大的，对于相等的则按照下一个数字排序，对于大小的则继续递归
 * 
 * 相对于RadixSort.java来说，这种方法是从左到右，分桶后，对于每桶必须递归下去
 * 
 */

public class BucketSort implements Sort {
	private boolean equal(int left, int right, int d) {
		int datal = left / d % 10;
		int datar = right / d % 10;

		return datal == datar;
	}

	private boolean less(int left, int right, int d) {
		int datal = left / d % 10;
		int datar = right / d % 10;

		return datal < datar;
	}

	public void bucketRadix(int[] seq, int start, int end, int d) {
		// 从数字的最左面到最右面的每个数字是一次递归，直到排序数组就剩下一个元素，一个元素就是已经排序的，如果d=0，那么就是元素到最后一个数字还一样，也就是剩下元素各个相等了
		if (start >= end || d == 0)
			return;

		int base = seq[start];
		int l = start;
		int r = end;

		// 以第一个元素以d个数字为划分的基准，把元素分成3组，start~l-1:小于第一个元素，l~m：等于第一个元素的，m~end:大于第一个元素
		for (int i = start + 1; i <= r; i++) {
			if (less(seq[i], base, d)) {
				AlUtil.swap(seq, ++l, i);
			} else if (equal(seq[i], base, d)) {
				AlUtil.swap(seq, i--, r--);
			}
		}

		// 把第一个元素放入大小的中间
		AlUtil.swap(seq, start, l);

		// 把后面的所有相等元素调整到中间
		int m = l;
		for (int i = r + 1; i <= end; i++) {
			AlUtil.swap(seq, ++m, i);
		}

		// 递归排序小于的集合，大于的集合，还有等于的集合以后面的数字排序
		bucketRadix(seq, start, l - 1, d);
		bucketRadix(seq, l, m, d / 10);
		bucketRadix(seq, m + 1, end, d);
	}

	public void sort(int seq[]) {
		bucketRadix(seq, 0, seq.length - 1, 1000000000);
	}
}
