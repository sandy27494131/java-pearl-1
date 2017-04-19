package com.robert.dsal.advance.bag01;

/**
 * 
 * 2^n, 但是有回溯，比蛮立法有所改进， 这也是深度优先遍历
 * 
 */
public class BagProblemBackTrace implements BagProblem {
	public BagSolution bestSolution(Object[] bags, int volumn) {
		BagSolution best = new BagSolution(bags, new boolean[bags.length],
				volumn);
		BagSolution current = new BagSolution(bags, new boolean[bags.length],
				volumn);

		bestSolution(best, current, bags, volumn, 0);

		return best;
	}

	private void bestSolution(BagSolution best, BagSolution current,
			Object[] bags, int volumn, int i) {
		if (i == bags.length) {
			if (current.weightSum <= volumn && current.valueSum > best.valueSum) {
				best.copyFrom(current);
			}
			return;
		}

		// 回溯，在容量超出了限制后回溯，这就是限定函数
		if (current.weightSum > volumn)
			return;

		current.vector[i] = true;
		current.valueSum += bags[i].value;
		current.weightSum += bags[i].weight;
		bestSolution(best, current, bags, volumn, i + 1);

		current.vector[i] = false;
		current.valueSum -= bags[i].value;
		current.weightSum -= bags[i].weight;
		bestSolution(best, current, bags, volumn, i + 1);
	}
}
