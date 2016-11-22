package com.homedepot.mm.po.allocationteamdata.domain;

import org.springframework.hateoas.ResourceSupport;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OverageDaysResource extends ResourceSupport {

	private Long sequencenumber;

	private Integer uploadId;
	private String locationId;
	private String productCode;
	private Integer overageDays;
	private String activeFlag;

	public OverageDaysResource(Long sequencenumber, Integer uploadId, String locationId, String productCode, Integer overageDays,
			String activeFlag) {
		this.sequencenumber = sequencenumber;
		this.uploadId = uploadId;
		this.locationId = locationId;
		this.productCode = productCode;
		this.overageDays = overageDays;
		this.activeFlag = activeFlag;

	}
}
