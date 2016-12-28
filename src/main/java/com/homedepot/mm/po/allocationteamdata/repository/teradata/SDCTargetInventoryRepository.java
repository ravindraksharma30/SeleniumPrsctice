package com.homedepot.mm.po.allocationteamdata.repository.teradata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.SDCTargetInventory;

/**
 * SDCTargetInventoryRepository retrieves data from the table TLALLOC_SDCINV_STG
 * 
 * @see <a href=
 *      "http://docs.spring.io/spring-data/jpa/docs/1.4.1.RELEASE/reference/html/jpa.repositories.html">Spring
 *      Data JPA reference link</a>
 * 
 * @author axd8472 & @author spv5283
 *
 */
@Repository("SDCTargetInventoryRepository")
public interface SDCTargetInventoryRepository extends JpaRepository<SDCTargetInventory, Long> {

	/**
	 * 
	 * @param loacationid
	 * @param skuNumber
	 * @param activeflag
	 * @return
	 */
	public List<SDCTargetInventory> findByLocationidAndProductcodeAndActiveflag(final String loacationid,
			final String skuNumber, final String activeflag);
}
