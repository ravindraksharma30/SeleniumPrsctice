/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.domain;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author axd8472 & @author spv5283
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class BayParmResource extends ResourceSupport {

	private Long sequencenumber;

	private int uploadId;
	private String locationId;
	private String productCode;
	private BigDecimal bayParmVal;
	private String activeFlag;

	/**
	 *
	 */
	public BayParmResource() {

	}

	/**
	 * 
	 * @param sequencenumber
	 * @param uploadId
	 * @param locationId
	 * @param productCode
	 * @param bayParmVal
	 * @param activeFlag
	 */

	public BayParmResource(Long sequencenumber, int uploadId, String locationId, String productCode,
			BigDecimal bayParmVal, String activeFlag) {
		this.sequencenumber = sequencenumber;
		this.uploadId = uploadId;
		this.locationId = locationId;
		this.productCode = productCode;
		this.bayParmVal = bayParmVal;
		this.activeFlag = activeFlag;

	}

}
