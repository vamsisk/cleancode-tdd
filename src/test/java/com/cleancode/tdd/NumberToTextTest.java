package com.cleancode.tdd;

import static org.junit.Assert.assertEquals;

public class NumberToTextTest {

	private NumberToText numberToText = new NumberToText();

	public void testSingleDitiNumber() {
		String text = numberToText.getText(7);

		assertEquals("Seven", text);
	}

}
