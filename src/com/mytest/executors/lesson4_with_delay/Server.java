/**
 * 
 */
package com.mytest.executors.lesson4_with_delay;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author vamsikrishna
 *
 */
public class Server {

	private ScheduledExecutorService executor;
	private int i=0;
	/**
	 * @param executor
	 */
	public Server() {
		super();
		this.executor = Executors.newScheduledThreadPool(5);
	}

	public void executeTask(Runnable task){
		System.out.printf("Server: A new task has arrived\n");
		executor.schedule(task, ++i, TimeUnit.SECONDS);
	}

	public void endServer(){
		System.out.println("End Server Calling....");			
		executor.shutdown();
	}
}
