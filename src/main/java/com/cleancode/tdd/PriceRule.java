/**
 * 
 */
package com.cleancode.tdd;

import java.util.Observable;
import java.util.Observer;

/**
 * @author vsure
 *
 */
public class PriceRule implements Observer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(arg);
	}

}
