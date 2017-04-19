package com.robert.jvm.cocurrent.mythreadpool;

public interface Task<T> {
	public T run();
	public T getResult();
}
