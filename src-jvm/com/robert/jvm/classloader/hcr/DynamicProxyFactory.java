package com.robert.jvm.classloader.hcr;

import java.lang.reflect.Proxy;

/**
 * java代理工厂实现
 * 
 * @author Robert
 */
public class DynamicProxyFactory {
	/*
	 * 方法处理者
	 */
	private DefaultInvocationHandler invocationHandler;

	public DynamicProxyFactory() {
		this(null);
	}

	/**
	 * 
	 * @param invocationHandler
	 */
	public DynamicProxyFactory(DefaultInvocationHandler invocationHandler) {
		if (invocationHandler == null) {
			this.invocationHandler = new DefaultInvocationHandler();
		} else {
			this.invocationHandler = invocationHandler;
		}
	}

	/**
	 * 创建代理对象
	 * 
	 * @param target
	 * @return
	 */
	public Object newProxyInstance(final Object target) {
		invocationHandler.setTarget(target);
		Object proxy = Proxy.newProxyInstance(target.getClass()
				.getClassLoader(), target.getClass().getInterfaces(),
				invocationHandler);
		return proxy;
	}
}
