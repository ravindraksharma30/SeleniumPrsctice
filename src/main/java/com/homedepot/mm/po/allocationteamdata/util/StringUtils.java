/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.util;

import org.assertj.core.util.Strings;

/**
 * Defines static methods for doing operations on {@link String}
 * 
 * @author axd8472
 *
 */
public class StringUtils {

	/**
	 * This method validates the given array of Strings are null or Empty. If it
	 * is null or empty , then return true.
	 * 
	 * @param inputs
	 * @return
	 */
	public static boolean isNullOrEmpty(final String... inputs) {
		boolean validString = false;
		if (inputs != null) {
			for (int i = 0; i < inputs.length; i++) {
				validString = Strings.isNullOrEmpty(inputs[i]) ? true : false;
				if (validString)
					break;

			}
		}
		return validString;

	}

}
