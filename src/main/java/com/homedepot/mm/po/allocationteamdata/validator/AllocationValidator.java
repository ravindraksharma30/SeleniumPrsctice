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

	@Override
	public boolean supports(Class<?> clazz) {
		return TransloadSkuDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmpty(arg1, "sku", "SKU Number cannot be null.");
		ValidationUtils.rejectIfEmpty(arg1, "tsldNumber", "Transload Number cannot be null.");
		ValidationUtils.rejectIfEmpty(arg1, "packSize", "Pack Size cannot be null.");

	}

}
