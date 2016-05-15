package com.cleancode.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculateStatsTest {

	CalculateStats calculateStats = new CalculateStats();

	List<Integer> dataList = Arrays.asList(6, 9, 15, -2, 92, 11);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void returnMinValueFromListTest() {
		Integer minValue = calculateStats.getMinValue(dataList);

		assertNotNull("Minumum value not returned. ", minValue);
		assertEquals("Wrong minumum value returned.", -2, minValue.intValue());
	}

	@Test
	public void returMaxValueFromListTest() {
		Integer maxValue = calculateStats.getMaxValue(dataList);

		assertNotNull("Maximum value not returned. ", maxValue);
		assertEquals("Wrong minumum value returned.", 92, maxValue.intValue());
	}

	@Test
	public void returnListSizeTest() {
		int listSize = calculateStats.getListSize(dataList);

		assertEquals("Wrong minumum value returned.", 6, listSize);
	}

	@Test
	public void returnAverageValueOfListValues() {
		float averageValue = calculateStats.getAverageValue(dataList);

		assertEquals("Wrong minumum value returned.", 18.166666f, averageValue, 0.0f);
	}
}
