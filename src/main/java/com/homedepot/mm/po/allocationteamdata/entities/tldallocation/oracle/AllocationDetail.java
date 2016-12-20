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
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALLOCATION_DETAIL_SEQ")
	@SequenceGenerator(name = "ALLOCATION_DETAIL_SEQ", sequenceName = "ALLOCATION_DETAIL_SEQ", allocationSize = 1)
	private Integer id;

	@Column(name = "ALLOCATION_ID", insertable = false, updatable = false)
	private Integer allocationId;

	@Column(name = "PRODUCT_NUMBER")
	private Integer productNumber;

	@Column(name = "LOCATION_TYPE")
	@Enumerated(EnumType.STRING)
	private LocationType locationType;

	@Column(name = "LOCATION_ID")
	private String locationId;

	@Column(name = "DC_NUMBER") // Transload Number
	private String dcNumber;

	@Column(name = "ETA_DATE")
	private Date etaDate;

	@Column(name = "PACK_SIZE")
	private BigDecimal packSize;
	@Column(name = "ALLOCATED_QUANTITY")
	private BigDecimal allocatedQty;
	@Column(name = "ADJUSTED_QUANTITY")
	private BigDecimal adjustedQty;

}
