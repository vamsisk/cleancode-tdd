package com.cleancode.tdd.checkout;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.cleancode.tdd.PriceRule;

/**
 * @author vsure
 *
 */
public class Checkout extends Observable {

	private List<String> items = new ArrayList<String>();

	private SkuPrice skuPrice = new SkuPrice();

	private double total = 0.00;

	private Checkout(List<PriceRule> rules) {
		rules.forEach(rule -> {
			addObserver(rule);
		});
	}

	public static Checkout build(List<PriceRule> rules) {
		return new Checkout(rules);
	}

	public void scan(String item) {
		items.add(item);
		total += skuPrice.price(item);
		setChanged();
		notifyObservers(item);
		clearChanged();
	}

	public double total() {
		return total;
	}
}
