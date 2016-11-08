/**
 * 
 */
package com.homedepot.mm.po.allocation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author axd8472
 *
 */
@Repository
public class AllocationRepository {

	public static final String READ_TLD_ALLOC_ONBRD_PARM = "SELECT * FROM QA_TLALLOCCSTM_EXE.TLALLOC_BAYPARM_STG WHERE LOCATIONID = 0357 AND ACTIVEFLAG = 'Y'";

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<BayParm> findAll() {
		System.out.println("Inside");
		return jdbcTemplate.query(READ_TLD_ALLOC_ONBRD_PARM, new AllocationRowMapper());
	}

}
