package com.robert.dsal.hash;

import com.robert.dsal.util.TestUtil;

public class HashtableTest {
	public void run() {
		HashTableImpl ht = new HashTableImpl();
		ht.put("1", "hello1");
		ht.put("2", "hello2");
		ht.put("3", "hello3");

		ht.print();

		TestUtil.assertEqual(ht.get("1"), "hello1");
		TestUtil.assertEqual(ht.get("2"), "hello2");
		TestUtil.assertEqual(ht.get("3"), "hello3");

		ht.print();
	}

	public static void main(String[] args) {
		new HashtableTest().run();
	}
}
