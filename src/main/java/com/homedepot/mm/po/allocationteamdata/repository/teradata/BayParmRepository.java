package com.homedepot.mm.po.allocationteamdata.repository.teradata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParm;

@Repository("BayParmRepository")
public interface BayParmRepository extends JpaRepository<BayParm, Long> {
	public List<BayParm> findByLocationidAndActiveflag(String locationId, String activeFlag);
}
