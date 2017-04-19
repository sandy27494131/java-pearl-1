package com.robert.jvm.classloader.hcr;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建可以动态更新的java对象<br>
 * 限制:构造函数不能有参数 必须实现一个接口 只能有实例方法(因为接口中不能有静态方法)
 * 
 * @author Robert
 */
public class ClassManager {
	/**
	 * 保存类路径和时间
	 */
	private static Map mapModify = new HashMap();
	/**
	 * 该类被加载时的时间
	 */
	private static Date firstDate = new Date();

	/**
	 * 如果class文件重新生成过会自动加载,只有重新创建才会更新
	 * 
	 * @param name
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Object getInstance(String name) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, IOException {
		Class c = Class.forName(name);
		Class cNew = reloadClass(c);
		if (cNew == null) {
			cNew = c;
		}
		Object o = cNew.newInstance();
		return o;
	}

	/**
	 * 创建代理对象,如果class文件重新生成过会自动加载,调用原先以实例化的方法时也会更新类
	 * 
	 * @param name
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Object getInstanceProxy(String name) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, IOException {
		Object target = getInstance(name);

		DynamicProxyFactory factory = new DynamicProxyFactory(
				new HotInvocationHandler(this));

		return factory.newProxyInstance(target);
	}

	/**
	 * 重新加载类
	 * 
	 * @param c
	 * @return
	 * @throws IOException
	 */
	public synchronized Class reloadClass(Class c) throws IOException {
		Class cNew = null;
		if (hasChanged(c)) {
			cNew = loadClass(c);
		}
		return cNew;
	}

	private boolean hasChanged(Class c) throws IOException {
		boolean isChanged = false;
		String path = c.getResource(c.getSimpleName() + ".class").getPath();
		File f = new File(path);
		if (f.exists()) {
			Date newDate = new Date(f.lastModified());
			Date oldDate = null;
			String key = f.getCanonicalPath();
			if (mapModify.containsKey(key)) {
				oldDate = (Date) mapModify.get(key);
			} else {
				oldDate = firstDate;
			}
			isChanged = oldDate.compareTo(newDate) < 0;
			if (isChanged) {
				mapModify.put(key, newDate);
			}
		}
		return isChanged;
	}

	private Class loadClass(Class c) throws IOException {
		ClassLoaderAdvisor classLoader = new ClassLoaderAdvisor();
		Class cNew = classLoader.loadClass(c);
		return cNew;
	}

}
