package com.homedepot.mm.po.allocationteamdata.repository.tldallocation.oracle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.AllocationHeader;

/**
 * AllocationHeaderRepository is used to do CRUD operations for the table
 * TLD_ALLOC_HDR.
 * 
 * @author gxk8870
 *
 */
@Repository("AllocationHeaderRepository")
@Transactional("transactionManager")
public interface AllocationHeaderRepository extends JpaRepository<AllocationHeader, Integer> {

}
