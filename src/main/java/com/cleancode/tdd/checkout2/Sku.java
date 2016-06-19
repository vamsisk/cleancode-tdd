package com.cleancode.tdd.checkout2;

public enum Sku {

	A(50), B(30), C(20), D(15);

	private int price;

	private Sku(int price) {
		this.price = price;
	}

	public int price() {
		return price;
	}
}
