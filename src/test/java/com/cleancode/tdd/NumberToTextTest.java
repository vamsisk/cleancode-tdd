package com.cleancode.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberToTextTest {

	private NumberToText numberToText = new NumberToText();

	@Test
	public void testThreeThreeThreeThreeFiveNineTwoFourEightFive() {
		String text = numberToText.getText(3333592485L);

		assertEquals(
				"Three Billion Three Hundred Thirty Three Million Five Hundred Ninety Two Thousand Four Hundred Eighty Five",
				text);
	}

	@Test
	public void testThreeFiveNineTwoFourEight() {
		String text = numberToText.getText(359248);

		assertEquals("Three Hundred Fifty Nine Thousand Two Hundred Forty Eight", text);
	}

	@Test
	public void testThreeFiveNineTwoFour() {
		String text = numberToText.getText(35924);

		assertEquals("Thirty Five Thousand Nine Hundred Twenty Four", text);
	}

	@Test
	public void testFourDigitsThreeFiveNineTwo() {
		String text = numberToText.getText(3592);

		assertEquals("Three Thousand Five Hundred Ninety Two", text);
	}

	@Test
	public void testTripleDigitNineNineNine() {
		String text = numberToText.getText(999);

		assertEquals("Nine Hundred Ninety Nine", text);
	}

	@Test
	public void testTripleDigitSevenThirtyNine() {
		String text = numberToText.getText(739);

		assertEquals("Seven Hundred Thirty Nine", text);
	}

	@Test
	public void testTripleDigitOneFortySix() {
		String text = numberToText.getText(146);

		assertEquals("One Hundred Forty Six", text);
	}

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
