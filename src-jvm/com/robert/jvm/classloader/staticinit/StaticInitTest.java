package com.robert.jvm.classloader.staticinit;

public class StaticInitTest {
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		/*
			// 静态初始化
			Class<?> clazz = Class.forName("com.robert.jvm.classloader.staticinit.InitObject");
			// 已经初始化过
			clazz.newInstance();
		*/

		/*
			// 没有静态初始化
			Class clazz = Class.forName("com.robert.jvm.classloader.staticinit.InitObject",false, StaticInitTest.class.getClassLoader());
			// 实例化的时候静态初始化
			clazz.newInstance();
		*/

		// 执行静态初始
		Class<?> c = ClassLoader.getSystemClassLoader().loadClass("com.robert.jvm.classloader.staticinit.InitObject");
		// 实例化的时候执行静态初始化
		c.newInstance();
		
		// 总结，默认Class.forName执行静态初始化，但是可以显示的传入参数进行静态初始化，ClassLoader.loadClass不执行静态初始化
		// Class.newInstance的时候如果没有初始化过，那么就进行初始化
	}
}

class InitObject {
	static {
		System.out.println("Static Init...");
	}
}