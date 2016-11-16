package com.homedepot.mm.po.allocationteamdata.repository.teradata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDays;

@Repository("OverageDaysRepository")
public interface OverageDaysRepository extends JpaRepository<OverageDays, Long> {
	public List<OverageDays> findByLocationidAndActiveflag(String locationId, String activeFlag);
}	
