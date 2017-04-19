package com.robert.jvm.cocurrent.mythreadpool;

public interface ThreadPool<T> {
	public void runTask(Task<T> t);
	public void startup();
	public void shutdown();
}
