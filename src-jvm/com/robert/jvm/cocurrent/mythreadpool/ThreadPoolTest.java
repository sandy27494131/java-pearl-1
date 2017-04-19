package com.robert.jvm.cocurrent.mythreadpool;

public class ThreadPoolTest {

	public static void main(String[] args) throws InterruptedException {
		ThreadPool<String> tp = new SimpleThreadPool<String>(10);

		tp.startup();

		ResultTask<String> rt = new ResultTask<String>() {

			@Override
			public String run() {
				System.out.println("Task is executed.");
				return "Successful!";
			}
		};

		tp.runTask(rt);

		while (rt.getResult() == null)
			Thread.sleep(100);

		System.out.println("The task result: " + rt.getResult());

		tp.shutdown();
	}

}
