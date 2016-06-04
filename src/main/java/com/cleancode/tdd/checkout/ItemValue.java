package com.cleancode.tdd.checkout;

public class ItemValue {

	private SkuPrice skuPrice = new SkuPrice();

	private Double totalPrice;

	private int count;

	private String sku;

	public Double getTotalPrice() {
		return totalPrice;
	}

	public ItemValue(String sku) {
		this.sku = sku;
		this.totalPrice = skuPrice.price(sku);
		this.count++;
	}

	public void setTotalPrice(Double price) {
		this.totalPrice = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void addCount() {
		this.count++;
		this.totalPrice += skuPrice.price(sku);
	}
	
	public SkuPrice getSkuPrice() {
		return skuPrice;
	}

	@Override
	public String toString() {
		return "ItemValue [totalPrice=" + totalPrice + ", count=" + count + ", sku=" + sku + "]";
	}

}
