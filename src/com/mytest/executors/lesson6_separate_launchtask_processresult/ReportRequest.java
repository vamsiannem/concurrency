/**
 * 
 */
package com.mytest.executors.lesson6_separate_launchtask_processresult;

import java.util.concurrent.CompletionService;

/**
 * @author vamsikrishna
 *
 */
public class ReportRequest implements Runnable {
	
	private CompletionService<String> service;	
	private String name;
	
	public ReportRequest(CompletionService<String> completionService, String name){
		super();
		this.service = completionService;
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		ReportGenerator repGen = new ReportGenerator(name);
		service.submit(repGen);
	}

}
