package com.robert.dsal.advance.bag01;

public class BagSolution implements Cloneable {
	public Object[] bags;
	public boolean[] vector;

	public int volumn;

	public int valueSum;
	public int weightSum;

	// 分支界定是广度优先遍历，需要保存部分解决方案
	public int curr;

	public BagSolution(Object[] bags, boolean[] vector, int volumn) {
		this.bags = bags;
		this.vector = vector;

		this.volumn = volumn;

		this.valueSum = 0;
		this.weightSum = 0;

		this.curr = -1;
	}

	public BagSolution(Object[] bags, boolean[] vector, int volumn, int valueSum) {
		this.bags = bags;
		this.vector = vector;

		this.volumn = volumn;

		this.valueSum = valueSum;
		this.weightSum = 0;

		this.curr = -1;
	}
	
	public void copyFrom(BagSolution other) {
		this.bags = other.bags;
		this.vector = other.vector.clone();
		this.volumn = other.volumn;

		this.valueSum = other.valueSum;
		this.weightSum = other.weightSum;

		this.curr = other.curr;
	}

	public BagSolution clone() {
		BagSolution copy = null;
		try {
			copy = (BagSolution) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		copy.vector = this.vector.clone();

		return copy;
	}

	public BagSolution nextStep(boolean include) {
		BagSolution copy = this.clone();

		copy.curr++;

		if (include) {
			copy.valueSum += copy.bags[copy.curr].value;
			copy.weightSum += copy.bags[copy.curr].weight;
			copy.vector[copy.curr] = true;
		}

		return copy;
	}

	public double missRatio(int value) {
		if (this.volumn == this.weightSum)
			return Double.MAX_VALUE;
		
		return (value - this.valueSum) / (this.volumn - this.weightSum);
	}

	public double nextMaxRatio() {
		return this.bags[this.curr + 1].getRatio();
	}

	public boolean isValidSolution() {
		return this.valueSum > 0 && this.weightSum <= this.volumn;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Best Value: ").append(valueSum);

		sb.append("[");
		for (int i = 0; i < vector.length; i++) {
			if (vector[i]) {
				sb.append(bags[i].id);
				sb.append(",");
			}
		}

		sb.setCharAt(sb.length() - 1, ']');

		return sb.toString();
	}
}
