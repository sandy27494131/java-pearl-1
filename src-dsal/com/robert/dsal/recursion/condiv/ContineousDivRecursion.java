package com.robert.dsal.recursion.condiv;

public class ContineousDivRecursion implements ContineousDiv {

	public double divContineously(double[] operants) {
		return divContineously(operants, operants.length - 1);
	}

	/**
	 * 计算从0 - i所在位置连除的值
	 */
	private double divContineously(double[] operants, int i) {
		if (i == 1)
			return operants[0] / operants[1];

		// 计算从0 - i-1最在位置连除的值，然后再除以i所在位置的值
		return divContineously(operants, i - 1) / operants[i];
	}

}
