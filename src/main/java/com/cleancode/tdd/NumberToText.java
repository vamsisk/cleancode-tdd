package com.cleancode.tdd;

public class NumberToText {

	private String[] names = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
			"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

	public String getText(int number) {

		StringBuilder text = new StringBuilder();

		if (number < 20 && number > 0) {
			text.append(names[number]);
		}

		return text.toString();
	}

}
