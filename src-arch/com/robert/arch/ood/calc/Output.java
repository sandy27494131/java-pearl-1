package com.robert.arch.ood.calc;

import java.util.List;

public interface Output {
	public void outputCurrentValue(double value);
	public void outputExpression(List<String> expression);
	public void outputSuffixExpression(List<String> expression);
	public void outputOperator(List<String> operator);
}
