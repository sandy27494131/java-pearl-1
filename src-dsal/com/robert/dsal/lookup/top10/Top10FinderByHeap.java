package com.robert.dsal.lookup.top10;

import com.robert.dsal.util.AlUtil;
import com.robert.dsal.util.DisplayUtil;

public class Top10FinderByHeap implements Top10Finder {
    public int[] findTop10(int[] a) {
        DisplayUtil.printSeq("Srouce Data", a);

        // 填充堆
        int[] heap = new int[10];
        for (int i = 0; i < 10; i++)
            heap[i] = a[i];

        DisplayUtil.printSeq("Heap Filled", heap);
        
        // 构造最小堆
        construct(heap);
        
        DisplayUtil.printSeq("Heap Init", heap);

        for (int i = 10; i < a.length; i++) {
            if (a[i] > heap[0]) {
                //如果某一个值比最小堆的最小值大，则替换最小堆的最小值
                heap[0] = a[i];
                adjust(heap, 0, heap.length);
            }

            DisplayUtil.printSeq("Step " + i, heap);
        }

        return heap;
    }

    private void construct(int[] heap) {
        // 从第一个非叶子节点开始向前调整
        for (int i = heap.length / 2; i >= 0; i--) {
            adjust(heap, i, heap.length);
        }
    }

    private void adjust(int[] heap, int start, int end) {
        while (2 * start + 1 < end) {
            int min = 2 * start + 1;

            // 找到两个孩子中最小的
            if (2 * start + 2 < end && heap[2 * start + 2] < heap[min]) min = 2 * start + 2;

            
            if (heap[min] < heap[start]) {
             // 如果孩子比父亲还小，则交换，从交换的孩子节点继续往下调整
                AlUtil.swap(heap, min, start);
                start = min;
            } else
                // 如果父节点最小，则是合法的堆
                break;
        }
    }
}
