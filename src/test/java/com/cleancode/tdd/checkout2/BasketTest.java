package com.cleancode.tdd.checkout2;

import static com.cleancode.tdd.checkout2.Sku.A;
import static com.cleancode.tdd.checkout2.Sku.B;
import static com.cleancode.tdd.checkout2.Sku.C;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

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

	@Test
	public void testMultiAddOfSkus() {
		Basket basket = new Basket();
		basket.addSku(asList(A, B, C, A));
		assertThat(2, is(basket.getSku(A)));
		assertThat(1, is(basket.getSku(B)));
		assertThat(1, is(basket.getSku(C)));
	}
}
