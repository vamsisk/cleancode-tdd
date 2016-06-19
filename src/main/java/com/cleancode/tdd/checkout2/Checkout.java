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

	public void scan(Sku sku) {
		basket.addSku(sku);
	}

	public int total() {
		return basket.total();
	}
}
