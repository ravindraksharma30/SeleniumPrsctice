package com.homedepot.mm.po.allocationteamdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homedepot.mm.po.allocationteamdata.entities.BayParm;

/**
 * BayParmRepository retrieves data from the view TLALLOC_BAYPARM_STG
 * 
 * @author axd8472 & @author spv5283
 *
 */
@Repository("BayParmRepository")
public interface BayParmRepository extends JpaRepository<BayParm, Long> {

	/**
	 * 
	 * @param locationId
	 * @param activeFlag
	 * @return
	 */
	public List<BayParm> findByLocationidAndActiveflag(final String locationId, final String activeFlag);
}
