/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle;

import java.io.Serializable;
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

import com.homedepot.mm.po.allocationteamdata.enums.LocationType;

import lombok.Data;

/**
 * @author axd8472
 *
 */
@Entity
@Table(name = "AL_HEADER")
@Data
public class AllocationHeader implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ALLOCATION_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALLOCATION_HEADER_SEQ")
	@SequenceGenerator(name = "ALLOCATION_HEADER_SEQ", sequenceName = "ALLOCATION_HEADER_SEQ", allocationSize = 1)
	private Integer allocationID;

	@Column(name = "ALLOCATION_TYPE_ID")
	private Integer allocationTypeID;
	@Column(name = "ALLOCATION_DATE")
	private Date allocationDate;
	@Column(name = "LAST_EDIT_DATE")
	private Date lastEditDate;
	@Column(name = "SHIP_ON_DATE")
	private Date shipOnDate;
	@Column(name = "ETA_DATE")
	private Date etaDate;
	@Column(name = "DISTRIBUTION_DATE")
	private Date distributionDate;
	@Column(name = "STATUS_ID")
	private Integer statusID;
	@Column(name = "VENDOR_NUMBER")
	private String vendorNumber;
	@Column(name = "PO_NUMBER")
	private Integer poNumber;
	@Column(name = "DC_LOCATION_ID")
	private String dcLocationID;
	@Column(name = "STORE_REQUESTED")
	private Integer storeRequested;
	@Column(name = "STORE_REQUESTED_DUE_DATE")
	private Date storeRequestedDueDate;
	@Column(name = "LOCATION_TYPE")
	@Enumerated(EnumType.STRING)
	private LocationType locationType;
	@Column(name = "LOCATION_ID")
	private String locationId;

}
