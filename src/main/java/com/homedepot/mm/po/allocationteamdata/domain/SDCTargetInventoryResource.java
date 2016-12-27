package com.homedepot.mm.po.allocationteamdata.domain;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
/**
 * 
 * @author axd8472 & @author spv5283
 *
 */
public class SDCTargetInventoryResource extends ResourceSupport{

	private Long sequencenumber;

	private int uploadId;
	private String locationId;
	private String productCode;
	private BigDecimal tgtInvQty;
	private String activeFlag;

	/**
	 *
	 */
	public SDCTargetInventoryResource(){

	}

	/**
	 *
	 * @param sequencenumber
	 * @param uploadId
	 * @param locationId
	 * @param productCode
	 * @param tgtInvQty
	 * @param activeFlag
	 */
	public SDCTargetInventoryResource(Long sequencenumber, int uploadId, String locationId, String productCode, BigDecimal tgtInvQty,
			String activeFlag) {
		this.sequencenumber = sequencenumber;
		this.uploadId = uploadId;
		this.locationId = locationId;
		this.productCode = productCode;
		this.tgtInvQty = tgtInvQty;
		this.activeFlag = activeFlag;

	}
}
