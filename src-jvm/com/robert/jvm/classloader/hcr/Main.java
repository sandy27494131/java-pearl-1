package com.robert.jvm.classloader.hcr;

import java.io.IOException;

/**
 * Hot Code Replacement(HCR)
 * 
 * 要实现类的热加载，必须使用父类和接口，父类或者接口在App ClassLoader中加载，
 * 子类在客户化的ClassLoader中加载，当需要替换类的时候，同时需要替换ClassLoader的实例， 这样由于父类或者接口在App
 * ClassLoader中加载，因此即使换了ClassLoader也不会不匹配
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, InterruptedException {
		ClassManager manager = new ClassManager();
		String className = "com.robert.jvm.classload.Test";
		ITest t = (ITest) manager.getInstanceProxy(className);
		t.test();

		int size = 5;
		int i = 0;
		while (i < size) {
			System.out.println(i);
			i++;
			Thread.currentThread().sleep(1000);
		}

		t.test();

		i = 0;
		while (i < size) {
			System.out.println(i);
			i++;
			Thread.currentThread().sleep(1000);
		}

		t.test();

		long beginTime1 = System.currentTimeMillis();
		int count = 10000;
		for (int k = 0; k < count; k++) {
			t.test();
		}
		long endTime1 = System.currentTimeMillis();

		ITest t2 = new Test();
		long beginTime2 = System.currentTimeMillis();
		for (int k = 0; k < count; k++) {
			t2.test();
		}
		long endTime2 = System.currentTimeMillis();

		System.out.println("proxy time=======" + (endTime1 - beginTime1));
		System.out.println("no proxy time=======" + (endTime2 - beginTime2));

	}

}