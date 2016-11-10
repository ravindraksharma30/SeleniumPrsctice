package com.homedepot.mm.po.allocationteamdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homedepot.mm.po.allocationteamdata.entities.BayParmJPA;

@Repository
public interface AllocationJpaRepository extends JpaRepository<BayParmJPA, Long> {
	public List<BayParmJPA> findByLocationidAndActiveflag(String locationId, String activeFlag);
}
