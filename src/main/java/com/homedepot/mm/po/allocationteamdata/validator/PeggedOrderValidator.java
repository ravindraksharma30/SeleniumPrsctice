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
@Component("PeggedOrderValidator")
public class PeggedOrderValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TransloadSkuDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmpty(arg1, "sku", "SKU cannot be null.");

	}

}
