/**
 * 
 */
package com.mytest.concurrency.synchronization.with.synchronize.keyword;

/**
 * @author vamsikrishna
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Account account = new Account(1000);
		Bank atm  = new Bank(account);
		CompanyLister salCompanyLister = new CompanyLister(account);
		Thread atmThread = new Thread(atm);
		Thread companyThread = new Thread(salCompanyLister);
		System.out.println("Initial Balance: "+account.getBalance());
		atmThread.start();
		companyThread.start();
		
		try {
			atmThread.join();
			companyThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Final Balance: "+account.getBalance());

	}

}
