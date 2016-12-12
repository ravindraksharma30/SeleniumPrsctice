package com.homedepot.mm.po.allocationteamdata.repository.teradata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParm;

/**
 * BayParmRepository retrieves data from the view TLALLOC_BAYPARM_STG
 * 
 * @author axd8472 & @author spv5283
 *
 */
@Repository("BayParmRepository")
public interface BayParmRepository extends JpaRepository<BayParm, Long> {
	public List<BayParm> findByLocationidAndProductcodeAndActiveflag(String locationId, String skuNumber,
			String activeFlag);
}
