/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
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
	private Integer allocationId;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ALLOCATION_ID", nullable = false, updatable = false)
	private Set<AllocationDetail> allocationDetails;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ALLOCATION_ID", nullable = false, updatable = false)
	private Set<AllocationProduct> allocationProducts;

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
	@Column(name = "STATUS_ID")
	private Integer statusID;
	@Column(name = "VENDOR_NUMBER")
	private String vendorNumber;
	@Column(name = "PO_NUMBER")
	private Integer poNumber;
	@Column(name = "CLASS1_ID")
	private Integer class1ID;
	@Column(name = "LOCATION_TYPE")
	@Enumerated(EnumType.STRING)
	private LocationType locationType;
	@Column(name = "LOCATION_ID")
	private String locationId;

	/**
	 * 
	 */
	@PrePersist
	public void prePersist() {

		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();

		java.sql.Date sqlDate = new java.sql.Date(now.getTime());
		this.setAllocationDate(sqlDate);
		this.setLastEditDate(sqlDate);
	}

	/**
	 * 
	 */
	@PostPersist
	public void postPersist() {

		if (null != allocationDetails && !allocationDetails.isEmpty() && allocationDetails.size() > 0) {

			this.allocationDetails.forEach(allocationDetail -> {
				allocationDetail.setAllocationId(allocationId);
			});

		}
		if (null != allocationProducts && !allocationProducts.isEmpty() && allocationProducts.size() > 0) {

			this.allocationProducts.forEach(allocationProduct -> {
				allocationProduct.setAllocationId(allocationId);
			});
		}

	}

}
