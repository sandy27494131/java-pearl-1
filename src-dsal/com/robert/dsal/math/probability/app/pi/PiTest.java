package com.robert.dsal.math.probability.app.pi;

public class PiTest {
	public static void main(String[] args) {
		Pi pi = new PiImpl();
		double p = pi.calcPi();
		System.out.println(p);
	}
}
