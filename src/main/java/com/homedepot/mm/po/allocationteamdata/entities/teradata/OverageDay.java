package com.homedepot.mm.po.allocationteamdata.entities.teradata;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TLALLOC_OVERAGE_STG")
public class OverageDay {
	@Id
	private Long sequencenumber;
	
	private Integer uploadid;
	private String locationid;
	private String productcode;
	private Integer overage_days;
	private String activeflag;
}
