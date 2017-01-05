package com.homedepot.mm.po.allocationteamdata.repository.teradata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParm;

/**
 * BayParmRepository is used to do CRUD operations for the table
 * TLALLOC_BAYPARM_STG
 * 
 * @see <a href=
 *      "http://docs.spring.io/spring-data/jpa/docs/1.4.1.RELEASE/reference/html/jpa.repositories.html">Spring
 *      Data JPA reference link</a>
 * 
 * @author axd8472 & @author spv5283
 *
 */
@Repository("BayParmRepository")
public interface BayParmRepository extends JpaRepository<BayParm, Long> {
	/**
	 * 
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 */
	public List<BayParm> findByLocationidAndProductcodeAndActiveflag(String locationId, String skuNumber,
			String activeFlag);

}
