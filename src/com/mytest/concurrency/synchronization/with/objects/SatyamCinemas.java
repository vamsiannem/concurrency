/**
 * 
 */
package com.mytest.concurrency.synchronization.with.objects;

/**
 * @author vamsikrishna
 *
 */
public class SatyamCinemas {

	private final Object lockScreenOne;
	private final Object lockScreenTwo;
	private long ticketsScreenOne;
	private long ticketsScreenTwo;
			
	/**
	 * @param ticketsScreenOne
	 * @param ticketsScreenTwo
	 */
	public SatyamCinemas(long ticketsScreenOne, long ticketsScreenTwo) {
		super();
		lockScreenOne = new Object();
		lockScreenTwo = new Object();
		this.ticketsScreenOne = ticketsScreenOne;
		this.ticketsScreenTwo = ticketsScreenTwo;
	}
	/**
	 * @return the ticketsScreenOne
	 */
	public long getTicketsScreenOne() {
		return ticketsScreenOne;
	}
	/**
	 * @param ticketsScreenOne the ticketsScreenOne to set
	 */
	public void setTicketsScreenOne(long ticketsScreenOne) {
		this.ticketsScreenOne = ticketsScreenOne;
	}
	/**
	 * @return the ticketsScreenTwo
	 */
	public long getTicketsScreenTwo() {
		return ticketsScreenTwo;
	}
	/**
	 * @param ticketsScreenTwo the ticketsScreenTwo to set
	 */
	public void setTicketsScreenTwo(long ticketsScreenTwo) {
		this.ticketsScreenTwo = ticketsScreenTwo;
	}
	
	public boolean sellTicketsScreenOne(long numTickets){
		synchronized (lockScreenOne) {
			if(numTickets < ticketsScreenOne){
				ticketsScreenOne = ticketsScreenOne - numTickets;
				return true;
			}			
		}
		return false;
	}
	
	public boolean sellTicketsScreenTwo(long numTickets){
		synchronized (lockScreenTwo) {
			if(numTickets < ticketsScreenTwo){
				ticketsScreenTwo = ticketsScreenTwo - numTickets;
				return true;
			}			
		}
		return false;
	}
	
	public boolean returnTicketsScreenOne (long number){
		synchronized (lockScreenOne) {
			ticketsScreenOne += number;
			return true;
		}		
	}
	
	public boolean returnTicketsScreenTwo (long number){
		synchronized (lockScreenTwo) {
			ticketsScreenTwo += number;
			return true;
		}
	}
}
