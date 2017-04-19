package com.robert.dsal.list;

public class ArrayRingSpotTest {

	public void run() {
		final int N = 100;

		int[] seq = new int[N];
		for (int i = 0; i < N; i++) {
			seq[i] = (i + 1) % N;
		}

		StaticListRingSpot ars = new StaticListRingSpotDefault();

		boolean bHas = ars.spotRing(seq);
		System.out.println(bHas ? "Ring!" : "No Ring!");

		if (bHas) {
			int iSize = ars.spotRingSize(seq);
			System.out.format("The rind size is %d!", iSize);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		new ArrayRingSpotTest().run();
	}
}
