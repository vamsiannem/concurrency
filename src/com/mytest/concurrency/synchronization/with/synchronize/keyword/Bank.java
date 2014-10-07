/**
 * 
 */
package com.mytest.concurrency.synchronization.with.synchronize.keyword;

/**
 * @author vamsikrishna
 *
 */
public class Bank implements Runnable{

	private Account account;

	public Bank(Account account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			account.subtractAmt(1000);
		}
		
	}
	
}
