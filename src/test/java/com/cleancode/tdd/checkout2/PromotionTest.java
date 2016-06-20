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
		MultiItemPromotion multiItemPromotion = new MultiItemPromotion(Sku.B, 2, 45);

		Checkout checkout = new Checkout(multiItemPromotion);
		checkout.scan(B, B, B, B);

		Assert.assertThat(90, is(multiItemPromotion.applyAndReturnUpdatedTotal(checkout.getBasket())));
	}

	@Test
	public void returnPromotionPriceIf_sku_count_Matches_For_3_SkuB() {
		MultiItemPromotion multiItemPromotion = new MultiItemPromotion(Sku.B, 2, 45);

		Checkout checkout = new Checkout(multiItemPromotion);
		checkout.scan(B, B, B);

		Assert.assertThat(75, is(multiItemPromotion.applyAndReturnUpdatedTotal(checkout.getBasket())));
	}

	@Test
	public void returnPromotionPriceIf_sku_count_Matches_For_2_SkuB() {
		MultiItemPromotion multiItemPromotion = new MultiItemPromotion(Sku.B, 2, 45);

		Checkout checkout = new Checkout(multiItemPromotion);
		checkout.scan(B, B);

		Assert.assertThat(45, is(multiItemPromotion.applyAndReturnUpdatedTotal(checkout.getBasket())));
	}

	@Test
	public void returnPromotionPriceIf_sku_count_Matches_For_1_SkuB() {
		MultiItemPromotion multiItemPromotion = new MultiItemPromotion(Sku.B, 2, 45);

		Checkout checkout = new Checkout(multiItemPromotion);
		checkout.scan(B);

		Assert.assertThat(30, is(multiItemPromotion.applyAndReturnUpdatedTotal(checkout.getBasket())));
	}

	@Test
	public void returnPromotionPriceIfMathces3ForSkuA() {
		MultiItemPromotion multiItemPromotion = new MultiItemPromotion(Sku.A, 3, 130);

		Checkout checkout = new Checkout(multiItemPromotion);
		checkout.scan(A);

		Assert.assertThat(50, is(multiItemPromotion.applyAndReturnUpdatedTotal(checkout.getBasket())));
	}

	@Test
	public void returnPromotionPriceIfMathces3ForSkuAAndSumOnActualPriceForRemainingItemsOfA() {
		MultiItemPromotion multiItemPromotion = new MultiItemPromotion(Sku.A, 3, 130);

		Checkout checkout = new Checkout(multiItemPromotion);
		checkout.scan(A);
		checkout.scan(A);
		checkout.scan(A);
		checkout.scan(A);

		Assert.assertThat(180, is(multiItemPromotion.applyAndReturnUpdatedTotal(checkout.getBasket())));
	}

	@Test
	public void returnPromotionPriceIfMathces7ForSkuAAndSumOnActualPriceForRemainingItemsOfA() {
		MultiItemPromotion multiItemPromotion = new MultiItemPromotion(Sku.A, 3, 130);

		Checkout checkout = new Checkout(multiItemPromotion);
		checkout.scan(A);
		checkout.scan(A);
		checkout.scan(A);
		checkout.scan(A);
		checkout.scan(A);
		checkout.scan(A);
		checkout.scan(A);

		Assert.assertThat(310, is(multiItemPromotion.applyAndReturnUpdatedTotal(checkout.getBasket())));
	}
}