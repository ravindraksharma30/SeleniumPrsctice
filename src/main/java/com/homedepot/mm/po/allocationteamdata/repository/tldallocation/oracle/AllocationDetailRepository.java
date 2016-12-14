/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.repository.tldallocation.oracle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.AllocationDetail;

/**
 * @author axd8472
 *
 */
@Transactional
public interface AllocationDetailRepository extends JpaRepository<AllocationDetail, Integer> {

}
