package com.homedepot.mm.po.allocationteamdata.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class StoreDTO {

	private BigDecimal maxStoreOverageQty;
	private BigDecimal buyPackMaxStoreOverageQty;
	private Integer baySize;
	private Integer onHand;
	private Integer onOrder;
	private String locationTypeCode;
	private Integer locationNumber;
	private Integer futureDistTypeCode;
	private Integer futureDcLocationNumber;
	private Integer rdcLocationNumber;
	private BigDecimal storeOverageQty;
	private Integer storeDemandQty;
	private Integer dcLocationNumber;

}
