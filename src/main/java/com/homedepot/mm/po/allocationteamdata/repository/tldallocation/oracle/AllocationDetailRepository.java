/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.repository.tldallocation.oracle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.AllocationDetail;

/**
 * AllocationDetailRepository is used to do CRUD operations for the table
 * TLD_ALLOC_DTL.
 * 
 * @author axd8472
 *
 */
@Repository("AllocationDetailRepository")
@Transactional("transactionManager")
public interface AllocationDetailRepository extends JpaRepository<AllocationDetail, Integer> {

}
