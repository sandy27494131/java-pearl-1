package com.robert.jvm.classloader.hcr;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ClassLoaderAdvisor extends ClassLoader {
	public ClassLoaderAdvisor() {
	}

	public ClassLoaderAdvisor(ClassLoader parentLoader) {
		super(parentLoader);
	}

	/**
	 * 加载某个类
	 * 
	 * @param c
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked" })
	public Class loadClass(Class c) throws IOException {
		byte[] bs = loadByteCode(c);
		Class cNew = super.defineClass(c.getCanonicalName(), bs, 0, bs.length);
		return cNew;
	}

	/**
	 * 加载某个类的字节码
	 * 
	 * @param c
	 * @return
	 * @throws IOException
	 */
	private byte[] loadByteCode(Class c) throws IOException {
		int iRead = 0;
		String path = c.getResource(c.getSimpleName() + ".class").getPath();

		FileInputStream in = null;
		ByteArrayOutputStream buffer = null;
		try {
			in = new FileInputStream(path);
			buffer = new ByteArrayOutputStream();
			while ((iRead = in.read()) != -1) {
				buffer.write(iRead);
			}
			return buffer.toByteArray();
		} finally {
			if (in != null)
				in.close();
			if (buffer != null)
				buffer.close();

		}
	}
}
