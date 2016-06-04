package com.cleancode.tdd.checkout;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cleancode.tdd.PriceRule;

public class CheckoutTest {

	private List<PriceRule> rules = new ArrayList<PriceRule>();

	@Before
	public void initializeRules() {
		rules.add(new PriceRule());
	}

	public double price(String goods) {
		Checkout checkout = Checkout.build(rules);

		goods.chars().mapToObj(i -> (char) i).forEach(item -> {
			checkout.scan(String.valueOf(item));
		});

		return checkout.total();
	}

	@Test
	public void test_threeitems_without_rules_success() {
		assertEquals(Double.parseDouble("50"), price("A"), 0);
		assertEquals(Double.parseDouble("100"), price("ABC"), 0);
		assertEquals(Double.parseDouble("150"), price("AAA"), 0);
	}
}
