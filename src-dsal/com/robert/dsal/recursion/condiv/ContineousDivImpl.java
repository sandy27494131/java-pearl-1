package com.robert.dsal.recursion.condiv;

public class ContineousDivImpl implements ContineousDiv {

	public double divContineously(double[] operants) {
		double result = operants[0];
		for (int i = 1; i < operants.length; i++) {
			result /= operants[i];
		}
		
		return result;
	}

}
