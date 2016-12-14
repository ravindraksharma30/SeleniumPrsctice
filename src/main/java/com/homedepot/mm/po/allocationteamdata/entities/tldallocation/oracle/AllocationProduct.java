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
	@Column(name = "ALLOCATION_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALLOCATION_PRODUCT_SEQ")
	@SequenceGenerator(name = "ALLOCATION_PRODUCT_SEQ", sequenceName = "ALLOCATION_PRODUCT_SEQ", allocationSize = 1)
	private Integer allocationId;

	@Column(name = "PRODUCT_NUMBER")
	private Integer productNumber;
	@Column(name = "ORDER_QTY")
	private BigDecimal orderQty;
	@Column(name = "RECEIPT_QTY")
	private BigDecimal receiptQty;
	@Column(name = "ORDER_QTY_PCT")
	private BigDecimal orderQtyPct;
	@Column(name = "VENDOR_NUMBER")
	private String vendorNumber;
	@Column(name = "STATUS_ID")
	private Integer statusId;
	@Column(name = "PO_PACK_SIZE")
	private BigDecimal poPackSize;
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
	@Column(name = "ROUND_PACK_SIZE")
	private Integer roundPackSize; // 1 - Normal Rounding
									// 2 - Force Rounding Up
									// 3- Force Rounding Down PO Allocations
									// populate this field from the
									// ALMethodDefault table.
	@Column(name = "BATCH_STATUS")
	private Integer batchStatus; // Batch status is one (1) if a record needs to
									// be processes by batch. It will change to
									// 3 if process complete or 99 if it failed.
									// PO must be populate it with 0 at first.
	@Column(name = "BATCH_SUMBIT_DATE")
	//@Temporal(TemporalType.DATE)
	private Date batchSumbitDate;
	@Column(name = "BATCH_COMPLETE_DATE")
	//@Temporal(TemporalType.DATE)
	private Date batchCompleteDate;
	@Column(name = "QUANTITY_ADJUSTED")
	private Integer quantityAdjusted;
	@Column(name = "DISTRIBUTION_DATE")
	private Timestamp distributionDate;
}
