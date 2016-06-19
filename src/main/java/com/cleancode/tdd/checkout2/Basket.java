package com.cleancode.tdd.checkout2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {

	private Map<Sku, Integer> skus = new HashMap<Sku, Integer>();

	public void addSku(Sku sku) {
		skus.compute(sku, (key, value) -> value == null ? 1 : value + 1);
	}

	public void addSku(List<Sku> skus) {
		skus.forEach(this::addSku);
	}

	public Map<Sku, Integer> getSkus() {
		return skus;
	}

	public boolean contains(Sku sku) {
		return skus.containsKey(sku);
	}

	public Integer getSku(Sku sku) {
		return skus.get(sku);
	}

	public void resetItemCountFor(Sku sku) {
		skus.computeIfPresent(sku, (k, v) -> 0);
	}

	public int total() {
		return skus.keySet().stream().mapToInt(sku -> sku.price() * skus.get(sku)).sum();
	}

}
