package com.homedepot.mm.po.allocationteamdata.teradata.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homedepot.mm.po.allocationteamdata.AllocationTeamDataApplication;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.SDCTargetInventory;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.SDCTargetInventoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { AllocationTeamDataApplication.class })
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
				.findByLocationidAndProductcodeAndActiveflag("5150", "", "Y");
		for (SDCTargetInventory sdcTargetInventory : sdcTargetInventories) {
			switch (sdcTargetInventory.getSequencenumber().intValue()) {
			case 618:
				assertEquals((double) 10, sdcTargetInventory.getTgt_inv_qty(), .00000001);
				break;
			case 625:
				assertEquals((double) 10, sdcTargetInventory.getTgt_inv_qty(), .00000001);
				break;
			case 727:
				assertEquals((double) 10, sdcTargetInventory.getTgt_inv_qty(), .00000001);
				break;
			}
		}

	}

	@Test
	/**
	 * 
	 */
	public void sdcTargetInventory_NotNull() {
		List<SDCTargetInventory> sdcTargetInventories = sDCTargetInventoryRepository
				.findByLocationidAndProductcodeAndActiveflag("5150", "", "Y");
		assertNotNull(sdcTargetInventories);

	}

}
