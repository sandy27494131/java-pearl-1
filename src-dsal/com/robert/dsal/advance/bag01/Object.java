package com.robert.dsal.advance.bag01;

public class Object {
	public int id;
	public int weight;
	public int value;

	public Object(int id, int weight, int value) {
		this.id = id;
		this.weight = weight;
		this.value = value;
	}
	
	public double getRatio() {
		return value/weight;
	}
}
