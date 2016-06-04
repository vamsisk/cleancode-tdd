package com.cleancode.tdd.checkout;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CheckoutTest {

	private List<PriceRule> rules = new ArrayList<PriceRule>();

	@Before
	public void initializeRules() {
		rules.add(new PriceRuleForA());
		rules.add(new PriceRuleForB());
	}

	public double price(String goods) {
		Checkout checkout = Checkout.build(rules);

		goods.chars().mapToObj(i -> (char) i).forEach(item -> {
			checkout.scan(String.valueOf(item));
		});

		return checkout.total();
	}

	@Test
	public void test_bulkitems_success() {
		assertEquals(Double.parseDouble("0"), price(""), 0);
		assertEquals(Double.parseDouble("50"), price("A"), 0);
		assertEquals(Double.parseDouble("100"), price("ABC"), 0);
		assertEquals(Double.parseDouble("130"), price("AAA"), 0);
		assertEquals(Double.parseDouble("180"), price("AAAA"), 0);
		assertEquals(Double.parseDouble("230"), price("AAAAA"), 0);
		assertEquals(Double.parseDouble("260"), price("AAAAAA"), 0);

		assertEquals(Double.parseDouble("30"), price("B"), 0);
		assertEquals(Double.parseDouble("45"), price("BB"), 0);
		assertEquals(Double.parseDouble("75"), price("BBB"), 0);
	}

	@Test
	public void test_incremental_success() {
		Checkout checkout = Checkout.build(rules);
		checkout.scan("A");
		assertEquals(Double.parseDouble("50"), checkout.total(), 0);
		checkout.scan("B");
		assertEquals(Double.parseDouble("80"), checkout.total(), 0);
		checkout.scan("A");
		assertEquals(Double.parseDouble("130"), checkout.total(), 0);
		checkout.scan("A");
		assertEquals(Double.parseDouble("160"), checkout.total(), 0);
		checkout.scan("B");
		assertEquals(Double.parseDouble("175"), checkout.total(), 0);
	}

}
