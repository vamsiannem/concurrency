package com.mytest.concurrency.synchronization.with.objects;

public class TicketOffice implements Runnable {

	private SatyamCinemas movieComplex;
	
	/**
	 * @param movieComplex
	 */
	public TicketOffice(SatyamCinemas movieComplex) {
		super();
		this.movieComplex = movieComplex;
	}

	@Override
	public void run() {
		movieComplex.sellTicketsScreenOne(3);		
		movieComplex.sellTicketsScreenTwo(3);
		movieComplex.returnTicketsScreenOne(5);
		movieComplex.returnTicketsScreenTwo(2);
		/*movieComplex.sellTicketsScreenOne(0);
		movieComplex.sellTicketsScreenOne(-1);*/

	}
	

}
