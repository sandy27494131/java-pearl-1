package com.robert.arch.ood.calc;

import java.util.List;

public class ConsoleOutput implements Output {

	public void outputCurrentValue(double value) {
		System.out.println("The current value is: " + value);

	}

	public void outputExpression(List<String> expression) {
		System.out.print("The current expression is: ");
		for (int i = 0; i < expression.size(); i++) {
			System.out.print(" " + expression.get(i));
		}

		System.out.println("");
	}

	public void outputSuffixExpression(List<String> expression) {
		
		System.out.print("The current suffix expression is: ");
		for (int i = 0; i < expression.size(); i++) {
			System.out.print(" " + expression.get(i));
		}

		System.out.println("");
	}

	@Override
	public void outputOperator(List<String> operator) {
		System.out.print("The operator list is: ");
		for (int i = 0; i < operator.size(); i++) {
			System.out.print(" " + operator.get(i));
		}

		System.out.println("");
		
	}

}
