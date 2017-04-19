package com.robert.dsal.classic.josephring;

import com.robert.dsal.util.TestUtil;

public class JosephRingTest {

	public void run() {
		JosephRing jr1 = new JosephRingDefault();
		JosephRing jr2 = new JosephRingByStaticList();

		int l1 = jr1.findLastOut(10, 3);
		int l2 = jr2.findLastOut(10, 3);

		System.out.println(l1 + ":" + l2);

		TestUtil.assertEqual(l1, l2);
	}

	public static void main(String[] args) {
		new JosephRingTest().run();
	}

}
