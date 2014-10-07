/**
 * 
 */
package com.mytest.executors.lesson6_separate_launchtask_processresult;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author vamsikrishna
 *
 */
public class ReportGenerator implements Callable<String> {

	private String name;
	
	public ReportGenerator(String name){
		super();
		this.name = name;
	}
	
	@Override
	public String call() throws Exception {
		TimeUnit.SECONDS.sleep(6);
		return name;
	}

}
