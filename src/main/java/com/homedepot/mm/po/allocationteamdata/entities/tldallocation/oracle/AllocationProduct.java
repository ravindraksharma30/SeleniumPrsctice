package com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class AllocationProduct {

	@Id
	private Integer allocationId;// DCM unique identifier
	private Integer productNumber;// Product number
	private BigDecimal orderQty;// Order quantity

	private String vendorNumber;// Vendor number

	private BigDecimal poPackSize;// Product pack size by vendor. This is often
									// referred to as the Master Pack.

	// TBD and Needs to be removed

	private BigDecimal receiptQty;// Receipt quantity
	private BigDecimal receiptQtyToDate;// For PO Allocation type only. If the
										// allocation is set to use multiple
										// ship DATE functionality, this field
										// will display a total of all the
										// quantities that have been received
										// and allocated to DATE.
	private BigDecimal orderQtyPct;// For PO Allocation type only. If the
									// allocation is set to use multiple ETA
									// DATE functionality, this field displays
									// the percent of order quantity that is
									// expected to be received in the current
									// shipment.
	private Integer statusId;// The allocation status as defined in the
	// TlkpAllocationStatus (DCM-defined) lookup
	// table.

	private BigDecimal poRetailPrice;// Product retail price
	private BigDecimal poUnitCost;// Product unit cost
	private Integer quantitySource;// Determines if the source of the allocation
									// quantity was the amount ordered or the
									// actual quantity received. Values are:
									// Zero (0) or null for Order Qty
									// 1 - Receipt Qty PO Allocations populate
									// this field from the ALMethodDefault
									// table.
	private Integer productNumberCopy;// Product number if the allocation has
										// used the history of this SKU to
										// allocate other SKUs. PO Allocations
										// populate this field from the
										// ALMethodDefault table.
	private Integer numsToResMinNotMet;// Number of stores where the allocation
										// has not satisfied their minimum
										// inventory criteria (policy or user
										// defined)
	private Integer numStoresMaxNotMet;// Number of stores where the allocation
										// has not satisfied their maximum
										// inventory criteria (policy or user
										// defined)
	private Integer methodId;// SKU allocation method, defined in the
								// TlkpAllocationMethod (DCM-defined) lookup
								// table PO Allocations populate this field from
								// the ALMethodDefault table.
	private Integer includeEffInv;// Include effective inventory flag PO
									// Allocations populate this field from the
									// ALMethodDefault table.
	private Integer includePromoSales;// Include promo sales flag PO Allocations
										// populate this field from the
										// ALMethodDefault table.
	private Integer allocateAll; // Allocate 100% of quantity flag PO
									// Allocations should populate this field
									// using the ALMethodDefault table.
	private BigDecimal dcTransferPct; // DC transfer percentage PO Allocations
										// populate this field from the
										// ALMethodDefault table.
	private Integer useMinMaxPolicy; // Use min/max with one of the following
										// options:
										// 1- Use Winning Min/ Max On Hand
										// Policy (from Replenishment Strategy
										// Policy)
										// 2 - Use Min/Max On Hands entered in
										// MinOnhandQty and MaxOnhandQty
										// 3 - Do Not Use Min/Max On Hands
	private BigDecimal minShelf;// Minimum on hand quantity PO Allocations
								// populate this field from the ALMethodDefault
								// table.
	private BigDecimal maxShelf;// Maximum on hand quantity PO Allocations
								// populate this field from the ALMethodDefault
								// table.
	private Integer dcUseMinMaxPolicy; // Use DC min/max with one of the
										// following options:
										// 1 - Use Winning Min/Max On Hand
										// Policy (from Replenishment Strategy
										// Policy)
										// 2 - Use Min/Max On Hands entered in
										// MinOnhandQty and MaxOnhandQty
										// 3 - Do Not Use Min/Max On Hands
	private BigDecimal dcMinShelf;// Minimum DC on hand quantity PO Allocations
									// populate this field from the
									// ALMethodDefault table
	private BigDecimal dcMaxShelf;// Maximum DC on hand quantity PO Allocations
									// populate this field from the
									// ALMethodDefault table
	private Integer roundPackSize; // 1 - Normal Rounding
									// 2 - Force Rounding Up
									// 3- Force Rounding Down PO Allocations
									// populate this field from the
									// ALMethodDefault table.
	private Integer roundFirstPack;// A flag to indicate if the first pack size
									// is used PO Allocations populate this
									// field from the ALMethodDefault table.
	private Integer methodClassLevelId;// Allocation Method Class Level ID,
										// defined in
										// TlkpAllocationMethodClassLevel
										// (DCM-defined) lookup table PO
										// Allocations populate this field from
										// the ALMethodDefault table.
	private Integer methodTimeFrame; // Selects one of the fixed rolled up
										// timeframes. Values are 3, 6, 12, 26
										// or 52. Used in Historic % sales split
										// method. PO Allocations populate this
										// field from the ALMethodDefault table.
	private Integer methodWeeks;// Number of weeks PO Allocations populate this
								// field from the ALMethodDefault table.
	private Integer methodDays; // Number of days for the supply method PO
								// Allocations populate this field from the
								// ALMethodDefault table.
	private Date methodStartDate; // Future start DATE of the allocation,
									// Forecast % Sales Split method PO
									// Allocations populate this field from the
									// ALMethodDefault table.
	private BigDecimal methodContCodeQty; // Unit quantity for the B
											// Contribution Code PO Allocations
											// populate this field from the
											// ALMethodDefault table.
	private BigDecimal gridFactorA; // Unit quantity of the A Contribution Code
									// in grid method
	private BigDecimal gridFactorB; // Unit quantity of the B Contribution Code
									// in grid method
	private BigDecimal gridFactorC; // Unit quantity of the C Contribution Code
									// in grid method
	private BigDecimal gridFactorD; // Unit quantity of the D Contribution Code
									// in grid method
	private BigDecimal gridFactorE; // Unit quantity of the E Contribution Code
									// in grid method
	private Integer methodVolumesGId; // Volume Store Group ID used for the VSG
										// method PO Allocations populate this
										// field using the ALMethodDefault
										// table.
	private Integer batchStatus; // Batch status is one (1) if a record needs to
									// be processes by batch. It will change to
									// 3 if process complete or 99 if it failed.
									// PO must be populate it with 0 at first.
	private String batchSubmitDate; // Batch submit DATE
	private String batchCompleteDate; // Batch complete DATE
	private String methodProductAttribute; // If selected Product Attribute for
											// the Method Class Level ID, you
											// must enter the Product Attribute
											// ID for your selection. PO
											// Allocations populate this field
											// from the ALMethodDefault table.
	private Integer preDistributed; // Optional for each SKU associated with a
									// PO Allocation The SKU may be flagged as
									// Pre-Distributed or not as desired.
	private Integer distributionCode;// Filled in for the item to be directly
										// distributed The values are defined in
										// TlkpDistribution lookup table.
	private Integer sourceCode; // Filled in for item to be directly distributed
								// The values are defined in IlkpSource lookup
								// table
	private Integer poStatusId; // PO Source ID interfaced from the client. For
								// example:
								// 0 = Open
								// 1 = Approved
	private BigDecimal poInnerPackSize; // Inner Pack Size
	private BigDecimal poPackSize2;// Often referred as the Tier
	private BigDecimal poPackSize3; // Often referred as the Pallet
	private BigDecimal preDistributedThreshold; // Checks if the Receipt
												// Quantity is within a set
												// limit but not equal to the
												// Order Quantity
	private Integer manualEditLevel; // -1 - Not locked
										// 0 - Locked by Store
										// 1 - Locked by Tier-1 DC
										// 2 - Locked by Tier n-2 DC
	private BigDecimal manualPackSize; // Stores the manual pack size
	private Integer shipLevelInd; // Ship level indicator. This field is only
									// applicable if the system switch 1426 is
									// set to 2.
									// The values are defined in the
									// TlkpPackSize Lookup table:
									// 1 - Interface
									// 2 - Eaches
									// 3 - Inner Pack Size
									// 4 - Master Pack
									// 5 - Tier
									// 6 - Pallet
									// 9 - Manual
	private Integer quantityAdjusted; // Quantity adjusted flag
	private Timestamp distributionDate; // Distribution DATE
	private Integer methodEffInvInd; // Method effective inventory indicator
	private Integer groupId; // Security Group Identifier Referenced to the
								// GroupLoc table, it must be interfaced into
								// the ALProduct table as a mandatory field of
								// the PO Auto Allocation.
	private Integer useSizeScale;// This field stores the 'Size Scale Percent
									// Option' for each product in each
									// allocation
	private Integer sizeScalePctId; // This field stores Size Scale ID for each
									// product in each allocation
	private Integer prorateStatus; // For communication between online and batch
									// Products, that require style/colour
									// proration logic marked with 1
	private BigDecimal classSizeFcst; // Actual forecast for the calculated Size
										// Scale percent for each product
	private Integer methodDosSgType; // Is only populated when using the Days Of
										// Supply allocation method. Possible
										// values are: 1 - Use Volume Store
										// Group 2 - Use Plan Volume Group Null
										// - Use same days of supply value for
										// all locations
	private Integer prorateLevelId; // Class level used by calculated Size Scale
									// percent function
	private Date prorateStartDate; // Start date of forecast used to determine
									// Size Scale percent
	private Integer histStartYrWk; // History start week
	private Integer histEndYrWk; // History end week
	private Integer allocationIdCopy; // Copy of Allocation ID
	private Integer proratePeriods; // Number of periods used to determine Size
									// Scale percent
	private Integer prorateIncludePromo; // Include or not promo forecast into
											// the style/colour proratio %
											// calculation
}
