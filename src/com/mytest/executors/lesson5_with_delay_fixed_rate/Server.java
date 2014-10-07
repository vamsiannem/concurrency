/**
 * 
 */
package com.mytest.executors.lesson5_with_delay_fixed_rate;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
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

	public  ScheduledFuture<?> executeTask(Runnable task){
		System.out.printf("Server: A new task has arrived\n");

		ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
		//ScheduledFuture<?> result = executor.scheduleWithFixedDelay(task, 0, 2, TimeUnit.SECONDS);
		return result;
	} 

	public void endServer(){
		System.out.println("End Server Calling....");			
		executor.shutdown();
	}
}
