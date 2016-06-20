/**
 * 
 */
package com.cleancode.tdd.checkout2;

import static com.cleancode.tdd.checkout2.Sku.A;
import static com.cleancode.tdd.checkout2.Sku.B;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author vsure
 *
 */
public class PromotionTest {

	@Test
	public void returnPromotionPriceIf_sku_count_Matches_For_4_SkuB() {
		Promotion promotion = new Promotion(Sku.B, 2, 45);

		Checkout checkout = new Checkout(promotion);
		checkout.scan(B, B, B, B);

		Assert.assertThat(90, is(promotion.applyAndReturnUpdatedTotal(checkout.getBasket())));
	}

	@Test
	public void returnPromotionPriceIf_sku_count_Matches_For_3_SkuB() {
		Promotion promotion = new Promotion(Sku.B, 2, 45);

		Checkout checkout = new Checkout(promotion);
		checkout.scan(B, B, B);

		Assert.assertThat(75, is(promotion.applyAndReturnUpdatedTotal(checkout.getBasket())));
	}

	@Test
	public void returnPromotionPriceIf_sku_count_Matches_For_2_SkuB() {
		Promotion promotion = new Promotion(Sku.B, 2, 45);

		Checkout checkout = new Checkout(promotion);
		checkout.scan(B, B);

		Assert.assertThat(45, is(promotion.applyAndReturnUpdatedTotal(checkout.getBasket())));
	}

	@Test
	public void returnPromotionPriceIf_sku_count_Matches_For_1_SkuB() {
		Promotion promotion = new Promotion(Sku.B, 2, 45);

		Checkout checkout = new Checkout(promotion);
		checkout.scan(B);

		Assert.assertThat(30, is(promotion.applyAndReturnUpdatedTotal(checkout.getBasket())));
	}

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
	public void returnPromotionPriceIfMathces7ForSkuAAndSumOnActualPriceForRemainingItemsOfA() {
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