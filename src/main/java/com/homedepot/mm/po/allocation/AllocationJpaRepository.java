/**
 * 
 */
package com.homedepot.mm.po.allocation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author axd8472
 *
 */
@Repository
public interface AllocationJpaRepository extends JpaRepository<BayParmJpa, Long> {

	// public final String SAMPLE_QUERY = "SELECT * FROM
	// QA_TLALLOCCSTM_EXE.TLALLOC_BAYPARM_STG WHERE LOCATIONID = 0357 AND
	// ACTIVEFLAG = 'Y'";

	// @Query(value = SAMPLE_QUERY, nativeQuery = true)
	public List<BayParmJpa> findByLocationid(Integer locationId);
	
	public List<BayParmJpa> findByLocationidAndActiveflag(String locationId, String activeFlag);
	
	

}
