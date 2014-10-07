/**
 * 
 */
package com.mytest.executors.lesson2_fixedSize_threadExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
		this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
	}

	public void executeTask(Runnable task){
		System.out.printf("Server: A new task has arrived\n");
		executor.execute(task);
		System.out.println("Pool Size:"+executor.getPoolSize());
		System.out.println("Active Count:"+executor.getActiveCount());
		System.out.println("Completed Task Count:"+executor.getCompletedTaskCount());
	}

	public void endServer(){
		System.out.println("End Server Calling....");	
		while(executor.getActiveCount()!=0){
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Pool Size:"+executor.getPoolSize());
		System.out.println("Active Count:"+executor.getActiveCount());
		System.out.println("Completed Task Count:"+executor.getCompletedTaskCount());
		executor.shutdown();
	}
}
