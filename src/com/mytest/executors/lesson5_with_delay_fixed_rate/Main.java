/**
 * 
 */
package com.mytest.executors.lesson5_with_delay_fixed_rate;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author vamsikrishna
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Server server = new Server();
		Task task = new Task(new Date(), "Task-0"+ Math.random()*10);
		/*try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}*/
		ScheduledFuture<?> result = server.executeTask(task);
		for (int i=0; i< 50; i++){
			System.out.printf("Main: Delay: %d\n",result.getDelay(TimeUnit.MILLISECONDS));			
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		
		server.endServer();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("Main: Ends at: %s\n",new Date());
	}

}
