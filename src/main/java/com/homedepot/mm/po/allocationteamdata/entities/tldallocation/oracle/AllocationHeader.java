/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author axd8472
 *
 */
@Entity
@Table
@Data
public class AllocationHeader {
	@Id
	private Integer allocationID;

	private Date allocationDate; // when allocation record was first created

	private Date lastEditDate; // when allocation record was last updated

	private String vendorNumber;// Vendor number
	private Integer poNumber; // Purchase order number

	private String dcLocationType;// Destination DC location type where some of
									// the bulk items are stored
	private String dcLocationID;// Destination DC location type ID where some of
								// the bulk items are stored. This field in not
								// required with a Bulk or Direct Ship
								// Allocation.

	private Integer userID;// User ID of the person currently using the
							// allocation

	private String locationType;// Location type associated to the allocation,
								// defined by system switch 2424
	private String locationId;// Location identifier associated with the
								// allocation

	
	
	
	// TBD and Needs to be removed

	private Integer allocationTypeID; // Types are:
	// 1 - Pre-Allocation
	// 2 - PO Allocation
	// 3 - DC Allocation
	private Date distributionDate;// when the distribution docs are generated
	private Integer statusID;// Allocation status as defined in the
								// TlkpAllocationStatus (DCM-defined) lookup
								// table. PO interface must populate with Temp,
								// if the ALDetail records are not available or
								// with Working, if the allocation details are
								// available and populated in ALDetail table.
	private Date shipOnDate; // when the goods are shipped
	private Date etaDate; // Estimated time of arrival DATE
	private Integer buyerID;// Buyer ID, as defined in Buyers domain table
	private Integer volumeStoreGroupID;// Volume store group identifier, defined
	// in the VolumeStoreGroupHeader table
	private String locationAttribute;// Location attribute, defined in the
	// LocationAttribute domain table
	private Integer promotionID;// Promotion ID associated with the PO
	private Date lockedDate;// DATE when the user locked the allocation
	private Integer mixedValues;// Mixed Values is equal to one (1), if the
								// allocation has not used the same method for
								// all products, or some of the products have
								// used other method parameters to do
								// calculations.
	private Integer storeRequested;// Store managers can update the store
									// adjusted quantity if this flag is true.

	private Date storeRequestedDueDate;// Store managers can update the store
										// requested quantity up to and
										// including this date.
	private String allocationComment;// Allocation comments
	private Integer priorityID;// Refers to the Priority ID mentioned in the
	// tlkpAllocationPriority table.
	private Integer altEligibilityInd;// Indicates if AL have stores not
	// regularly serviced by the AL�s DC. 0
	// � AL is only for locations serviced
	// by the DC 1 � AL has locations of
	// another DC. Only DC allocations
	// (AllocationTypeId = 3) can have value

}
