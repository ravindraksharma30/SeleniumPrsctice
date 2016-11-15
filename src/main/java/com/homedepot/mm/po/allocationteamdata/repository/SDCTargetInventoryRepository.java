package com.homedepot.mm.po.allocationteamdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homedepot.mm.po.allocationteamdata.entities.SDCTargetInventory;

/**
 * SDCTargetInventoryRepository retrieves data from the table TLALLOC_SDCINV_STG
 * 
 * @author axd8472 & @author spv5283
 *
 */
@Repository("SDCTargetInventoryRepository")
public interface SDCTargetInventoryRepository extends JpaRepository<SDCTargetInventory, Long> {

	public List<SDCTargetInventory> findByLocationidAndActiveflag(final String loacationid, final String activeflag);
}
