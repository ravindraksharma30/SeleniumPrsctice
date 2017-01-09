package com.homedepot.mm.po.allocationteamdata.repository.teradata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDay;

/**
 * OverageDaysRepository is used to do CRUD operations for the table
 * TLALLOC_OVERAGE_STG.
 * 
 * @see <a href=
 *      "http://docs.spring.io/spring-data/jpa/docs/1.4.1.RELEASE/reference/html/jpa.repositories.html">Spring
 *      Data JPA reference link</a>
 * 
 * @author axd8472
 *
 */
@Repository("OverageDaysRepository")
public interface OverageDayRepository extends JpaRepository<OverageDay, Long> {
	/**
	 * 
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 */
	public OverageDay findByLocationidAndProductcodeAndActiveflag(String locationId, String skuNumber,
			String activeFlag);
}
