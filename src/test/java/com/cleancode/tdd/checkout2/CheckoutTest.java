package com.cleancode.tdd.checkout2;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class CheckoutTest {

	@Test
	public void test_A() {
		Checkout checkout = new Checkout();

		checkout.scan("A");

		assertEquals("Total count is not matching expected.", 50, checkout.total());
	}
}
