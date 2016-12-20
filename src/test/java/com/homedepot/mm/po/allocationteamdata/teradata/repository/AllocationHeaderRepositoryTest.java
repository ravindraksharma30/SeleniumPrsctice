package com.homedepot.mm.po.allocationteamdata.teradata.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.AllocationProduct;
import com.homedepot.mm.po.allocationteamdata.enums.LocationType;
import com.homedepot.mm.po.allocationteamdata.repository.tldallocation.oracle.AllocationHeaderRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { H2Configuration.class })
@SqlGroup({
		@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/AllocationHeaderPreTest.sql"),
		@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:sql/AllocationHeaderPostTest.sql") })
public class AllocationHeaderRepositoryTest {
	private AllocationHeader allocationHeader = null;
	private Set<AllocationDetail> allocationDetails = null;
	private AllocationDetail allocationDetail = null;
	private AllocationProduct allocationProduct = null;
	private Set<AllocationProduct> allocationProducts = null;
	private BigDecimal FIVE = new BigDecimal("5");

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
		assertNotNull(allocationHeader.getAllocationProducts());
	}

	@Before
	public void setUp() throws ParseException {
		allocationDetail = new AllocationDetail();
		allocationDetails = new HashSet<>();
		allocationHeader = new AllocationHeader();
		allocationProduct = new AllocationProduct();
		allocationProducts = new HashSet<>();

		String date = "2016-12-25";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

		java.util.Date utilDate = simpleDateFormat.parse(date);
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		createAllocationDetail(sqlDate);

		createAllocationProduct(sqlDate);

		createAllocationHeader(sqlDate);

	}

	/**
	 * 
	 * @param sqlDate
	 */
	private void createAllocationHeader(java.sql.Date sqlDate) {
		allocationHeader.setAllocationTypeID(1);
		allocationHeader.setAllocationDate(sqlDate);
		allocationHeader.setLastEditDate(sqlDate);
		allocationHeader.setShipOnDate(sqlDate);
		allocationHeader.setEtaDate(sqlDate);
		allocationHeader.setStatusID(1);
		allocationHeader.setVendorNumber("100");
		allocationHeader.setPoNumber(1000);
		allocationHeader.setLocationType(LocationType.S);
		allocationHeader.setLocationId("5");
		allocationHeader.setAllocationDetails(allocationDetails);
		allocationHeader.setAllocationProducts(allocationProducts);
	}

	/**
	 * 
	 * @param sqlDate
	 */
	private void createAllocationDetail(java.sql.Date sqlDate) {
		allocationDetail.setAdjustedQty(new BigDecimal("10"));
		allocationDetail.setAllocatedQty(new BigDecimal("10"));
		allocationDetail.setDcNumber("TRANSLOAD 1234");
		allocationDetail.setEtaDate(sqlDate);
		allocationDetail.setLocationId("5086");
		allocationDetail.setPackSize(new BigDecimal("2"));
		allocationDetail.setProductNumber(100002587);
		allocationDetail.setLocationType(LocationType.D);
		allocationDetails.add(allocationDetail);
	}

	/**
	 * 
	 * @param sqlDate
	 */
	private void createAllocationProduct(java.sql.Date sqlDate) {
		allocationProduct.setAllocateAll(10);
		allocationProduct.setDcTransferPct(FIVE);
		allocationProduct.setDcUseMinMaxPolicy(1);
		allocationProduct.setIncludeEffectiveInventory(1);
		allocationProduct.setIncludePromoSales(1);
		allocationProduct.setMaxShelf(FIVE);
		allocationProduct.setMethodClassLevelId(2);
		allocationProduct.setMethodDays(10);
		allocationProduct.setMethodEffInvInd(3);
		allocationProduct.setMethodId(2);
		allocationProduct.setMethodStartDate(sqlDate);
		allocationProduct.setMethodTimeFrame(10);
		allocationProduct.setMethodWeeks(7);
		allocationProduct.setMinShelf(FIVE);
		allocationProduct.setOrderQty(FIVE);
		allocationProduct.setPoInnerPackSize(FIVE);
		allocationProduct.setPreDistributed(1);
		allocationProduct.setProductNumber(100002587);
		allocationProduct.setQuantitySource(0);
		allocationProduct.setReceiptQty(FIVE);
		allocationProduct.setRoundFirstPack(1);
		allocationProduct.setRoundPackSize(2);
		allocationProduct.setShipLevelInd(1);
		allocationProduct.setStatusId(3);
		allocationProduct.setUseMinMaxPolicy(0);
		allocationProduct.setVendorNumber("100");
		allocationProducts.add(allocationProduct);

	}
}
