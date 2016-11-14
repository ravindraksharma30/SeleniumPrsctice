package com.homedepot.mm.po.allocationteamdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homedepot.mm.po.allocationteamdata.entities.BayParm;

/**
 * AllocationBayParmRepository retrieves data from the table
 * 
 * @author axd8472
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
