package com.robert.dsal.advance.bag01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * 2^n, 除了有普通的回溯外，还有分支界定的剪枝，分支界定通过广度优先遍历，优先找到一个最有可能的解，然后，用最有可能的解进行剪枝，效率更加提高
 * 
 * 分支界定是广度优先遍历
 */

public class BagProblemBranchBound implements BagProblem {
	public BagSolution bestSolution(Object[] bags, int volumn) {
		// 按照价值重量比降序排列，用于剪枝
		Arrays.sort(bags, new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				return o1.getRatio() - o2.getRatio() > 0 ? -1 : 1;
			}
		});

		// 解空间的集合，每个解可能是部分解，不完全
		List<BagSolution> solutions = new ArrayList<BagSolution>();

		// 初始化第一个元素进入解空间
		BagSolution seed = new BagSolution(bags, new boolean[bags.length],
				volumn);
		solutions.add(seed.nextStep(false));
		solutions.add(seed.nextStep(true));

		// 分支界定求解
		return bestSolution(solutions, bags, volumn);
	}

	private BagSolution bestSolution(List<BagSolution> solutions,
			Object[] bags, int volumn) {
		// 保存当前最佳方案
		BagSolution best = new BagSolution(bags, new boolean[bags.length],
				volumn);

		BagSolution active = null;

		// 取得活动节点，找价值最大的作为活动节点
		while ((active = loadCurrentBest(solutions)) != null) {
			// 普通回溯，和回溯法的是一样的，限定函数
			if (active.weightSum > volumn)
				continue;

			// 分支界定的回溯，通过价值重量比来回溯，因为是广度优先遍历，优先找到一个最有可能的解，然后，通过最有可能的解进行剪枝
			// 如果当前解的价值总和比当前最大还要大，则100%有希望成为最佳解，所以，继续递归
			// 如果当前解的价值总和比当前最大要小，就有希望通过剪枝而去掉
			// 如果还需要的价值重量比比能提供的最大的还大，就不可能是一个解，也就是即使用最大的能提供的质量来填充剩余的重量空间，还是没有当前最大好
			if (active.valueSum < best.valueSum
					&& active.missRatio(best.valueSum) > active.nextMaxRatio())
				continue;

			// 解决方案提取
			if (active.curr == bags.length - 1
					&& active.valueSum > best.valueSum) {
				best.copyFrom(active);
				//break;
				continue;
			}

			// 通过当前活节点生成下一步的两个扩展节点
			solutions.add(active.nextStep(false));
			solutions.add(active.nextStep(true));
		}

		return best;

	}

	private BagSolution loadCurrentBest(List<BagSolution> solutions) {
	    if (solutions.size() == 0)
	        return null;
	    
		int max = 0;

		// 找到当前价值最大的方案
		for (int i = 1; i < solutions.size(); i++) {
			BagSolution bs = solutions.get(i);

			if (bs.valueSum > max)
				max = i;
		}

		// 移出当前价值最大的方案
		BagSolution currentBest = solutions.get(max);
		solutions.remove(max);

		return currentBest;
	}
}
