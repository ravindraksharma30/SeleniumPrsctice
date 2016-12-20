/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.domain;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author axd8472
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PeggedOrderResource extends ResourceSupport {

	private BigDecimal peggedOrderQty;

	private String destLocationNumber;
	private String destLocationTypeCode;
	private BigDecimal peggedTypeCode;

	// private String poNumber;
	// private BigDecimal virtualPegOrderId;
	// private String asnNumber;
	// private BigDecimal skuNumber;
	// private String srcLocationNumber;
	// private String srcLocationTypeCode;
	// private BigDecimal mvndrNumber;
	// private BigDecimal merDeptNumber;
	// private BigDecimal prntPeggedOrderId;
	// private BigDecimal peggedOrderWorkId;
	// private BigDecimal soqRefId;
	// private BigDecimal peggedOrderStatusCode;
	// private String prcsdFlag;
	// private BigDecimal packSize;
	// private BigDecimal peggedOrderReasonTypeCode;
	// private BigDecimal skuSubTypeCode;
	// private Timestamp portExpectedArrival;

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
