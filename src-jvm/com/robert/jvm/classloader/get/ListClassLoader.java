package com.robert.jvm.classloader.get;

public class ListClassLoader {
	public static void main(String[] args) {
		ClassLoader cl = ClassLoader.getSystemClassLoader();

		while (cl != null) {
			System.out.println(cl.getClass().getName());
			cl = cl.getParent();
		}

		/**
		 * sun.misc.Launcher$AppClassLoader 
		 * sun.misc.Launcher$ExtClassLoader
		 * 
		 * ¿´²»µ½Bootstrap Classloader
		 */
	}
}
