package com.robert.dsal.advance.frogleap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * l^n, l就是元素的平均大小，也是平均弹跳长度，这里面有分支界定的回溯，能够剪枝，所以，效率大大提高，优先搜索可能最有解，然后用于剪枝
 * 
 */

public class FrogLeapBranchbound implements FrogLeap {

	public int[] fropLeap(int[] arrays) {
		int[] optimum = new int[arrays.length + 1];
		optimum[optimum.length - 1] = arrays.length;

		List<int[]> possibles = new ArrayList<int[]>();

		int[] current = new int[arrays.length + 1];
		current[current.length - 1] = 0;
		current[current[current.length - 1]++] = 0;

		possibles.add(current);

		while ((current = mostPossible(possibles, optimum[optimum.length - 1])) != null) {
			// 每次取得一个活几点，然后处理，处理之后用活节点产生扩展节点，此时可以对扩展节点过滤剪枝
			if (isOneSolution(current)) {
				if (current[current.length - 1] < optimum[optimum.length - 1]) {
					copySolution(optimum, current);
				}
				continue;
			}

			int csize = current[current.length - 1];
			int cindex = current[csize - 1];
			int cvalue = arrays[cindex];

			// 产生扩展节点，可以在产生过程中进行剪枝，但是这里都放入解空间，然后拿出活节点的时候再剪枝
			for (int i = 1; i <= cvalue; i++) {
				int nindex = cindex + i;

				int[] next = current.clone();
				next[next[next.length - 1]++] = nindex;
				possibles.add(next);
			}
		}

		return Arrays.copyOf(optimum, optimum[optimum.length - 1]);
	}

	private int[] mostPossible(List<int[]> possibles, int osize) {
		int[] mostPossible = null;

		for (int i = possibles.size() - 1; i >= 0; i--) {
			int[] p = possibles.get(i);

			int psize = p[p.length - 1];
			if (psize > osize)
				// 这里面是分支界定里面的回溯，也就是剪枝
				// 需要改进程序结构，这个程序结构复杂，而且数组最有一个元素作为长度比较麻烦
				possibles.remove(p);
			else if (mostPossible == null
					|| p[psize - 1] > mostPossible[mostPossible.length - 1])
				mostPossible = p;
		}

		if (mostPossible != null) {
			possibles.remove(mostPossible);
		}

		return mostPossible;
	}

	private boolean isOneSolution(int[] current) {
		int size = current[current.length - 1];
		int index = current[size - 1];
		return index >= current.length - 2;
	}

	private void copySolution(int[] optimum, int[] current) {
		for (int i = 0; i < current[current.length - 1]; i++)
			optimum[i] = current[i];

		optimum[optimum.length - 1] = current[current.length - 1];
	}

}
