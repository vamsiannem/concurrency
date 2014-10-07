/**
 * 
 */
package com.mytest.executors.lesson3_with_results;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author vamsikrishna
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Server server = new Server();
		List<Callable<Integer>> tasks = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			FactorialCalculator fc= new FactorialCalculator(i+1);			
			tasks.add(fc);
		}
		List<Future<Integer>> resultList = null;
		try {
			resultList = server.executeCallables(tasks);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(!server.isExecDone(10)){
			System.out.printf("Main: Number of Completed Tasks: %d\n",server.getCompletedTaskCount());
			int i=0;
			for (Iterator iterator = resultList.iterator(); iterator.hasNext();) {
				Future<Integer> result = (Future<Integer>) iterator.next();
				System.out.printf("Main: Task %d: %s\n",i++, result.isDone());				
			}
		}
		System.out.printf("Main: Results\n");
		for (int i=0; i < resultList.size(); i++) {
			Future<Integer> result = resultList.get(i);
			Integer number = null;
			try {
				number=result.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (CancellationException ce){
				
			}
			System.out.printf("Main: Task %d: %d\n",i,number);

		}



		server.endServer();

	}

}
