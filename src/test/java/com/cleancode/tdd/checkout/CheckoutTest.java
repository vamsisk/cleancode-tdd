package com.cleancode.tdd.checkout;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CheckoutTest {

	public double price(String goods) {
		Checkout checkout = Checkout.build();

		goods.chars().mapToObj(i -> (char) i).forEach(item -> {
			checkout.scan(String.valueOf(item));
		});

		return checkout.total();
	}

	@Test
	public void test_threeitems_without_rules_success() {
		assertEquals(Double.parseDouble("50"), price("A"), 0);
		assertEquals(Double.parseDouble("100"), price("ABC"), 0);
		assertEquals(Double.parseDouble("150"), price("AAA"), 0);
	}
}
