package com.cleancode.tdd.checkout2;

import java.util.HashMap;
import java.util.Map;

public class Basket {

	private Map<Sku, Integer> skus = new HashMap<Sku, Integer>();

	public void addSku(Sku sku) {
		skus.compute(sku, (key, value) -> value == null ? 1 : value + 1);
	}

	public int total() {
		return skus.keySet().stream().mapToInt(sku -> sku.price() * skus.get(sku)).sum();
	}

}
