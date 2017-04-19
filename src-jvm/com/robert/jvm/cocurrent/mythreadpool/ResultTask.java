package com.robert.jvm.cocurrent.mythreadpool;

public abstract class ResultTask<T> implements Task<T> {
	private T result;

	@Override
	public abstract T run();

	@Override
	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}
