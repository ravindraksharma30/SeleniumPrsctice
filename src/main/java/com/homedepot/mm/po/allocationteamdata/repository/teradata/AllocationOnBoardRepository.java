package com.homedepot.mm.po.allocationteamdata.repository.teradata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.AllocationOnBoard;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.AllocationOnBoardPK;

/**
 * This AllocationOnBoardRepository retrieves data from view
 * TLD_ALLOC_ONBRD_PARM
 * 
 * @author gxk8870
 *
 */
@Repository("AllocationOnBoardRepository")

public interface AllocationOnBoardRepository extends JpaRepository<AllocationOnBoard, AllocationOnBoardPK> {
	@Query(value = "select a from AllocationOnBoard a where a.id.tld_alloc_parm_typ_cd  = ?1")
	public List<AllocationOnBoard> findByTransloadAllocationParmTypeCode(Integer typeCode);
}
