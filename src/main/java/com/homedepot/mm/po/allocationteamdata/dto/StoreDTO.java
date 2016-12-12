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
	private int locationNumber;
	private int futureDistTypeCode;
	private int futureDcLocationNumber;
	private int rdcLocationNumber;
	private BigDecimal storeOverageQty;
	private Integer storeDemandQty;
	private int dcLocationNumber;

}
