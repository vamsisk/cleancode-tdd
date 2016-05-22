package com.cleancode.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberToTextTest {

	private NumberToText numberToText = new NumberToText();

	@Test
	public void testSingleDigitNumberSeven() {
		String text = numberToText.getText(7);

		assertEquals("Seven", text);
	}

	@Test
	public void testDoubleDigitNumberSeventeen() {
		String text = numberToText.getText(17);

		assertEquals("Seventeen", text);
	}

	@Test
	public void testDoubleDigitNumberSixtyEight() {
		String text = numberToText.getText(68);

		assertEquals("Sixty Eight", text);
	}

	@Test
	public void testDoubleDigitNumberNinetyNine() {
		String text = numberToText.getText(99);

		assertEquals("Ninety Nine", text);
	}

	@Test
	public void testDoubleDigitNumberTwenty() {
		String text = numberToText.getText(20);

		assertEquals("Twenty", text);
	}
}
