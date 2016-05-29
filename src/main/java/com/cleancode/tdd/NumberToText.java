package com.cleancode.tdd;

public class NumberToText {

	private static final String SPACE = " ";

	private String[] names = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
			"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

	private String[] tens = { "", "ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

	private String[] ilions = { "", " Thousand ", " Million ", " Billion " };

	public String getText(long number) {

		if (isZero(number)) {
			return "Zero";
		}

		String text = "";
		int illionCounter = 0;

		do {
			long mod = number % 1000;

			if (mod != 0) {
				String partialText = covertNumberToTextUnderThousand((int)mod);
				text = partialText + ilions[illionCounter] + text;
			}
			illionCounter++;
			number = number / 1000;
		} while (number > 0);

		return text;
	}

	private boolean isZero(long number) {
		return number == 0;
	}

	private String covertNumberToTextUnderThousand(int number) {
		String text = "";

		if ((number % 100) < 20) {
			text = names[number % 100];
			number /= 100;
		} else {
			text = names[number % 10];
			number /= 10;

			text = tens[number % 10] + (text.isEmpty() ? text : SPACE + text);
			number /= 10;
		}

		if (number != 0) {
			text = names[number] + " Hundred " + text;
		}

		return text;
	}

}
