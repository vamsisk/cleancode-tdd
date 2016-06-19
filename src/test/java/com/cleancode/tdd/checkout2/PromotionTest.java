/**
 * 
 */
package com.cleancode.tdd.checkout2;

import static com.cleancode.tdd.checkout2.Sku.A;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author vsure
 *
 */
public class PromotionTest {

	@Test
	public void returnPromotionPriceIfMathces3ForSkuA() {
		Promotion promotion = new Promotion(Sku.A, 3, 130);

		Checkout checkout = new Checkout(promotion);
		checkout.scan(A);

		Assert.assertThat(50, is(promotion.applyAndReturnUpdatedTotal(checkout.getBasket())));
	}

	@Test
	public void returnPromotionPriceIfMathces3ForSkuAAndSumOnActualPriceForRemainingItemsOfA() {
		Promotion promotion = new Promotion(Sku.A, 3, 130);

		Checkout checkout = new Checkout(promotion);
		checkout.scan(A);
		checkout.scan(A);
		checkout.scan(A);
		checkout.scan(A);

		Assert.assertThat(180, is(promotion.applyAndReturnUpdatedTotal(checkout.getBasket())));
	}

	@Test
	public void returnPromotionPriceIfMathces6ForSkuAAndSumOnActualPriceForRemainingItemsOfA() {
		Promotion promotion = new Promotion(Sku.A, 3, 130);

		Checkout checkout = new Checkout(promotion);
		checkout.scan(A);
		checkout.scan(A);
		checkout.scan(A);
		checkout.scan(A);
		checkout.scan(A);
		checkout.scan(A);
		checkout.scan(A);

		Assert.assertThat(310, is(promotion.applyAndReturnUpdatedTotal(checkout.getBasket())));
	}
}