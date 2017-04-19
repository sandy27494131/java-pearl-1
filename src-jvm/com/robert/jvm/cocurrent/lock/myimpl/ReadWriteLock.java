package com.robert.jvm.cocurrent.lock.myimpl;

// TODO To be implemented in language level and support level
public interface ReadWriteLock {
	void lockRead();

	void lockWrite();

	void unlockRead();

	void unlockWrite();
}
