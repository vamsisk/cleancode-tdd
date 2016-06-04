/**
 * 
 */
package com.cleancode.tdd.checkout;

/**
 * @author vsure
 *
 */
public class PriceRuleForA extends PriceRule {

	protected double promotionalPrice = 130;

	protected int promotionalItemCount = 3;

	protected Double applyRule(int count, double priceOfItem) {

		Double updatedValue = 0.0;

		int modCount = count % promotionalItemCount;

		updatedValue = (count / promotionalItemCount) * promotionalPrice;

		if (modCount != 0) {
			updatedValue += modCount * priceOfItem;
		}
		return updatedValue;
	}

	protected boolean isRuleApplicable(String sku) {
		return sku.equals("A");
	}

}
