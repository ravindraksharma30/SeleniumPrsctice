package com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TLD_ALLOC_DTL")
@Data
public class AllocationDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALLOCATION_DETAIL_SEQ")
	@SequenceGenerator(name = "ALLOCATION_DETAIL_SEQ", sequenceName = "ALLOCATION_DETAIL_SEQ", allocationSize = 1)
	private Integer id;

	@Column(name = "ALLOC_ID", insertable = false, updatable = false)
	private Integer allocationId;

	@Column(name = "SKU_NBR")
	private String skuNumber;

	@Column(name = "SKU_SUB_TYP_CD")
	private Integer skuTypeCode;

	@Column(name = "DC_NBR")
	private Integer dcNumber;

	@Column(name = "LAST_UPD_SYSUSR_ID")
	private String userId;

	@Column(name = "LAST_UPD_TS")
	private Timestamp lastUpdatedTimestamp;

	@Column(name = "TRANSLD_NBR")
	private String transloadNumber;

	@Column(name = "EXPCTD_ARVL_DT")
	private Date expectedArrivalDate;

	@Column(name = "ASN_PO_SHIP_QTY")
	private Integer shippedQuantity;

	@Column(name = "BUY_UOM_QTY")
	private BigDecimal packSize;

	@Column(name = "BUY_PK_UOI_CD")
	private Integer buyPackCode;

	@Column(name = "CONTN_NBR")
	private String containerNumber;

	@Column(name = "ALLOC_QTY")
	private Integer allocatedQuantity;

	/**
	 * 
	 */
	@PreUpdate
	private void preUpdate() {
		this.setLastUpdatedTimestamp(new Timestamp(System.currentTimeMillis()));
	}

}
