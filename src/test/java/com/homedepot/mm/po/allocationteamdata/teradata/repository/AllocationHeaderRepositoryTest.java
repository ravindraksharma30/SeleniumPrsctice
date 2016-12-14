package com.homedepot.mm.po.allocationteamdata.teradata.repository;

import static org.junit.Assert.assertNotNull;

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
import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.AllocationHeader;
import com.homedepot.mm.po.allocationteamdata.enums.LocationType;
import com.homedepot.mm.po.allocationteamdata.repository.tldallocation.oracle.AllocationHeaderRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { H2Configuration.class })
@SqlGroup({
		@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/AllocationHeaderPreTest.sql"),
		@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:sql/AllocationHeaderPostTest.sql") })
public class AllocationHeaderRepositoryTest {
	private AllocationHeader allocationHeader = null;

	@Autowired
	AllocationHeaderRepository allocationHeaderRepository;

	@Before
	public void setUp() throws ParseException {
		String date = "2016-12-25";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date utilDate = simpleDateFormat.parse(date);
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		allocationHeader = new AllocationHeader();
		allocationHeader.setAllocationTypeID(1);
		allocationHeader.setAllocationDate(sqlDate);
		allocationHeader.setLastEditDate(sqlDate);
		allocationHeader.setShipOnDate(sqlDate);
		allocationHeader.setEtaDate(sqlDate);
		allocationHeader.setDistributionDate(sqlDate);
		allocationHeader.setStatusID(1);
		allocationHeader.setVendorNumber("100");
		allocationHeader.setPoNumber(1000);
		allocationHeader.setDcLocationID("500");
		allocationHeader.setStoreRequested(5);
		allocationHeader.setStoreRequestedDueDate(sqlDate);
		allocationHeader.setLocationType(LocationType.S);
		allocationHeader.setLocationId("5");
	}

	@Test
	@Transactional
	public void testCreateAllocationHeader() {
		AllocationHeader allocated = allocationHeaderRepository
				.findOne(allocationHeaderRepository.save(allocationHeader).getAllocationID());
		AllocationHeader allocationHeader = allocationHeaderRepository.findOne(allocated.getAllocationID());
		assertNotNull(allocationHeader);
	}
}
