package com.homedepot.mm.po.allocationteamdata.domain;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author axd8472
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "OverageDays")
public class OverageDayResource extends ResourceSupport {

	private Long sequencenumber;

	private Integer uploadId;
	private String locationId;
	private String productCode;
	private Integer overageDays;
	private String activeFlag;

	/**
	 *
	 */
	public OverageDayResource() {

	}

	/**
	 *
	 * @param sequencenumber
	 * @param uploadId
	 * @param locationId
	 * @param productCode
	 * @param overageDays
	 * @param activeFlag
	 */
	public OverageDayResource(Long sequencenumber, Integer uploadId, String locationId, String productCode,
			Integer overageDays, String activeFlag) {
		this.sequencenumber = sequencenumber;
		this.uploadId = uploadId;
		this.locationId = locationId;
		this.productCode = productCode;
		this.overageDays = overageDays;
		this.activeFlag = activeFlag;

	}
}
