package com.cleancode.tdd.checkout2;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class CheckoutTest {

	@Test
	public void test_A() {
		Checkout checkout = new Checkout();

		checkout.scan("A");

		assertEquals("Total count is not matching expected.", 50, checkout.total());
	}

	@Test
	public void test_B() {
		Checkout checkout = new Checkout();

		checkout.scan("B");

		assertEquals("Total count is not matching expected.", 30, checkout.total());
	}

	@Test
	public void test_C() {
		Checkout checkout = new Checkout();

		checkout.scan("C");

		assertEquals("Total count is not matching expected.", 20, checkout.total());
	}

	@Test
	public void test_D() {
		Checkout checkout = new Checkout();

		checkout.scan("D");

		assertEquals("Total count is not matching expected.", 15, checkout.total());
	}
}
