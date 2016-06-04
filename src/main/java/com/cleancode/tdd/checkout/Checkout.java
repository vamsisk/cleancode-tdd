package com.cleancode.tdd.checkout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vsure
 *
 */
public class Checkout {

	private List<String> items = new ArrayList<String>();

	private SkuPrice skuPrice = new SkuPrice();

	private double total = 0.00;

	private Checkout() {

	}

	public static Checkout build() {
		return new Checkout();
	}

	public void scan(String item) {
		items.add(item);
		total += skuPrice.price(item);
	}

	public double total() {
		return total;
	}
}
