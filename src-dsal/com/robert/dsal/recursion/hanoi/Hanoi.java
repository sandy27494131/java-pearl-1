package com.robert.dsal.recursion.hanoi;

public class Hanoi {
	// 把0 - n个盘子从from通过by移动到to
	public void moveDisks(int n, char from, char to, char by) {
		if (n == 1) {
			moveDisk(1, from, to);
			return;
		}

		moveDisks(n - 1, from, by, to);
		moveDisk(n, from, to);
		moveDisks(n - 1, by, to, from);
	}

	// 把第n个盘子（一个盘子）从from移动到to
	private void moveDisk(int n, char from, char to) {
		System.out.println("Move disk# " + n + " from " + from + " to " + to);
	}

	public static void main(String[] args) {
		new Hanoi().moveDisks(10, 'A', 'C', 'B');
	}
}
