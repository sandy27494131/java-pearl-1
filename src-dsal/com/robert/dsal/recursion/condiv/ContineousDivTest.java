package com.robert.dsal.recursion.condiv;

public class ContineousDivTest {

	public static void main(String[] args) {
		double[] array = {100, 2, 2, 2, 30, 2};
		
		ContineousDiv cdDefault = new ContineousDivImpl();
		ContineousDiv cdRecursion = new ContineousDivRecursion();
		
		double defaultResult = cdDefault.divContineously(array);
		double recursionResult = cdRecursion.divContineously(array);
		
		System.out.println("Default Impl: " + defaultResult);
		System.out.println("Recursion Impl: " + recursionResult);

	}

}
