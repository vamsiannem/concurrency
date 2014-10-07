/**
 * 
 */
package com.mytest.concurrency.synchronization.with.synchronize.keyword;

/**
 * @author vamsikrishna
 *
 */
public class CompanyLister implements Runnable {
	
	private Account account;
	
	
	public CompanyLister(Account account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			account.addAmount(1000);
		}
		
	}

}
