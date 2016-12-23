/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author axd8472
 *
 */
@Entity
@Table(name = "TLD_ALLOC_HDR")
@Data
public class AllocationHeader implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ALLOC_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALLOCATION_HEADER_SEQ")
	@SequenceGenerator(name = "ALLOCATION_HEADER_SEQ", sequenceName = "ALLOCATION_HEADER_SEQ", allocationSize = 1)
	private Integer allocationId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ALLOC_ID", nullable = false, updatable = false)
	private List<AllocationDetail> allocationDetails;

	@Column(name = "LAST_UPD_SYSUSR_ID")
	private String userId;

	@Column(name = "LAST_UPD_TS")
	private Timestamp lastUpdatedTimestamp;

	@Column(name = "ALLOC_DT")
	private Date allocationDate;

	@Column(name = "PO_NBR")
	private String poNumber;

	@Column(name = "PO_CRT_DT")
	private Date poCreationDate;

	@Column(name = "PO_TYP_CD")
	private Integer poTypeCode;

	@Column(name = "MVNDR_NBR")
	private Integer vendorNumber;

	@Column(name = "EXPCTD_ARVL_DT")
	private Date expectedArrivalDate;

	@Column(name = "TSLD_NBR")
	private String transloadNumber;

	@Column(name = "BOL_NBR")
	private String asnNumber;

	@Column(name = "TLD_ALLOC_STAT_CD")
	private Integer statusCode;

	@Column(name = "DEPARTMENT_NBR")
	private Integer departmentNumber;

	/**
	 * 
	 */
	@PrePersist
	private void prePersist() {
		this.setAllocationDate(java.sql.Date.valueOf(LocalDate.now()));
	}

	/**
	 * 
	 */
	@PostPersist
	private void postPersist() {

		if (null != allocationDetails && !allocationDetails.isEmpty() && allocationDetails.size() > 0) {

			this.allocationDetails.forEach(allocationDetail -> {
				allocationDetail.setAllocationId(allocationId);
			});

		}

	}

	/**
	 * 
	 */
	@PreUpdate
	private void preUpdate() {
		this.setLastUpdatedTimestamp(new Timestamp(System.currentTimeMillis()));
	}

}
