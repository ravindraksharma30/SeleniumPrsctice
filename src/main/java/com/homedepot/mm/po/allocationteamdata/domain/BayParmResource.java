/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.domain;

import org.springframework.hateoas.ResourceSupport;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author axd8472 & @author spv5283
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)

public class BayParmResource extends ResourceSupport {

	private Long sequencenumber;

	private int uploadId;
	private String locationId;
	private String productCode;
	private double bayParmVal;
	private String activeFlag;

	/**
	 * 
	 * @param sequencenumber
	 * @param uploadId
	 * @param locationId
	 * @param productCode
	 * @param bayParmVal
	 * @param activeFlag
	 */

	public BayParmResource(Long sequencenumber, int uploadId, String locationId, String productCode, double bayParmVal,
			String activeFlag) {
		this.sequencenumber = sequencenumber;
		this.uploadId = uploadId;
		this.locationId = locationId;
		this.productCode = productCode;
		this.bayParmVal = bayParmVal;
		this.activeFlag = activeFlag;

	}

}
