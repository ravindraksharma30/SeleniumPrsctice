package com.homedepot.mm.po.allocationteamdata.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class AllocationDCDetailDTO {

	//Default Variables
	private Integer dcNumber;
	private String dcType;
	private Integer ooQuantity; //sdcOoQuantity
	private Integer ohQuantity; //sdcOhQuantity
	private Integer targetInv;
	private BigDecimal initAllocQty;
	
	//Calculated Variables 
	private BigDecimal varianceToTarget;
	private Integer allocQty = 0;
	
	//Rule 1 (Store Demand) Variables 
	private BigDecimal origStoreDcDemandQty;
	private Integer storeDemandCycAllocQty;
	
	//Rule 2 (SDC Demand) Variables
	private BigDecimal origSDCTargetInventoryDemandQty;
	private Integer sdcDemandCycAllocQty;
	
	//Rule 3 (Store Overage) Variables
	private Integer constraintDcDemandQty = 0;
	private BigDecimal dcDemandPct;
	private BigDecimal initialDistrDcQty;
	private BigDecimal remainingDcAvailQty;
	private Integer finalDcStoreOverageAllocQty;
	

	private List<StoreDTO> stores; 
	
 	//Rule 4 (SDC Overage) Variables 
	private Integer sdcOverageRuleAllocQty = 0;
	private Integer sdcOverageRuleDemandQty = 0;
}
