package com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.homedepot.mm.po.allocationteamdata.enums.LocationType;

import lombok.Data;

@Entity
@Table(name = "AL_DETAIL")
@Data
public class AllocationDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ALLOCATION_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALLOCATION_DETAIL_SEQ")
	@SequenceGenerator(name = "ALLOCATION_DETAIL_SEQ", sequenceName = "ALLOCATION_DETAIL_SEQ", allocationSize = 1)
	private Integer allocationID;// DCM unique identifier

	@Column(name = "PRODUCT_NUMBER")
	private Integer productNumber;// Product number
	// @Column(name = "LOCATION_TYPE")
	// private String locationType;// Location Type Code: S or D.

	@Enumerated(EnumType.STRING)
	private LocationType rating;

	@Column(name = "LOCATION_ID")
	private String locationID;// Location ID Code. Must be unique and no spaces
								// (Leading Zeros)
	@Column(name = "DC_NUMBER")
	private String dcNumber;// DC that ships to locationID which can be stores
							// or DCs.
	@Column(name = "ETA_DATE")
	@Temporal(TemporalType.DATE)
	private Date etaDate;// Estimated time of arrival DATE
	@Column(name = "PACK_SIZE")
	private BigDecimal packSize;// SKU/Location Pack Size populated by the batch
								// at the time the SKU is assigned
	@Column(name = "ALLOCATED_QUANTITY")
	private BigDecimal allocatedQty;// Units allocated for the specific
									// product/location
	@Column(name = "ADJUSTED_QUANTITY")
	private BigDecimal adjustedQty;// Units adjusted by store managers in the
	// Store Managed pre-allocation.

	@Column(name = "ON_HAND")
	private BigDecimal onHand;// Populated by the Batch run
	@Column(name = "ON_ORDER")
	private BigDecimal onOrder;// Populated by the Batch run

	// TBD and Needs to be removed
	@Transient
	private String dcnumber_tier2;// DC that ships to DC number
	@Transient
	private String dcnumber_tier1;// DC that ships to DC number Tier 2
	@Transient
	private BigDecimal retailPrice;// Product retail price.
	@Transient
	private BigDecimal unitCost;// Product unit cost.
	@Transient
	private BigDecimal storeRequestedQty;// Store Requested quantity entered by
	// the store managers for store
	// managed allocations.
	@Transient
	private BigDecimal minShelf;// If Allocation header is set to Use Policy to
	// find SKU min/max, these values may be differ
	// from store to store. Otherwise, they are all
	// the same if a min/max is set at the header
	// level.
	@Transient
	private BigDecimal maxShelf;// If Allocation header is set to Use Policy to
	// find SKU min/max, these values may be differ
	// from store to store. Otherwise, they are all
	// the same if a min/max is set at the header
	// level.
	@Transient
	private Integer numStoresMinNotMet;// Number of Stores where the allocation
	// has not satisfied their minimum
	// inventory criteria (policy or user
	// defined)
	@Transient
	private Integer numStoresMaxNotMet;// Number of Stores where the allocation
	// has not satisfied their maximum
	// inventory criteria (policy or user
	// defined)
	@Transient
	private BigDecimal manualPackSize;// Stores the pack size manually
	@Transient
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
	@Transient
	private Integer shipLevelOverRide;// Ship level override indicator
	@Transient
	private Integer lockInd;// For each item flagged as locked
	@Transient
	private Integer tierLevelInd;// 0 - Stores
	// 1 - Tier 1 DC
	// 2 - Tier 2 DC
	@Transient
	private BigDecimal currEffInvUnits;// Current Effective Inventory Units
	@Transient
	private BigDecimal CurrEffInvPercent;// Each Location's Current Effective
	// Inventory units as a percentage
	// of the total of a Product Number
	@Transient
	private BigDecimal methodUnits;// Depending on the method selected, shows
	// the units associated within the Location
	// ID, Product Number and its time periods
	@Transient
	private BigDecimal methodPercent;// Each Location's (method) units as a
	// percentage of the total of a Product
	// Number
	@Transient
	private Integer methodNoOfWeeks;// Depending on the method selected, shows
	// the number of weeks at the SKU/Location
	// level
	@Transient
	private BigDecimal interimFcstUnits;// Sum of the Forecast Demand Units
	// associated with the Location ID and
	// Product Number, from the Current DATE
	// to the Start DATE, specified for the
	// Allocation Method for each store
	// location
	@Transient
	private BigDecimal targetEffInvUnits;// Target Effective Inventory Units:
	// Current Effective Inventory Units
	// - Interim FCST Sales Units
	@Transient
	private BigDecimal targetEffInvPercent;// Each Item's Location Target/
	// Effective Inventory Units as a
	// percentage of the Total Target
	// Effective Inventory Units
	@Transient
	private BigDecimal vsgStorePercent;// Percentage (%) per store associated
	// with the Store Location ID. It is
	// calculated as the percentage for the
	// Volume Grade/ # of Stores within the
	// Volume Grade; that is, the percentage
	// of the product that each store will
	// receive.
	@Transient
	private Integer gradeID;// The Volume Grade associated with the Store
	// Location ID. This can be a number from 1 to 99.
	@Transient
	private String contributionCode;// SKU/Location's Contribution Code at the
	// time when it is submitted
	@Transient
	private Integer mlasubmitFlag;// Multi-Location Assistant submit flag,

	// initially set to 0 by the batch run It
	// can be changed by the Online application.
	@Transient
	private BigDecimal inTransit;// Populated by the Batch run
	@Transient
	private BigDecimal dcTransferQty;// Online shows as DC Reserve Qty
	@Transient
	private BigDecimal dcTransferQtyAdj;// Online shows as Adj. DC Reserve Qty
	@Transient
	private BigDecimal branchDCTransferQty;// Online shows children DCs adj DC
											// Reserve Qty
	@Transient
	private BigDecimal idealNeed;// Ideal amount required
	@Transient
	private Integer flowThroughInd; // Flow Through DC
	@Transient
	private Integer releaseNextLevelInd;// Used for released to next level
										// indicator. 0 : no change 1: subtract
										// from location 2: receive to locations

}
