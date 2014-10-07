/**
 * 
 */
package com.mytest.executors.lesson1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author vamsikrishna
 *
 */
public class Server {
	
	private ThreadPoolExecutor executor;

	/**
	 * @param executor
	 */
	public Server() {
		super();
		this.executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	}

	public void executeTask(Runnable task){
		System.out.printf("Server: A new task has arrived\n");
		executor.execute(task);
		System.out.println("Pool Size:"+executor.getPoolSize());
		System.out.println("Active Count:"+executor.getActiveCount());
		System.out.println("Completed Task Count:"+executor.getCompletedTaskCount());
	}
	
	public void endServer(){
		executor.shutdown();
	}
}
