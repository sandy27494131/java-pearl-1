package com.robert.dsal.sort;

import com.robert.dsal.util.DataUtil;
import com.robert.dsal.util.DisplayUtil;
import com.robert.dsal.util.TestUtil;

public class SortTest {

	public void run() {

		int[] seqInsert = DataUtil.genSeq(10);
		int[] seqSelect = seqInsert.clone();
		int[] seqBubble = seqInsert.clone();

		int[] seqShell = seqInsert.clone();

		int[] seqQuick = seqInsert.clone();
		int[] seqHeap = seqInsert.clone();
		int[] seqMerge = seqInsert.clone();

		int[] seqRadix = seqInsert.clone();
		int[] seqBucket = seqInsert.clone();

		DisplayUtil.printSeq("Before Sort", seqQuick);

		Sort sortInsert = new InsertionSort();
		Sort sortSelect = new SelectionSort();
		Sort sortBubble = new BubbleSort();
		
		Sort sortShell = new ShellSort();
		
		Sort sortQuick = new QuickSort();
		Sort sortHeap = new HeapSort();
		Sort sortMerge = new MergeSort();
		
		Sort sortRadix = new RadixSort();
		Sort sortBucket = new BucketSort();
		
		sortInsert.sort(seqInsert);
		sortSelect.sort(seqSelect);
		sortBubble.sort(seqBubble);
		
		sortShell.sort(seqShell);
		
		sortQuick.sort(seqQuick);
		sortHeap.sort(seqHeap);
		sortMerge.sort(seqMerge);
		
		sortRadix.sort(seqRadix);
		sortBucket.sort(seqBucket);
		
		
		DisplayUtil.printSeq("Insert Sort", seqInsert);
		DisplayUtil.printSeq("Select Sort", seqSelect);
		DisplayUtil.printSeq("Bubble Sort", seqBubble);
		
		DisplayUtil.printSeq("Shell Sort", seqShell);
		
		DisplayUtil.printSeq("Quick Sort", seqQuick);
		DisplayUtil.printSeq("Heap Sort", seqHeap);
		DisplayUtil.printSeq("Merge Sort", seqMerge);
		
		DisplayUtil.printSeq("Radix Sort", seqRadix);
		DisplayUtil.printSeq("Bucket Sort", seqBucket);
		

		for (int i = 0; i < seqQuick.length; i++) {
			if (i + 1 < seqQuick.length) {
				TestUtil.assertLessOrEqual(seqQuick[i], seqQuick[i + 1]);
			}
		}
		TestUtil.assertEqual(seqQuick, seqHeap);
		TestUtil.assertEqual(seqHeap, seqRadix);
		TestUtil.assertEqual(seqRadix, seqBucket);
		TestUtil.assertEqual(seqBucket, seqMerge);
		TestUtil.assertEqual(seqMerge, seqInsert);
	}

	public static void main(String[] args) {
		new SortTest().run();
	}

}
