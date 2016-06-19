/**
 * 
 */
package com.cleancode.tdd.checkout2;

/**
 * @author vsure
 *
 */
public class Checkout {

	private int total;

	public void scan(Sku sku) {
		this.total += sku.price();
	}

	public int total() {
		return total;
	}
}
