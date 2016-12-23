package com.homedepot.mm.po.allocationteamdata.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class TransloadSkuDTO {// Default Variables
	private String poNumber;
	private String asnNumber;
	private String sku;
	private Integer packSize;
	private Integer shippedQty;
	private String transloadNumber;
	private Integer remainQty;
	private Integer vendorNumber;
	private LocalDate etaDate;
	private Integer etaDaysParm;

	// Rule 1 (Store Demand) Variables
	private BigDecimal tsldStoreDemandQty;

	// Rule 2 (SDC Demand) Variables
	private BigDecimal tsldSDCTargetInventoryDemandQty;
	private BigDecimal sdcDemandForTargetVariance;

	// Rule 3 (Store Overage) Variables

	private int constraintTransloadDemandQty;
	private Integer transloadDistributionBuyPackQty;
	private int finalTransloadStoreOverageAllocQty;

	private List<AllocationDCDetailDTO> dcDetailDTOs;

	// WOS Variables
	private List<AllocationDCDetailDTO> allocationSDCDetails;
	private int finalWeeksOfSupplyAllocation;
	private LocalDate EtaData;
}
