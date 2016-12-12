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
import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDays;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.OverageDaysRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { AllocationTeamDataApplication.class })
/**
 * 
 * @author gxk8870
 *
 */
public class OverageDaysRepositoryTest {

	@Autowired
	OverageDaysRepository overageDaysRepository;

	@Test
	/**
	 * 
	 */
	public void testOverageDaysRepository() {
		List<OverageDays> overageDays = overageDaysRepository.findByLocationidAndProductcodeAndActiveflag("5098","", "Y");

		for (OverageDays overageDay : overageDays) {
			switch (overageDay.getSequencenumber().intValue()) {
			case 557:
				assertEquals((Integer) 10, overageDay.getOverage_days());
				break;
			case 505:
				assertEquals((Integer) 100, overageDay.getOverage_days());
				break;
			case 37:
				assertEquals((Integer) 37, overageDay.getOverage_days());
				break;
			}
		}
		assertNotNull(overageDays);
	}
}
