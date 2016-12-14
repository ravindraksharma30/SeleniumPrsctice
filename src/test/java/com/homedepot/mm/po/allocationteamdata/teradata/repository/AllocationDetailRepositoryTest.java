/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.teradata.repository;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homedepot.mm.po.allocationteamdata.configuration.H2Configuration;
import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.AllocationDetail;
import com.homedepot.mm.po.allocationteamdata.enums.LocationType;
import com.homedepot.mm.po.allocationteamdata.repository.tldallocation.oracle.AllocationDetailRepository;

/**
 * @author axd8472
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { H2Configuration.class })
@SqlGroup({
		@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/AllocationDetailPreTest.sql"),
		@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:sql/AllocationDetailPostTest.sql") })

public class AllocationDetailRepositoryTest {
	private AllocationDetail allocationDetail = null;

	@Autowired
	AllocationDetailRepository allocationDetailRepository;

	@Test
	/**
	 * 
	 */
	@Transactional
	public void testCreateAllocationDetail() {
		// AllocationDetail allocated =
		// allocationDetailRepository.save(allocationDetail);
		AllocationDetail allocated = allocationDetailRepository
				.findOne(allocationDetailRepository.save(allocationDetail).getAllocationID());
		AllocationDetail allocationDetail = allocationDetailRepository.findOne(allocated.getAllocationID());
		assertNotNull(allocationDetail);

	}

	@Before
	/**
	 * 
	 */
	public void setUp() throws ParseException {

		String date = "2016-12-25";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date utilDate = simpleDateFormat.parse(date);
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		// java.sql.Date date = new java.sql.Date(currentDate.getTime());

		allocationDetail = new AllocationDetail();
		allocationDetail.setAdjustedQty(new BigDecimal(10));
		allocationDetail.setAllocatedQty(new BigDecimal(10));
		allocationDetail.setDcNumber("5086");
		allocationDetail.setEtaDate(sqlDate);
		allocationDetail.setLocationID("RDC");
		allocationDetail.setLocationType(LocationType.WS);
		allocationDetail.setPackSize(new BigDecimal(2));
		allocationDetail.setProductNumber(10000);

	}

}
