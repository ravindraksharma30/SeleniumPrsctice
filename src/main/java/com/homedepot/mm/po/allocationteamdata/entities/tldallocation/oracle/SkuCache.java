package com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Entity(name = "STG_TLD_ALLOC")
@IdClass(SkuCache.class)
@Data
public class SkuCache implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TLD_DC_NBR")
	private String transloadDcNumber;

	@Id
	@Column(name = "SKU_NBR")
	private Integer skuNumber;

	@Column(name = "CRT_PGM_ID")
	private String createProgramId;

	@Column(name = "CRT_TS")
	private Timestamp createTimestamp;

}
