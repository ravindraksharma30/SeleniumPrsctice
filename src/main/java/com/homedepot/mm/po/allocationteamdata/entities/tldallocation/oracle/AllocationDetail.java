package com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class AllocationDetail {

	@Id
	private Integer allocationID;// DCM unique identifier
	private Integer productNumber;// Product number
	private String locationType;// Location Type Code: S or D.
	private String locationID;// Location ID Code. Must be unique and no spaces
								// (Leading Zeros)
	private String dcNumber;// DC that ships to locationID which can be stores
							// or DCs.

	private Date etaDate;// Estimated time of arrival DATE
	private BigDecimal packSize;// SKU/Location Pack Size populated by the batch
								// at the time the SKU is assigned

	private BigDecimal allocatedQty;// Units allocated for the specific
									// product/location

	private BigDecimal onHand;// Populated by the Batch run
	private BigDecimal onOrder;// Populated by the Batch run

	
	
	
	
	
	
	// TBD and Needs to be removed
	private String dcnumber_tier2;// DC that ships to DC number
	private String dcnumber_tier1;// DC that ships to DC number Tier 2
	private BigDecimal retailPrice;// Product retail price.
	private BigDecimal unitCost;// Product unit cost.
	private BigDecimal adjustedQty;// Units adjusted by store managers in the
	// Store Managed pre-allocation.
	private BigDecimal storeRequestedQty;// Store Requested quantity entered by
	// the store managers for store
	// managed allocations.
	private BigDecimal minShelf;// If Allocation header is set to Use Policy to
	// find SKU min/max, these values may be differ
	// from store to store. Otherwise, they are all
	// the same if a min/max is set at the header
	// level.
	private BigDecimal maxShelf;// If Allocation header is set to Use Policy to
	// find SKU min/max, these values may be differ
	// from store to store. Otherwise, they are all
	// the same if a min/max is set at the header
	// level.
	private Integer numStoresMinNotMet;// Number of Stores where the allocation
	// has not satisfied their minimum
	// inventory criteria (policy or user
	// defined)
	private Integer numStoresMaxNotMet;// Number of Stores where the allocation
	// has not satisfied their maximum
	// inventory criteria (policy or user
	// defined)
	private BigDecimal manualPackSize;// Stores the pack size manually
	private Integer shipLevelInd;// Ship level indicator. This field is only
	// applicable if the system switch 1426 is
	// set to 2.
	// The values are defined in the TlkpPackSize Lookup table:
	// 1 - Interface
	// 2 - Eaches
	// 3 - Inner Pack Size
	// 4 - Master Pack
	// 5 - Tier
	// 6 - Pallet
	// 9 - Manual
	private Integer shipLevelOverRide;// Ship level override indicator
	private Integer lockInd;// For each item flagged as locked
	private Integer tierLevelInd;// 0 - Stores
	// 1 - Tier 1 DC
	// 2 - Tier 2 DC
	private BigDecimal currEffInvUnits;// Current Effective Inventory Units
	private BigDecimal CurrEffInvPercent;// Each Location's Current Effective
	// Inventory units as a percentage
	// of the total of a Product Number
	private BigDecimal methodUnits;// Depending on the method selected, shows
	// the units associated within the Location
	// ID, Product Number and its time periods
	private BigDecimal methodPercent;// Each Location's (method) units as a
	// percentage of the total of a Product
	// Number
	private Integer methodNoOfWeeks;// Depending on the method selected, shows
	// the number of weeks at the SKU/Location
	// level
	private BigDecimal interimFcstUnits;// Sum of the Forecast Demand Units
	// associated with the Location ID and
	// Product Number, from the Current DATE
	// to the Start DATE, specified for the
	// Allocation Method for each store
	// location
	private BigDecimal targetEffInvUnits;// Target Effective Inventory Units:
	// Current Effective Inventory Units
	// - Interim FCST Sales Units
	private BigDecimal targetEffInvPercent;// Each Item's Location Target/
	// Effective Inventory Units as a
	// percentage of the Total Target
	// Effective Inventory Units
	private BigDecimal vsgStorePercent;// Percentage (%) per store associated
	// with the Store Location ID. It is
	// calculated as the percentage for the
	// Volume Grade/ # of Stores within the
	// Volume Grade; that is, the percentage
	// of the product that each store will
	// receive.
	private Integer gradeID;// The Volume Grade associated with the Store
	// Location ID. This can be a number from 1 to 99.
	private String contributionCode;// SKU/Location's Contribution Code at the
	// time when it is submitted
	private Integer mlasubmitFlag;// Multi-Location Assistant submit flag,
	// initially set to 0 by the batch run It
	// can be changed by the Online application.
	private BigDecimal inTransit;// Populated by the Batch run
	private BigDecimal dcTransferQty;// Online shows as DC Reserve Qty
	private BigDecimal dcTransferQtyAdj;// Online shows as Adj. DC Reserve Qty
	private BigDecimal branchDCTransferQty;// Online shows children DCs adj DC
											// Reserve Qty
	private BigDecimal idealNeed;// Ideal amount required
	private Integer flowThroughInd; // Flow Through DC
	private Integer releaseNextLevelInd;// Used for released to next level
										// indicator. 0 : no change 1: subtract
										// from location 2: receive to locations

}
