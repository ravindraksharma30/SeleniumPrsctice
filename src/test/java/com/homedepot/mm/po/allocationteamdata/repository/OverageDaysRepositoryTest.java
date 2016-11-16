package com.homedepot.mm.po.allocationteamdata.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homedepot.mm.po.allocationteamdata.AllocationTeamDataApplication;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDays;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.OverageDaysRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {AllocationTeamDataApplication.class})
@TestPropertySource("/application.properties")
@Slf4j
public class OverageDaysRepositoryTest {

	@Autowired
	OverageDaysRepository odRepo; 
	
	@Test
	public void test() {
		List<OverageDays> overageDaysEntityDTOs = null;
		
		try {
			overageDaysEntityDTOs = odRepo.findByLocationidAndActiveflag("5098", "Y");
		}
		catch (Exception e) {
			log.error("Error saving Bar.", e);
			throw e;
		}
		
		for(OverageDays dto : overageDaysEntityDTOs) {
			switch(dto.getSequencenumber().intValue()) {
			case 557:
				assertEquals((Integer)10, dto.getOverage_days());
				break;
			case 505:
				assertEquals((Integer)100,  dto.getOverage_days());
				break;
			case 37:
				assertEquals((Integer)37, dto.getOverage_days());
				break;
			}
		}
		assertNotNull(overageDaysEntityDTOs);
	}
}
