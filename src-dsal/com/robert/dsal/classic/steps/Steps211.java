package com.robert.dsal.classic.steps;

public class Steps211 {
	public static void main(String[] args) {
		final int[] buffer = new int[2000000];

		long t = System.currentTimeMillis();
		for (int i = 1; i < 2000000; i++)
			System.out.println(get(buffer, i));
		System.out.println("Time: " + ((System.currentTimeMillis() - t)/1000));
	}

	private static int get(int[] buffer, int t) {
		if (buffer[t] == 0) {
			fill(buffer, t);
		}

		return buffer[t];
	}

	private static void fill(int[] buffer, int t) {
		int steps = 0;

		int i = t;
		while (i > 1) {
			if (i % 2 == 0)
				i = i / 2;
			else
				i = i * 3 + 1;
			
			if (i > 0 && i < buffer.length && buffer[i] != 0) {
				buffer[t] = buffer[i] + steps + 1;
				return;
			}

			steps++;
		}

		buffer[t] = steps;
	}
}
