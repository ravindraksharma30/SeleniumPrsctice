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

	private BigDecimal virtualPegOrderId;
	private String asnNumber;
	private BigDecimal skuNumber;
	private BigDecimal peggedOrderQty;
	private String poNumber;
	private String destLocationNumber;
	private String destLocationTypeCode;

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
	// private BigDecimal peggedTypeCode;
	// private BigDecimal peggedOrderReasonTypeCode;
	// private BigDecimal skuSubTypeCode;
	// private Timestamp portExpectedArrival;

	/**
	 * 
	 * @param virtualPegOrderId
	 * @param asnNumber
	 * @param destLocationId
	 * @param destLocationTypeCode
	 * @param skuNumber
	 * @param peggedOrderQty
	 * @param poNumber
	 */
	public PeggedOrderResource(BigDecimal virtualPegOrderId, String asnNumber, String poNumber, BigDecimal skuNumber,
			String destLocationId, String destLocationTypeCode, BigDecimal peggedOrderQty) {
		this.virtualPegOrderId = virtualPegOrderId;
		this.asnNumber = asnNumber;
		this.destLocationTypeCode = destLocationTypeCode;
		this.destLocationNumber = destLocationId;
		this.skuNumber = skuNumber;
		this.peggedOrderQty = peggedOrderQty;
		this.poNumber = poNumber;

	}

	// public PeggedOrderResource(BigDecimal virtualPegOrderId, String
	// asnNumber, String srcLocationId,
	// String destLocationId, String srcLocationTypeCode, String
	// destLocationTypeCode, BigDecimal mvndrNumber,
	// BigDecimal merDeptNumber, BigDecimal skuNumber, BigDecimal
	// peggedOrderQty, String inboundOrderNumber,
	// BigDecimal prntPeggedOrderId, BigDecimal peggedOrderWorkId, BigDecimal
	// soqRefId,
	// BigDecimal peggedOrderStatusCode, String prcsdFlag, BigDecimal packSize,
	// BigDecimal peggedTypeCode,
	// BigDecimal peggedOrderReasonTypeCode, BigDecimal skuSubTypeCode,
	// Timestamp portExpectedArrival) {
	// this.virtualPegOrderId = virtualPegOrderId;
	// this.asnNumber = asnNumber;
	// this.destLocationTypeCode = destLocationTypeCode;
	// this.destLocationNumber = destLocationId;
	// this.skuNumber = skuNumber;
	// this.peggedOrderQty = peggedOrderQty;
	//
	//
	//
	// this.srcLocationNumber = srcLocationId;
	// this.srcLocationTypeCode = srcLocationTypeCode;
	// this.mvndrNumber = mvndrNumber;
	// this.merDeptNumber = merDeptNumber;
	// this.inboundOrderNumber = inboundOrderNumber;
	// this.prntPeggedOrderId = prntPeggedOrderId;
	// this.peggedOrderWorkId = peggedOrderWorkId;
	// this.soqRefId = soqRefId;
	// this.peggedOrderStatusCode = peggedOrderStatusCode;
	// this.prcsdFlag = prcsdFlag;
	// this.packSize = packSize;
	// this.peggedTypeCode = peggedTypeCode;
	// this.peggedOrderReasonTypeCode = peggedOrderReasonTypeCode;
	// this.skuSubTypeCode = skuSubTypeCode;
	// this.portExpectedArrival = portExpectedArrival;
	// }

}
