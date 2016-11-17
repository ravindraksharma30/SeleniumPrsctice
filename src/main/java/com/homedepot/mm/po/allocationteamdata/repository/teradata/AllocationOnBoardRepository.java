package com.homedepot.mm.po.allocationteamdata.repository.teradata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.AllocationOnBoard;

@Repository("AllocationOnBoardRepository")
public interface AllocationOnBoardRepository extends JpaRepository<AllocationOnBoard, Long> {
	public List<AllocationOnBoard> findByParm_loc_idAndActv_flg(Integer locationId, String activeFlag);
}
