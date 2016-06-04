package com.cleancode.tdd.checkout;

import java.util.HashMap;
import java.util.Map;

public class SkuPrice {

	private Map<String, Double> prices = new HashMap<String, Double>();

	public SkuPrice() {
		prices.put("A", Double.valueOf(50));
		prices.put("B", Double.valueOf(30));
		prices.put("C", Double.valueOf(20));
		prices.put("D", Double.valueOf(25));
	}

	public Double price(String item) {
		return prices.get(item);
	}

}
