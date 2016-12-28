/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.homedepot.mm.po.allocationteamdata.dto.TransloadSkuDTO;

/**
 * @author gxk8870
 *
 */
@Component("AllocationValidator")
public class AllocationValidator implements Validator {

	/**
	 * 
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return TransloadSkuDTO.class.isAssignableFrom(clazz);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * 
	 */
	@Override
	public void validate(final Object arg0, final Errors arg1) {
		ValidationUtils.rejectIfEmpty(arg1, "sku", "SKU Number cannot be null.");
		ValidationUtils.rejectIfEmpty(arg1, "tsldNumber", "Transload Number cannot be null.");
		ValidationUtils.rejectIfEmpty(arg1, "packSize", "Pack Size cannot be null.");

	}

}
