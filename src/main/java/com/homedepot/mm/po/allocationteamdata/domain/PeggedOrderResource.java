/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.domain;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author axd8472
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "peggedOrder")
public class PeggedOrderResource extends ResourceSupport {

	private BigDecimal peggedOrderQty;

	private String destLocationNumber;
	private String destLocationTypeCode;
	private BigDecimal peggedTypeCode;

	/**
	 *
	 */
	public PeggedOrderResource() {

	}

	/**
	 * 
	 * @param destLocationId
	 * @param destLocationTypeCode
	 * @param peggedOrderQty
	 * @param peggedTypeCode
	 */
	public PeggedOrderResource(String destLocationId, String destLocationTypeCode, BigDecimal peggedOrderQty,
			BigDecimal peggedTypeCode) {

		this.destLocationTypeCode = destLocationTypeCode;
		this.destLocationNumber = destLocationId;

		this.peggedOrderQty = peggedOrderQty;
		this.peggedTypeCode = peggedTypeCode;

	}

}
