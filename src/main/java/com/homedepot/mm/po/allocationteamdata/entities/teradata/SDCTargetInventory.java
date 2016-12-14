package com.homedepot.mm.po.allocationteamdata.entities.teradata;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TLALLOC_SDCINV_STG")
/**
 * 
 * @author axd8472 & @author spv5283
 *
 */
public class SDCTargetInventory {

	@Id
	private Long sequencenumber;

	private int uploadid;
	private String locationid;
	private String productcode;
	private BigDecimal tgt_inv_qty;
	private String activeflag;
	
	
}
