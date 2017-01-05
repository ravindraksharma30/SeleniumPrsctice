/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.homedepot.mm.po.allocationteamdata.services.MessageByLocaleService;

/**
 * @author axd8472
 *
 */
@Service("MessageByLocaleServiceImpl")
public class MessageByLocaleServiceImpl implements MessageByLocaleService {

	/**
	 * 
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * @param messageCode
	 * @return messageSource
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.homedepot.mm.po.allocationteamdata.services.MessageByLocaleService#
	 * getMessage(java.lang.String)
	 */
	@Override
	public String getMessage(final String messageCode) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(messageCode, null, locale);
	}

}
