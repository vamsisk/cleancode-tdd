/**
 * 
 */
package com.cleancode.tdd.checkout;

import java.util.Observable;
import java.util.Observer;

/**
 * @author vsure
 *
 */
public abstract class PriceRule implements Observer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		String item = (String) arg;

		if (!isRuleApplicable(item)) {
			return;
		}

		Checkout checkout = ((Checkout) o);
		ItemValue itemValue = checkout.getItems().get(item);

		int count = itemValue.getCount();
		Double priceOfItem = itemValue.getSkuPrice().price(item);

		itemValue.setTotalPrice(applyRule(count, priceOfItem));

		checkout.clearChanged();
	}

	protected abstract boolean isRuleApplicable(String sku);

	protected abstract Double applyRule(int count, double priceOfItem);
}
