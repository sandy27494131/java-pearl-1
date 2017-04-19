package com.robert.jvm.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class HelloServiceImpl extends UnicastRemoteObject implements
		HelloService {

	private String name;

	public HelloServiceImpl(String name) throws RemoteException {
		this.name = name;
	}

	public String echo(String msg) throws RemoteException {
		return "echo: " + msg + " from " + name;
	}

	public Date getTime() throws RemoteException {
		return new Date();
	}
}