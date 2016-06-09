/**
 * 
 */
package com.cleancode.tdd.checkout2;

/**
 * @author vsure
 *
 */
public class Checkout {

	public String item;

	public void scan(String item) {
		this.item = item;
	}

	public int total() {
		if (item.equals("A")) {
			return 50;
		} else if (item.equals("B")) {
			return 30;
		}

		return 0;
	}
}
