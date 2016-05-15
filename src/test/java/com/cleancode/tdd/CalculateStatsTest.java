package com.cleancode.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculateStatsTest {

	CalculateStats calculateStats;

	@Before
	public void setUp() throws Exception {
		calculateStats = new CalculateStats();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void returnMinValueFromListTest() {

		List<Integer> dataList = Arrays.asList(6, 9, 15, -2, 92, 11);

		Integer minValue = calculateStats.getMinValue(dataList);

		assertNotNull("Minumum value returned. ", minValue);
		assertEquals("Wrong minumum value returned.", -2, minValue.intValue());
	}

}
