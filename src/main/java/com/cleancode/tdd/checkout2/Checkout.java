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

	public void scan(String item) {
		this.total += getPrice(item);
	}

	public int total() {
		return total;
	}

	private int getPrice(String item) {
		if (item.equals("A")) {
			return 50;
		} else if (item.equals("B")) {
			return 30;
		} else if (item.equals("C")) {
			return 20;
		} else if (item.equals("D")) {
			return 15;
		}

		return 0;
	}
}
