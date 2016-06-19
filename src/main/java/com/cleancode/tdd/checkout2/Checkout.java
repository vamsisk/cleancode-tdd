/**
 * 
 */
package com.cleancode.tdd.checkout2;

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

	public int total() {

		int total = 0;
		if (promotion != null) {
			promotion.applyAndReturnUpdatedTotal(this.getBasket());
		}

		total = basket.total();

		return total;
	}
}
