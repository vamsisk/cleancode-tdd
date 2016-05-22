package com.cleancode.tdd;

public class NumberToText {

	private static final String SPACE = " ";

	private String[] names = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
			"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

	private String[] tens = { "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

	public String getText(int number) {

		if (number == 0) {
			return "Zero";
		} else if (number < 20 && number > 0) {
			return names[number];
		} else if (number < 100) {
			String text = names[number % 10];

			number = number / 10;

			text = tens[number - 1] + (text.isEmpty() ? text : SPACE + text);
			return text;
		} else {
			return "";
		}
	}

}
