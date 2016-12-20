package com.homedepot.mm.po.allocationteamdata.teradata.repository;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homedepot.mm.po.allocationteamdata.configuration.H2Configuration;
import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.AllocationProduct;
import com.homedepot.mm.po.allocationteamdata.repository.tldallocation.oracle.AllocationProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { H2Configuration.class })
@SqlGroup({
		@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/AllocationProductPreTest.sql"),
		@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:sql/AllocationProductPostTest.sql") })
@Ignore
public class AllocationProductRepositoryTest {
	private AllocationProduct allocationProduct = null;

	@Autowired
	AllocationProductRepository allocationProductRepository;

	public void testCreateAllocationProduct() {
		AllocationProduct allocated = allocationProductRepository
				.findOne(allocationProductRepository.save(allocationProduct).getAllocationId());
		AllocationProduct allocationProduct = allocationProductRepository.findOne(allocated.getAllocationId());
		assertNotNull(allocationProduct);
	}

	@Before
	public void setUp() throws ParseException {

		allocationProduct = new AllocationProduct();
		allocationProduct.setProductNumber(1000);
		allocationProduct.setOrderQty(new BigDecimal("1"));
		allocationProduct.setReceiptQty(new BigDecimal("1"));
		allocationProduct.setVendorNumber("100");
		allocationProduct.setStatusId(1);
		allocationProduct.setPoPackSize(new BigDecimal("1"));
		allocationProduct.setDcTransferPct(new BigDecimal("1"));
		allocationProduct.setUseMinMaxPolicy(1);
		allocationProduct.setRoundPackSize(1);

	}
}
