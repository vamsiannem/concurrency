/**
 * 
 */
package com.mytest.executors.lesson6_separate_launchtask_processresult;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author vamsikrishna
 *
 */
public class ReportProcessor implements Runnable {

	private CompletionService<String> completionService;
	boolean end ;
	
	/**
	 * @return the end
	 */
	public boolean isEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(boolean end) {
		this.end = end;
	}

	public ReportProcessor(CompletionService<String> service){
		super();
		this.completionService = service;
		end = false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while(!end){
			try{
				Future<String> result = completionService.poll();
				if(result != null){
					String report = result.get();
					System.out.printf("ReportReceiver: Report Received: %s\n",report);

				}
			} catch (InterruptedException | ExecutionException ie){
				ie.printStackTrace();
			}
			
		}	
		System.out.printf("ReportSender: End\n");
	}

}
