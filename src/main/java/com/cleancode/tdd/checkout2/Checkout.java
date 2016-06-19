/**
 * 
 */
package com.cleancode.tdd.checkout2;

import java.util.List;

/**
 * @author vsure
 *
 */
public class Checkout {

	private Basket basket = new Basket();

	private Promotion promotion;

	public Checkout(Promotion promotion) {
		this.promotion = promotion;
	}

	public Checkout() {
		super();
	}

	public Basket getBasket() {
		return basket;
	}

	public void scan(Sku sku) {
		basket.addSku(sku);
	}
	
	public void scan(List<Sku> skus) {
		basket.addSku(skus);
	}

	public int total() {

		int total = 0;
		if (promotion != null) {
			total += promotion.applyAndReturnUpdatedTotal(this.getBasket());
		}

		total += basket.total();

		return total;
	}
}
