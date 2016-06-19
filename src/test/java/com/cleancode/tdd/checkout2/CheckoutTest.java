package com.cleancode.tdd.checkout2;

import static com.cleancode.tdd.checkout2.Sku.A;
import static com.cleancode.tdd.checkout2.Sku.B;
import static com.cleancode.tdd.checkout2.Sku.C;
import static com.cleancode.tdd.checkout2.Sku.D;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CheckoutTest {

	@Test
	public void test_3ItemsOfAFor130_promotion() {
		Checkout checkout = new Checkout();

		checkout.scan(A);
		checkout.scan(A);
		checkout.scan(A);

		assertEquals("Total count is not matching expected.", 150, checkout.total());
	}

	@Test
	public void test_AB() {
		Checkout checkout = new Checkout();

		checkout.scan(A);
		checkout.scan(B);

		assertEquals("Total count is not matching expected.", 80, checkout.total());
	}

	@Test
	public void test_ABCD() {
		Checkout checkout = new Checkout();

		checkout.scan(A);
		checkout.scan(B);
		checkout.scan(C);
		checkout.scan(D);

		assertEquals("Total count is not matching expected.", 115, checkout.total());
	}

	@Test
	public void test_A() {
		Checkout checkout = new Checkout();

		checkout.scan(A);

		assertEquals("Total count is not matching expected.", 50, checkout.total());
	}

	@Test
	public void test_B() {
		Checkout checkout = new Checkout();

		checkout.scan(B);

		assertEquals("Total count is not matching expected.", 30, checkout.total());
	}

	@Test
	public void test_C() {
		Checkout checkout = new Checkout();

		checkout.scan(C);

		assertEquals("Total count is not matching expected.", 20, checkout.total());
	}

	@Test
	public void test_D() {
		Checkout checkout = new Checkout();

		checkout.scan(D);

		assertEquals("Total count is not matching expected.", 15, checkout.total());
	}
}
