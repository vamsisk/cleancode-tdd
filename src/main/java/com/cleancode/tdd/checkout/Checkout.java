package com.cleancode.tdd.checkout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

/**
 * @author vsure
 *
 */
public class Checkout extends Observable {

	private Map<String, ItemValue> items = new HashMap<String, ItemValue>();

	private Checkout(List<PriceRule> rules) {
		rules.forEach(rule -> {
			addObserver(rule);
		});
	}

	public static Checkout build(List<PriceRule> rules) {
		return new Checkout(rules);
	}

	private void addItem(String item) {
		if (!items.containsKey(item)) {
			items.put(item, new ItemValue(item));
		} else {
			items.get(item).addCount();
		}
	}

	public void scan(String item) {
		addItem(item);
		setChanged();
		notifyObservers(item);
	}

	public void clearChanged() {
		super.clearChanged();
	}

	public double total() {
		return items.values().stream().map(m -> m.getTotalPrice()).reduce(0.0, Double::sum);
	}

	public Map<String, ItemValue> getItems() {
		return items;
	}

}
