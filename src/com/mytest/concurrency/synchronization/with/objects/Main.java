/**
 * 
 */
package com.mytest.concurrency.synchronization.with.objects;

/**
 * @author vamsikrishna
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SatyamCinemas sc = new SatyamCinemas(10, 10);
		TicketOffice ticketOffice = new TicketOffice(sc);
		TicketOffice ticketOffice2 = new TicketOffice(sc);
		Thread offThread = new Thread(ticketOffice);
		Thread offThread2 = new Thread(ticketOffice2);
		System.out.println("Initial Tickets Count at ScreenOne:"+sc.getTicketsScreenOne()+", Screen Two:"+ sc.getTicketsScreenTwo());		
		offThread.start();
		offThread2.start();
		try {
			offThread.join();
			offThread2.join();
			System.out.println("Final Tickets Count at ScreenOne:"+sc.getTicketsScreenOne()+", Screen Two:"+ sc.getTicketsScreenTwo());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
