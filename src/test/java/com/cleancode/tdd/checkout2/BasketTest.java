package com.cleancode.tdd.checkout2;

import static com.cleancode.tdd.checkout2.Sku.A;
import static org.junit.Assert.assertSame;

import org.junit.Test;


public class BasketTest {

	@Test
	public void testResetCounterForBasketForASku() {
		Basket basket = new Basket();
		basket.addSku(A);
		basket.addSku(A);
		basket.addSku(A);
		assertSame(3, basket.getSku(A));
		basket.resetItemCountFor(A);
		assertSame(0, basket.getSku(A));
	}
}
