/**
 * 
 */
package com.cleancode.tdd.checkout2;

/**
 * @author vsure
 *
 */
public class MultiSkuPromotion implements Promotion {

	private Integer promotionPrice;

	private Sku itemX;

	private Sku itemY;

	public MultiSkuPromotion(Sku itemX, Sku itemY, Integer promotionPrice) {
		this.promotionPrice = promotionPrice;
		this.itemX = itemX;
		this.itemY = itemY;
	}

	@Override
	public Integer applyAndReturnUpdatedTotal(Basket basket) {
		Integer computedValue = 0;

		while (isPositive(basket.getSku(itemX)) && isPositive(basket.getSku(itemY))) {
			basket.reduceByOne(itemX);
			basket.reduceByOne(itemY);
			computedValue += promotionPrice;
		}
		return computedValue;
	}

	private boolean isPositive(Integer count) {
		return count != null && count > 0;
	}

}
