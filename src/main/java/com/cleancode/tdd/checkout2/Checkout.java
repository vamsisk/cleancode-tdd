/**
 * 
 */
package com.cleancode.tdd.checkout2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author vsure
 *
 */
public class Checkout {

	private Basket basket = new Basket();

	private List<MultiItemPromotion> multiItemPromotions = new ArrayList<MultiItemPromotion>();

	public Checkout(MultiItemPromotion multiItemPromotion) {
		this.multiItemPromotions.add(multiItemPromotion);
	}

	public Checkout(MultiItemPromotion... promotions) {
		this.multiItemPromotions.addAll(Arrays.asList(promotions));
	}

	public Checkout() {
		super();
	}

	public Basket getBasket() {
		return basket;
	}

	public void scan(Sku sku) {
		basket.addSku(sku);
	}

	public void scan(Sku... skus) {
		basket.addSku(Arrays.asList(skus));
	}

	public int total() {

		return multiItemPromotions //
				.stream() //
				.mapToInt(promotion -> promotion.applyAndReturnUpdatedTotal(this.getBasket())) //
				.sum() + basket.total();

	}
}
