/**
 * 
 */
package com.mytest.executors.lesson2_fixedSize_threadExecutor;

import java.util.Date;
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
		for (int i = 0; i < 10; i++) {
			Task task = new Task(new Date(), "Task-"+i);
			/*try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			server.executeTask(task);			
		}
		
		server.endServer();

	}

}
