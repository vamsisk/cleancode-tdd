package com.cleancode.tdd.checkout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import com.cleancode.tdd.PriceRule;

/**
 * @author vsure
 *
 */
public class Checkout extends Observable {

	private Map<String, Double> items = new HashMap<String, Double>();

	private SkuPrice skuPrice = new SkuPrice();

	private Checkout(List<PriceRule> rules) {
		rules.forEach(rule -> {
			addObserver(rule);
		});
	}

	public static Checkout build(List<PriceRule> rules) {
		return new Checkout(rules);
	}

	private void addItem(String item) {
		Double updatedValue = skuPrice.price(item);
		if (items.containsKey(item)) {
			updatedValue += items.get(item);
		}
		items.put(item, updatedValue);
	}

	public void scan(String item) {
		addItem(item);
		setChanged();
		notifyObservers(items);
	}

	public void clearChanged() {
		super.clearChanged();
	}

	public double total() {
		return items.values().stream().reduce(0.0, Double::sum);
	}
}
