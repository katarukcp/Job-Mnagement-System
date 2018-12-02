package com.job.local;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// creates thread pool of size 2
		ScheduledThreadPoolExecutor threadPool = new ScheduledThreadPoolExecutor(2);
		threadPool.schedule(new MyTask1(), 1, TimeUnit.SECONDS);
		threadPool.schedule(new MyTask2(), 1, TimeUnit.SECONDS);
	}

}

class MyTask1 implements Runnable {
	public void run() {
		System.out.println("Task1 is running");
	}
}

class MyTask2 implements Runnable {
	public void run() {
		System.out.println("Task2 is running");
	}
}
