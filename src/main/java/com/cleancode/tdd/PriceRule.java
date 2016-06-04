/**
 * 
 */
package com.cleancode.tdd;

import java.util.Observable;
import java.util.Observer;

import com.cleancode.tdd.checkout.Checkout;

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
		Checkout checkout = ((Checkout) o);
		checkout.clearChanged();
		System.out.println(arg);
	}

}
