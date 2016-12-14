package com.homedepot.mm.po.allocationteamdata.teradata.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homedepot.mm.po.allocationteamdata.configuration.H2Configuration;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.SDCTargetInventory;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.SDCTargetInventoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { H2Configuration.class })
@SqlGroup({
		@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/SDCTargetInventoryPreTest.sql"),
		@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:sql/SDCTargetInventoryPostTest.sql") })
/**
 * @author axd8472 and @author spv5283
 *
 */
public class SDCTargetInventoryTest {

	@Autowired
	SDCTargetInventoryRepository sDCTargetInventoryRepository;

	@Test
	/**
	 * 
	 */
	public void testSDCTargetInventoryRepository() {
		List<SDCTargetInventory> sdcTargetInventories = sDCTargetInventoryRepository
				.findByLocationidAndProductcodeAndActiveflag("0551", "5965", "Y");

		assertEquals(1, sdcTargetInventories.size());
		assertNotNull(sdcTargetInventories);

		for (SDCTargetInventory sdcTargetInventory : sdcTargetInventories) {
			switch (sdcTargetInventory.getSequencenumber().intValue()) {
			case 651:
				assertEquals(new BigDecimal("10.000"), sdcTargetInventory.getTgt_inv_qty());
				break;

			}
		}

	}

}
