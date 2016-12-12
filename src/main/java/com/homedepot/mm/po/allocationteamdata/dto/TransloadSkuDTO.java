package com.homedepot.mm.po.allocationteamdata.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class TransloadSkuDTO {

	//Default Variables
	private Integer sku;
	private Integer packSize;
	private Integer shippedQty;
	private Integer tsldNumber;
	private Integer remainQty;
	
	//Rule 1 (Store Demand) Variables
	private BigDecimal tsldStoreDemandQty;
	
	//Rule 2 (SDC Demand) Variables
	private BigDecimal tsldSDCTargetInventoryDemandQty;
	private BigDecimal sdcDemandForTargetVariance;
	
	//Rule 3 (Store Overage) Variables

	private int constraintTransloadDemandQty;
	private Integer transloadDistributionBuyPackQty;
	private int finalTransloadStoreOverageAllocQty;
	
	private List<AllocationDCDetailDTO> dcDetailDTOs;
}
