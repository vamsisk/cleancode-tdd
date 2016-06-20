package com.cleancode.tdd.checkout2;

public class MultiItemPromotion {

	private Sku sku;
	private Integer count;
	private Integer promotionPrice;

	public MultiItemPromotion(Sku sku, Integer count, Integer promotionPrice) {
		this.sku = sku;
		this.count = count;
		this.promotionPrice = promotionPrice;
	}

	public Sku getSku() {
		return sku;
	}

	public Integer getCount() {
		return count;
	}

	public Integer getPromotionPrice() {
		return promotionPrice;
	}

	public Integer applyAndReturnUpdatedTotal(Basket basket) {
		int total = 0;

		if (basket.contains(sku)) {
			Integer skuCount = basket.getSku(sku);

			total = ((skuCount / count) * promotionPrice) + (skuCount % count * sku.price());

			basket.resetItemCountFor(sku);
		}

		return total;
	}

}
