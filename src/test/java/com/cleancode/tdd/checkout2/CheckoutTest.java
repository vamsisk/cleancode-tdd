package com.cleancode.tdd.checkout2;

import static com.cleancode.tdd.checkout2.Sku.A;
import static com.cleancode.tdd.checkout2.Sku.B;
import static com.cleancode.tdd.checkout2.Sku.C;
import static com.cleancode.tdd.checkout2.Sku.D;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CheckoutTest {

	@Test
	public void test_MultiSku_Promotion_ForAandB_Including_IndividualPromotionFor_AandB() {
		Checkout checkout = new Checkout(new MultiSkuPromotion(A, B, 5), new MultiItemPromotion(Sku.A, 3, 130),
				new MultiItemPromotion(Sku.B, 2, 45));

		checkout.scan(A, B, B, A, C, D, B, B, A, A, A);

		assertEquals("Total count is not matching expected.", (45 + 10 + 50), checkout.total());
	}

	@Test
	public void test_MultiSku_Promotion_ForAandB_Including_IndividualPromotionFor_B() {
		Checkout checkout = new Checkout(new MultiSkuPromotion(A, B, 5), new MultiItemPromotion(Sku.A, 3, 130),
				new MultiItemPromotion(Sku.B, 2, 45));

		checkout.scan(A, B, B, A, C, D, B, B);

		assertEquals("Total count is not matching expected.", (90), checkout.total());
	}

	@Test
	public void test_MultiSku_Promotion_ForAandB_Including_Individual_Items() {
		Checkout checkout = new Checkout(new MultiSkuPromotion(A, B, 5), new MultiItemPromotion(Sku.A, 3, 130),
				new MultiItemPromotion(Sku.B, 2, 45));

		checkout.scan(A, B, B, C, A, D, A);

		assertEquals("Total count is not matching expected.", (10 + 20 + 15 + 50), checkout.total());
	}

	@Test
	public void testPromotionsA_and_B_IncludingSingleItems() {
		Checkout checkout = new Checkout(new MultiItemPromotion(Sku.A, 3, 130), new MultiItemPromotion(Sku.B, 2, 45));

		checkout.scan(A, B, A, C, D, A, B);

		assertEquals("Total count is not matching expected.", (210), checkout.total());
	}

	@Test
	public void testPromotionAIncludingSingleItemsUsingMultiitemScan() {
		Checkout checkout = new Checkout(new MultiItemPromotion(Sku.A, 3, 130));

		checkout.scan(A, B, A, C, D, A);

		assertEquals("Total count is not matching expected.", (195), checkout.total());
	}

	@Test
	public void testPromotionAIncludingSingleItems() {
		Checkout checkout = new Checkout(new MultiItemPromotion(Sku.A, 3, 130));

		checkout.scan(A);
		checkout.scan(B);
		checkout.scan(A);
		checkout.scan(C);
		checkout.scan(D);
		checkout.scan(A);

		assertEquals("Total count is not matching expected.", (195), checkout.total());
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
