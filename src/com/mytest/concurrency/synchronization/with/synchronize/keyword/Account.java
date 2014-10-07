/**
 * 
 */
package com.mytest.concurrency.synchronization.with.synchronize.keyword;

import java.util.concurrent.TimeUnit;

/**
 * @author vamsikrishna
 *
 */
public class Account {
	
	
	private double balance;
	

	/**
	 * @param balance
	 */
	public Account(double balance) {
		super();
		this.balance = balance;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public synchronized void addAmount(double amt){		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		this.balance += amt;		
	}

	public synchronized void subtractAmt(double amt) {
		/*if(amt > balance){
			throw new Throwable("You do not have sufficient funds!");
		}*/
		double tmp = balance;
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		tmp -= amt;
		balance = tmp;		 
		
	}

}
