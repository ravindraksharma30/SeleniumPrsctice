package com.homedepot.mm.po.allocationteamdata.teradata.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homedepot.mm.po.allocationteamdata.AllocationTeamDataApplication;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.SDCTargetInventory;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.SDCTargetInventoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { AllocationTeamDataApplication.class })
@TestPropertySource("/application.properties")
/**
 * @author axd8472 and @author spv5283
 *
 */
public class SDCTargetInventoryTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	SDCTargetInventoryRepository sDCTargetInventoryRepository;

	@Test
	public void sdcTargetInventory_test() {
		List<SDCTargetInventory> sdcTargetInventories = null;
		try {
			sdcTargetInventories = sDCTargetInventoryRepository.findByLocationidAndActiveflag("5150", "Y");
			for (SDCTargetInventory dto : sdcTargetInventories) {
				switch (dto.getSequencenumber().intValue()) {
				case 618:
					assertEquals((double) 10, dto.getTgt_inv_qty(), .00000001);
					break;
				case 625:
					assertEquals((double) 10, dto.getTgt_inv_qty(), .00000001);
					break;
				case 727:
					assertEquals((double) 10, dto.getTgt_inv_qty(), .00000001);
					break;
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error in connection", e);
		}

	}

	@Test
	public void sdcTargetInventory_NotNull() {
		List<SDCTargetInventory> sdcTargetInventories = null;
		try {
			sdcTargetInventories = sDCTargetInventoryRepository.findByLocationidAndActiveflag("5150", "Y");
			assertNotNull(sdcTargetInventories);
		} catch (Exception e) {
			LOGGER.error("Error in connection", e);
		}

	}

}
