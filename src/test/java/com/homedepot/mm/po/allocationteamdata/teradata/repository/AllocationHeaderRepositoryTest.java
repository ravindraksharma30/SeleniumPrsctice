package com.homedepot.mm.po.allocationteamdata.teradata.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.AllocationHeader;
import com.homedepot.mm.po.allocationteamdata.repository.tldallocation.oracle.AllocationHeaderRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { H2Configuration.class })
@SqlGroup({ @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/AllocationPreTest.sql"),
		@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:sql/AllocationPostTest.sql") })
public class AllocationHeaderRepositoryTest {
	private AllocationHeader allocationHeader = null;
	private List<AllocationDetail> allocationDetails = null;
	private AllocationDetail allocationDetail = null;

	@Autowired
	AllocationHeaderRepository allocationHeaderRepository;

	@Test
	public void testCreateAllocationHeader() {
		AllocationHeader allocated = allocationHeaderRepository
				.findOne(allocationHeaderRepository.save(allocationHeader).getAllocationId());
		AllocationHeader allocationHeader = allocationHeaderRepository.findOne(allocated.getAllocationId());
		List<AllocationDetail> allocationDetails = new ArrayList<>(allocationHeader.getAllocationDetails());
		assertNotNull(allocationHeader);
		assertNotNull(allocationHeader.getAllocationDetails());
		assertEquals(allocationHeader.getAllocationId(), allocationDetails.get(0).getAllocationId());
	}

	@Before
	public void setUp() throws ParseException {
		allocationDetail = new AllocationDetail();
		allocationDetails = new ArrayList<>();
		allocationHeader = new AllocationHeader();

		createAllocationDetail();

		createAllocationHeader();

	}

	/**
	 * 
	 * @param sqlDate
	 */
	private void createAllocationHeader() {

		allocationHeader.setAsnNumber("10024589");
		allocationHeader.setDepartmentNumber(10);
		allocationHeader.setExpectedArrivalDate(java.sql.Date.valueOf(LocalDate.now()));
		allocationHeader.setPoCreationDate(java.sql.Date.valueOf(LocalDate.now()));
		allocationHeader.setPoNumber("PO#1");
		allocationHeader.setPoTypeCode(1);
		allocationHeader.setStatusCode(2);
		allocationHeader.setTransloadNumber("TRANSLOAD#2");
		allocationHeader.setUserId("ARUN&GREG");
		allocationHeader.setVendorNumber(567346597);

		allocationHeader.setAllocationDetails(allocationDetails);
	}

	/**
	 * 
	 * @param sqlDate
	 */
	private void createAllocationDetail() {

		allocationDetail.setPackSize(new BigDecimal("2"));
		allocationDetail.setTransloadNumber("TRANSLOAD#2");
		allocationDetail.setExpectedArrivalDate(java.sql.Date.valueOf(LocalDate.now()));
		allocationDetail.setShippedQuantity(100);
		allocationDetail.setSkuNumber("SKUNUMBER#7");
		allocationDetail.setUserId("ARUN&GREG");
		allocationDetail.setSkuTypeCode(1);
		allocationDetail.setAllocatedQuantity(100);
		allocationDetail.setBuyPackCode(2);
		allocationDetail.setContainerNumber("CONT#1");
		allocationDetail.setDcNumber(5086);

		allocationDetails.add(allocationDetail);
	}

}
