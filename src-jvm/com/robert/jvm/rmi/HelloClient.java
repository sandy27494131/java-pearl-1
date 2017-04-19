package com.robert.jvm.rmi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

// TODO ÑÐ¾¿RMI-IIOP, WSI
// http://www.blogjava.net/boddi/archive/2006/10/11/74430.html
public class HelloClient {

	public static void main(String[] args) {
		try {
			HelloService helloworld = (HelloService) Naming
					.lookup("rmi://localhost:8888/helloWorld");
			System.out.println(helloworld.echo("kylin soong") + "\n"
					+ helloworld.getTime());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}