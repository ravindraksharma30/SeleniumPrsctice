/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

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
	private String srcLocationNumber;
	private String destLocationNumber;
	private String srcLocationTypeCode;
	private String destLocationTypeCode;
	private BigDecimal mvndrNumber;
	private BigDecimal merDeptNumber;
	private BigDecimal skuNumber;
	private BigDecimal peggedOrderQty;
	private String inboundOrderNumber;
	private BigDecimal prntPeggedOrderId;
	private BigDecimal peggedOrderWorkId;
	private BigDecimal soqRefId;
	private BigDecimal peggedOrderStatusCode;
	private String prcsdFlag;
	private BigDecimal packSize;
	private BigDecimal peggedTypeCode;
	private BigDecimal peggedOrderReasonTypeCode;
	private BigDecimal skuSubTypeCode;
	private Timestamp portExpectedArrival;

	public PeggedOrderResource(BigDecimal virtualPegOrderId, String asnNumber, String srcLocationId,
			String destLocationId, String srcLocationTypeCode, String destLocationTypeCode, BigDecimal mvndrNumber,
			BigDecimal merDeptNumber, BigDecimal skuNumber, BigDecimal peggedOrderQty, String inboundOrderNumber,
			BigDecimal prntPeggedOrderId, BigDecimal peggedOrderWorkId, BigDecimal soqRefId,
			BigDecimal peggedOrderStatusCode, String prcsdFlag, BigDecimal packSize, BigDecimal peggedTypeCode,
			BigDecimal peggedOrderReasonTypeCode, BigDecimal skuSubTypeCode, Timestamp portExpectedArrival) {
		this.virtualPegOrderId = virtualPegOrderId;
		this.asnNumber = asnNumber;
		this.srcLocationNumber = srcLocationId;
		this.destLocationNumber = destLocationId;
		this.srcLocationTypeCode = srcLocationTypeCode;
		this.destLocationTypeCode = destLocationTypeCode;
		this.mvndrNumber = mvndrNumber;
		this.merDeptNumber = merDeptNumber;
		this.skuNumber = skuNumber;
		this.peggedOrderQty = peggedOrderQty;
		this.inboundOrderNumber = inboundOrderNumber;
		this.prntPeggedOrderId = prntPeggedOrderId;
		this.peggedOrderWorkId = peggedOrderWorkId;
		this.soqRefId = soqRefId;
		this.peggedOrderStatusCode = peggedOrderStatusCode;
		this.prcsdFlag = prcsdFlag;
		this.packSize = packSize;
		this.peggedTypeCode = peggedTypeCode;
		this.peggedOrderReasonTypeCode = peggedOrderReasonTypeCode;
		this.skuSubTypeCode = skuSubTypeCode;
		this.portExpectedArrival = portExpectedArrival;
	}

}
