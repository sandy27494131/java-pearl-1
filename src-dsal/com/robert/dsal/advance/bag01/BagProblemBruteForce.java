package com.robert.dsal.advance.bag01;

/**
 * 
 * 2^n， 这是深度优先遍历
 * 
 */
public class BagProblemBruteForce implements BagProblem {
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
