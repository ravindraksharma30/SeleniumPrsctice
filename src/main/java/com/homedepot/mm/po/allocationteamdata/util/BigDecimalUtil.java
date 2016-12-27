package com.homedepot.mm.po.allocationteamdata.util;

import java.math.BigDecimal;

public class BigDecimalUtil {

	/**
	 * Method to add Big Decimal values.
	 * 
	 * @param inputs
	 *            The BigDecimal values to be added.
	 * @return The result of the added BigDecimal values.
	 */
	public static BigDecimal add(BigDecimal... inputs) {
		BigDecimal result = BigDecimal.ZERO;
		if (inputs != null) {
			for (int i = 0; i < inputs.length; i++) {
				if (inputs[i] != null) {
					result = result.add(inputs[i]);
				}
			}
		}
		return result;
	}

	/**
	 * Method to add Integers as Big Decimal values.
	 * 
	 * @param inputs
	 *            The Integer values to be added.
	 * @return The result of the added Integer values as Big Decimals.
	 */
	public static BigDecimal add(Integer... inputs) {
		BigDecimal result = BigDecimal.ZERO;
		if (inputs != null) {
			for (int i = 0; i < inputs.length; i++) {
				if (inputs[i] != null) {
					result = result.add(new BigDecimal(inputs[i]));
				}
			}
		}
		return result;
	}

	/**
	 * Method to Subtract Big Decimal values.
	 * 
	 * @param inputs
	 *            The BigDecimal values to be subtracted.
	 * @return The result of the subtracted BigDecimal values.
	 */
	public static BigDecimal subtract(BigDecimal... inputs) {
		BigDecimal result = BigDecimal.ZERO;
		if (inputs != null) {
			for (int i = 0; i < inputs.length; i++) {
				if (inputs[i] == null) {
					continue;
				}
				if (i == 0) {
					result = inputs[i];
				} else {
					result = result.subtract(inputs[i]);
				}
			}
		}
		return result;
	}

	/**
	 * Method to Multiply Big Decimal values.
	 * 
	 * @param inputs
	 *            The BigDecimal values to be multiplied.
	 * @return The result of the multiplied BigDecimal values.
	 */
	public static BigDecimal multiply(BigDecimal... inputs) {
		BigDecimal result = BigDecimal.ZERO;
		if (inputs != null) {
			for (int i = 0; i < inputs.length; i++) {
				if (inputs[i] == null) {
					continue;
				}
				if (i == 0) {
					result = inputs[i];
				} else {
					result = result.multiply(inputs[i]);
				}
			}
		}
		return result;
	}

	/**
	 * Will divide the first value by the second value, while taking into account the number of decimal places and how the result should be rounded.
	 * @param value1 The first value to divide from.
	 * @param value2 The value you are dividing.
	 * @param decimalPlaces The number of decimal places for the result.
	 * @param rounding The method of rounding. Please see BigDecimal's rounding methods for more details.
	 * @return A BigDecimal with the result.
	 */
	public static BigDecimal divide(BigDecimal value1, BigDecimal value2, int decimalPlaces, int rounding) {
		if (value1 == null || BigDecimal.ZERO.equals(value1))
			return BigDecimal.ZERO;

		if (value2 == null || BigDecimal.ZERO.equals(value2))
			throw new ArithmeticException();

		return value1.divide(value2, decimalPlaces, rounding);
	}

	/**
	 * Method to compare two Big Decimal values.
	 * 
	 * @param value1
	 *            The first BigDecimal value to be compared.
	 * @param value2
	 *            The second BigDecimal value to be compared.
	 * @return The compareTo() result of the two values.
	 */
	public static int compare(BigDecimal value1, BigDecimal value2) {

		if (value1 == null && value2 == null) {
			return 0;
		}
		if (value1 == null) {
			return BigDecimal.ZERO.compareTo(value2);
		}
		if (value2 == null) {
			return value1.compareTo(BigDecimal.ZERO);
		}
		return value1.compareTo(value2);

	}

	/**
	 * Method to compare an Integer value with a BigDecimal value.
	 * 
	 * @param value1
	 *            The Integer value to be compared.
	 * @param value2
	 *            The BigDecimal value to be compared.
	 * @return The compareTo() result of the two values.
	 */
	public static int compare(Integer value1, BigDecimal value2) {
		if (value2 == null) {
			value2 = BigDecimal.ZERO;
		}
		if (value1 != null && value1 != 0) {
			return (new BigDecimal(value1)).compareTo(value2);
		} else {
			return BigDecimal.ZERO.compareTo(value2);
		}
	}

	
}
