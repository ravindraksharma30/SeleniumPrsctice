package com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "AL_PRODUCT")
@Data
public class AllocationProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALLOCATION_PRODUCT_SEQ")
	@SequenceGenerator(name = "ALLOCATION_PRODUCT_SEQ", sequenceName = "ALLOCATION_PRODUCT_SEQ", allocationSize = 1)
	private Integer id;

	@Column(name = "ALLOCATION_ID", insertable = false, updatable = false)
	private Integer allocationId;

	@Column(name = "PRODUCT_NUMBER")
	private Integer productNumber;
	@Column(name = "ORDER_QTY")
	private BigDecimal orderQty;
	@Column(name = "RECEIPT_QTY")
	private BigDecimal receiptQty;
	@Column(name = "VENDOR_NUMBER")
	private String vendorNumber;
	@Column(name = "STATUS_ID")
	private Integer statusId;
	@Column(name = "PO_PACK_SIZE")
	private BigDecimal poPackSize;
	@Column(name = "QUANTITY_SOURCE") // Always Zero
	private Integer quantitySource;
	@Column(name = "METHOD_ID") // The number represents the current pass
	private Integer methodId;
	@Column(name = "INCLUDE_EFF_INV") // AL Method id
	private Integer includeEffectiveInventory;
	@Column(name = "INCLUDE_PROMO_SALES") // Check data type
	private Integer includePromoSales;
	@Column(name = "ALLOCATE_ALL") // Check data type
	private Integer allocateAll;
	@Column(name = "DC_TRANSFER_PCT")
	private BigDecimal dcTransferPct;
	@Column(name = "USE_MIN_MAX_POLICY")
	private Integer useMinMaxPolicy; // Use min/max with one of the following
										// options:
										// 1- Use Winning Min/ Max On Hand
										// Policy (from Replenishment Strategy
										// Policy)
										// 2 - Use Min/Max On Hands entered in
										// MinOnhandQty and MaxOnhandQty
										// 3 - Do Not Use Min/Max On Hands
										// TBD and Needs to be removed
	@Column(name = "MIN_SHELF")
	private BigDecimal minShelf;
	@Column(name = "MAX_SHELF")
	private BigDecimal maxShelf;
	@Column(name = "DC_USE_MIN_MAX_POLICY")
	private Integer dcUseMinMaxPolicy;

	@Column(name = "ROUND_PACK_SIZE")
	private Integer roundPackSize; // 1 - Normal Rounding
									// 2 - Force Rounding Up
									// 3- Force Rounding Down PO Allocations
									// populate this field from the
									// ALMethodDefault table.
	@Column(name = "ROUND_FIRST_PACK")
	private Integer roundFirstPack;
	@Column(name = "METHOD_CLASS_LEVEL_ID")
	private Integer methodClassLevelId;
	@Column(name = "METHOD_TIME_FRAME")
	private Integer methodTimeFrame;
	@Column(name = "METHOD_WEEKS")
	private Integer methodWeeks;// Number of weeks PO Allocations populate this
								// field from the ALMethodDefault table.
	@Column(name = "METHOD_DAYS")
	private Integer methodDays; // Number of days for the supply method PO
	// Allocations populate this field from the
	// ALMethodDefault table.
	@Column(name = "METHOD_START_DATE")
	private Date methodStartDate;
	@Column(name = "PRE_DISTRIBUTED")
	private Integer preDistributed;
	@Column(name = "PO_INNER_PACK_SIZE")
	private BigDecimal poInnerPackSize;
	@Column(name = "SHIP_LEVEL_IND")
	private Integer shipLevelInd;
	@Column(name = "METHOD_EFF_INV_IND")
	private Integer methodEffInvInd;

}
