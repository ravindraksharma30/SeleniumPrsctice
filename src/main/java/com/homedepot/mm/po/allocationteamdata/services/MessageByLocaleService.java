/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services;

/**
 * MessageByLocaleService defines an API to retrieve messages from
 * message_properties for Internationalization.
 * 
 * @see <a href=
 *      "http://codedevstuff.blogspot.com/2015/05/spring-boot-internationalization-with.html/">Spring
 *      Internationalization reference link</a>
 * 
 * 
 * @author axd8472
 *
 */
public interface MessageByLocaleService {
	/**
	 * Retrieve the message from the message_properties corresponds to the
	 * message code
	 * 
	 * @see com.homedepot.mm.po.allocationteamdata.services.impl.MessageByLocaleServiceImpl#getMessage()
	 * @param messageCode
	 * @return
	 */

	public String getMessage(final String messageCode);

}
