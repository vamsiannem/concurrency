package com.mytest.executors.lesson1;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	private Date initDate;
	private String name;
	
	/**
	 * @param initDate
	 * @param name
	 */
	public Task(Date initDate, String name) {
		super();
		this.initDate = initDate;
		this.name = name;
	}

	@Override
	public void run() {
		System.out.printf("Thread: %s, Task: %s, Created on: %s \n"
				, Thread.currentThread().getName(), name, initDate);
		System.out.printf("Thread: %s, Task: %s, Started on: %s \n"
				, Thread.currentThread().getName(), name, new Date());
		try{
			Long duration=(long)(Math.random()*10);	
			System.out.printf("Thread: %s, Task: %s, Executing for: %s \n"
					, Thread.currentThread().getName(), name, duration);	
			TimeUnit.SECONDS.sleep(duration);
		} catch(InterruptedException ie){
			System.out.println(ie);
		}
		System.out.printf("Thread: %s, Task: %s, Finished on: %s \n"
				, Thread.currentThread().getName(), name, new Date());
	}

	/**
	 * @return the initDate
	 */
	public Date getInitDate() {
		return initDate;
	}

	/**
	 * @param initDate the initDate to set
	 */
	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
