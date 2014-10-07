package com.mytest.executors.lesson3_with_results;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator implements Callable<Integer> {
	
	private int number;
		
	
	/**
	 * @param number
	 */
	public FactorialCalculator(int number) {
		super();
		this.number = number;
	}



	@Override
	public Integer call() throws Exception {				
		return fact(number);
	}
	
	private int fact(int n){
		if(n > 1 )
			return n*fact(n-1);
		else {
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 1;
		}
	}

}
