package com.homedepot.mm.po.allocationteamdata.repository.teradata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParmEntityDTO;

@Repository
public interface TeradataAllocationJpaRepository extends JpaRepository<BayParmEntityDTO, Long> {
	public List<BayParmEntityDTO> findByLocationidAndActiveflag(String locationId, String activeFlag);
}
