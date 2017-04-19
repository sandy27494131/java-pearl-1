package com.robert.jvm.io.memfile;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
/**
 * MappedByteBuffer适合多次来回的读取的程序，例如，给源代码着色
 * 
 * 随机读取和顺序读取效率都很高
 * 
 * 不适合写入多的程序
 * 
 *
 */
public class MappedByteBufferUtil {
	public void cleanMapFile(final ByteBuffer bb) {
		//DirectByteBuffer
		AccessController.doPrivileged(new PrivilegedAction() {
			public Object run() {
				try {
					Method getCleanerMethod = bb.getClass().getMethod(
							"cleaner", new Class[0]);
					getCleanerMethod.setAccessible(true);
					sun.misc.Cleaner cleaner = (sun.misc.Cleaner) getCleanerMethod
							.invoke(bb, new Object[0]);
					cleaner.clean();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
		});
	}
	
	public void cleanMapFile1(final ByteBuffer bb) {
		//DirectByteBuffer
		// bb = null;
		System.gc();
	}
}
