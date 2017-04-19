package com.robert.jvm.test;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Test {
	public static void main(String[] args) throws InterruptedException, IOException {
		new Thread(new Runnable() {
			
			
			public void run() {
				while (true) {
					System.out.println("I am running..");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
		int c = System.in.read();
		System.out.println(c);
	

	}
}
