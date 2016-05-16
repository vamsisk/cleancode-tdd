/**
 * 
 */
package com.cleancode.tdd;

import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

/**
 * @author vsure
 *
 */
public class CalculateStats {

	public Integer getMinValue(List<Integer> dataList) {
		return Collections.min(dataList);
	}

	public Integer getMaxValue(List<Integer> dataList) {
		return Collections.max(dataList);
	}

	public int getListSize(List<Integer> dataList) {
		return dataList.size();
	}

	public double getAverageValue(List<Integer> dataList) {
		OptionalDouble value = dataList.stream().mapToInt(m -> m).average();
		return value.getAsDouble();
	}

}
