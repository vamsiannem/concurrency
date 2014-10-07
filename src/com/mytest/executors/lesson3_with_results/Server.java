/**
 * 
 */
package com.mytest.executors.lesson3_with_results;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author vamsikrishna
 *
 */
public class Server {

	private ThreadPoolExecutor executor;
	private ThreadLocal<Integer> factorialValue = new ThreadLocal<>();
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
	
	public void executeCallable(Callable<Integer> task){
		System.out.printf("Server: A new task has arrived\n");
		Future<Integer> result = executor.submit(task);		
		
		try {
			Integer factorialVaue = result.get();
			this.factorialValue.set(factorialVaue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return factorialVaue;
	}
	
	public List<Future<Integer>> executeCallables(List<Callable<Integer>> tasks) throws InterruptedException{
		// Instead of this looping, use method invokeAll
		/*List<Future<Integer>> results = new ArrayList<>();
		for (Callable<Integer> callable : tasks) {
			Future<Integer> result = executor.submit(callable);
			results.add(result);
		}
		return results;*/
		return executor.invokeAll(tasks);
		//return factorialVaue;
		
	}
	
	public Integer executeCallablesSingle(List<Callable<Integer>> tasks) throws InterruptedException, ExecutionException{
		// Instead of this looping, use method invokeAll
		/*List<Future<Integer>> results = new ArrayList<>();
		for (Callable<Integer> callable : tasks) {
			Future<Integer> result = executor.submit(callable);
			results.add(result);
		}
		return results;*/
		return executor.invokeAny(tasks);
		//return factorialVaue;
		
	}
	
	public boolean isExecDone(int totalSubmittedTasks){
		return executor.getCompletedTaskCount() == totalSubmittedTasks; 
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

	public long getCompletedTaskCount() {
		
		return executor.getCompletedTaskCount();
	}
}
