/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.homedepot.mm.po.allocationteamdata.dto.TransloadSkuDTO;
import com.homedepot.mm.po.allocationteamdata.services.MessageByLocaleService;

/**
 * AllocationValidator validates the {@link TransloadSkuDTO} before persisting
 * into database.
 * 
 * @author gxk8870
 *
 */
@Component("AllocationValidator")
public class AllocationValidator implements Validator {

	/**
	 * 
	 */
	@Autowired
	private MessageByLocaleService messageSource;

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
		ValidationUtils.rejectIfEmpty(arg1, "sku", messageSource.getMessage("allocationteamdata.invalid.skuNumber"));
		ValidationUtils.rejectIfEmpty(arg1, "transloadNumber",
				messageSource.getMessage("allocationteamdata.invalid.transloadNumber"));
		ValidationUtils.rejectIfEmpty(arg1, "packSize",
				messageSource.getMessage("allocationteamdata.invalid.packSize"));

	}

}
