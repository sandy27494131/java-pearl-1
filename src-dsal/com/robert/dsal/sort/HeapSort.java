package com.robert.dsal.sort;

import com.robert.dsal.util.AlUtil;

/**
 * 
 * 堆排序一次需要选择出来一个最大或者最小的，因此一共需要n次，每次找出最大的或者最小的元素后，需要调整树，因为树是排序的二叉树，
 * 每次最多需要调整log2N个元素，所以，复杂度是NLog2N
 * 
 * 
 * http://www.cnblogs.com/dolphin0520/archive/2011/10/06/2199741.html
 * http://blog.csdn.net/morewindows/article/details/6709644
 * 
 */
public class HeapSort implements Sort {

	private static void adjustHeap(int[] data, int start, int end) {
		while (2 * start + 1 < end) {
			int max = 2 * start + 1;
			if (2 * start + 2 < end) {
				if (data[2 * start + 2] > data[max])
					max = 2 * start + 2;
			}

			if (data[max] > data[start]) {
				int tmp = data[start];
				data[start] = data[max];
				data[max] = tmp;

				start = max;
			} else {
				break;
			}
		}
	}

	private static void sortHeap(int[] data, int start, int end) {
		for (int i = end - 1; i > 0; i--) {
			AlUtil.swap(data, 0, i);

			adjustHeap(data, start, i);
		}
	}

	public void sort(int[] seq) {
		// 后面一半是叶子节点，跳过叶子节点，对于每一个非叶子节点进行一次调整
		for (int i = seq.length / 2; i >= 0; i--) {
			adjustHeap(seq, i, seq.length);
		}

		// 每次拿出来一个，一共是n次，最坏情况下是log2N,所以最坏复杂度是nlog2N
		sortHeap(seq, 0, seq.length);
	}
}
