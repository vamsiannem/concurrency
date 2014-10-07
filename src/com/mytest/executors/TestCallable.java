/**
 * 
 */
package com.mytest.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author vamsikrishna
 *
 */
public class TestCallable<V> implements Callable<V> {

	private V v;
	
	@Override
	public V call() throws Exception {
		TimeUnit.SECONDS.sleep(10);
		return v;
	}

	/**
	 * @return the v
	 */
	public V getV() {
		return v;
	}

	/**
	 * @param v the v to set
	 */
	public void setV(V v) {
		this.v = v;
	}

}
