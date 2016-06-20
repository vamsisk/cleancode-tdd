/**
 * 
 */
package com.cleancode.tdd.checkout2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author vsure
 *
 */
public class Checkout {

	private Basket basket = new Basket();

	private List<Promotion> promotions = new ArrayList<Promotion>();

	public Checkout(Promotion promotion) {
		this.promotions.add(promotion);
	}

	public Checkout(Promotion... promotions) {
		this.promotions.addAll(Arrays.asList(promotions));
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

	public void scan(Sku... skus) {
		basket.addSku(Arrays.asList(skus));
	}

	public int total() {

		return promotions //
				.stream() //
				.mapToInt(promotion -> promotion.applyAndReturnUpdatedTotal(this.getBasket())) //
				.sum() + basket.total();

	}
}
