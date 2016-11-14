/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.domain;

import org.springframework.hateoas.ResourceSupport;

import lombok.Data;

/**
 * @author axd8472
 *
 */
@Data
public class BayParmResource extends ResourceSupport {

	private Long sequencenumber;

	private int uploadId;
	private String locationId;
	private String productCode;
	private double bayParmVal;
	private String activeFlag;

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
