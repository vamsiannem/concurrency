package com.mytest.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class KnowClasses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		//ExecutorService executorService;		
		//Runnable runnable = null;
		//Callable<Object> callable = Executors.callable(runnable);
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		
		DomainClass domainClass = new DomainClass("hello");
		
		TestCallable<DomainClass> doTestCallable = new TestCallable<>();
		doTestCallable.setV(domainClass);
		
		Future<DomainClass> futureTask = executor.submit(doTestCallable);
		DomainClass resp = null;
		try {
			System.out.println("Checking Started...");
			resp = futureTask.get(5, TimeUnit.SECONDS);			
			System.out.println("Checking finished...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
			futureTask.cancel(true);
		}
		if(resp !=null ){
			System.out.println(resp.getName());			
		} else {
			System.out.println("Future task timed out....");			
			System.out.println(futureTask.isDone());			
		}
		executor.shutdown();
		 
		
	}

}
