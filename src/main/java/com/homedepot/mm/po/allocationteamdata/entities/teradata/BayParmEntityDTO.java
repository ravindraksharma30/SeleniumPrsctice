package com.homedepot.mm.po.allocationteamdata.entities.teradata;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TLALLOC_BAYPARM_STG")
public class BayParmEntityDTO {
	@Id
	private Long sequencenumber;
	
	private int uploadid;
	private String locationid;
	private String productcode;
	private double bay_parm_val;
	private String activeflag;
}