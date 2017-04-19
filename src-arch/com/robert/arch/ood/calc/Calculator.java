package com.robert.arch.ood.calc;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// TODO 优化成一边输入一遍直接转换后缀表达式，并且计算出部分结果，例如Windowscalc

/**
 * 
 * Calculator&Suffix Expression:
 * 
 * http://blog.csdn.net/niushuai666/article/details/6702964
 * http://zhidao.baidu.com/link?url=
 * ADxulf7yDTY9KNn9G5N6Cl7dHi6TR9Jb82PsQMTGcfuwBcwiXV1zgRHoflQSdb_nlFr8u6L7xcMoWwzh
 * -y748a
 * 
 */
public class Calculator {
	private List<String> expression = new LinkedList<String>();

	private List<String> suffixExpression = new LinkedList<String>();

	private double currentValue;

	// TODO Used stack instead
	private List<String> operator = new LinkedList<String>();

	private Input input;
	private Output output;

	public Calculator() {

	}

	public void setInput(Input input) {
		this.input = input;
	}

	public void setOutput(Output output) {
		this.output = output;
	}

	public void run() {
		while (true) {
			char c = this.input.input();

			if (c == '=') {
				calculateResult();
				output.outputCurrentValue(currentValue);
				clear();
				continue;
			}

			if (c == 'c') {
				clear();
				break;
			}

			inputChar(c);

			constructSuffixExpression();

			output.outputExpression(expression);
			output.outputSuffixExpression(suffixExpression);
			output.outputOperator(operator);
		}
	}

	private void calculateResult() {
		for (int i = operator.size() - 1; i >= 0; i--) {
			suffixExpression.add(operator.get(i));
		}

		output.outputSuffixExpression(suffixExpression);

		Stack<String> stack = new Stack<String>();

		for (String s : suffixExpression) {
			if (Util.isNumber(s)) {
				stack.push(s);

			} else if (Util.isOperator(s)) {
				int i2 = Integer.valueOf(stack.pop());
				int i1 = Integer.valueOf(stack.pop());
				int result = 0;
				switch (s) {
				case "+":
					result = i1 + i2;
					break;

				case "-":
					result = i1 - i2;
					break;

				case "*":
					result = i1 * i2;
					break;

				case "/":
					result = i1 / i2;
					break;

				default:
					break;
				}

				stack.push(new Integer(result).toString());
			}
		}

		currentValue = Integer.valueOf(stack.pop());
	}

	private void constructSuffixExpression() {
		suffixExpression.clear();
		operator.clear();

		for (String sTemp : expression) {
			if (Util.isNumber(sTemp)) {
				suffixExpression.add(sTemp);
				continue;
			}

			if (operator.isEmpty()) {
				operator.add(sTemp);
			} else if (Util.isOperator(sTemp)
					&& Util.isGreaterEqual(operator.get(operator.size() - 1),
							sTemp)) {
				for (int i = operator.size() - 1; i >= 0; i--) {
					if (Util.isGreaterEqual(operator.get(i), sTemp)) {
						String o = operator.remove(i);
						suffixExpression.add(o);
					}
				}
				operator.add(sTemp);
			} else {
				operator.add(sTemp);
			}
		}

	}

	private void inputChar(char c) {
		if (expression.isEmpty()) {
			expression.add(Character.valueOf(c).toString());
			return;
		}

		String sCurrent = expression.remove(expression.size() - 1);

		if (Util.isNumber(sCurrent) && Util.isNumber(c)) {
			sCurrent = sCurrent + c;
			expression.add(sCurrent);
		}

		if (Util.isNumber(sCurrent) && Util.isOperator(c)) {
			expression.add(sCurrent);
			expression.add(Character.valueOf(c).toString());
		}

		if (Util.isOperator(sCurrent) && Util.isNumber(c)) {
			expression.add(sCurrent);
			expression.add(Character.valueOf(c).toString());
		}

		if (Util.isOperator(sCurrent) && Util.isOperator(c)) {
			expression.add(Character.valueOf(c).toString());
		}
	}

	protected void clear() {
		expression.clear();
		suffixExpression.clear();
		operator.clear();
		currentValue = 0;
	}

	public static void main(String[] args) throws InterruptedException {
		Calculator cal = new Calculator();

		cal.setInput(new ConsoleInput());
		cal.setOutput(new ConsoleOutput());

		cal.run();
	}
}
