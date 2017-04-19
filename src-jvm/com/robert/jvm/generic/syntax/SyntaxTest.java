package com.robert.jvm.generic.syntax;

public class SyntaxTest {
	public static void main(String[] args) {
		// 区别模板定义时候的类型参数，和模板实例化时候的类型指定，都可以使用上下届，？是用在实例化中的模糊匹配的

		// 可以自动推测类型实例化
		ValueTest<Integer> valueTest = new ValueTest();
		// <>这个操作符是隐士的模板实例化
		ValueTest<Integer> valueTest1 = new ValueTest<>();
		ValueTest<Integer> valueTest2 = new ValueTest<Integer>();

		// 类实例化的时候可以用模糊匹配
		ValueTest<?> valueTest3 = new ValueTest<Integer>();
		ValueTest<Integer> valueTest4 = new ValueTest<Integer>();

		// ?模糊匹配的，需要强制转换
		Integer i1 = (Integer) valueTest3.method();
		Integer i2 = valueTest4.method();

		ValueTest<? extends Object> valueTest5 = new ValueTest();

		// 显示的实例化模板
		valueTest5.<String> method1();

		// 隐式实例化模板
		String s = valueTest5.method1();

	}
}

class ValueTest<T extends Object> {
	T value;

	T method() {
		return null;
	}

	<E> E method1() {
		return null;
	}
}
