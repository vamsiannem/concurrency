/**
 * 
 */
package com.mytest.executors.lesson6_separate_launchtask_processresult;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
		ExecutorService service = Executors.newCachedThreadPool();
		CompletionService<String> completionService = new ExecutorCompletionService<>(service);
		ReportRequest req1 = new ReportRequest(completionService, "Test 1");
		ReportRequest req2 = new ReportRequest(completionService, "Test 2");
		Thread treq1 = new Thread(req1);
		Thread treq2 = new Thread(req2);

		ReportProcessor rp1 = new ReportProcessor(completionService);
		Thread trp= new Thread(rp1);
		treq1.start();
		treq2.start();
		trp.start();

		try {
			treq1.join();
			treq2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		service.shutdown();
		try {
			service.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		rp1.setEnd(true);
		System.out.println("Main Ends...");
		

	}

}
