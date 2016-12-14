package com.homedepot.mm.po.allocationteamdata.teradata.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDays;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.OverageDaysRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { H2Configuration.class })
@SqlGroup({ @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/OverageDaysPreTest.sql"),
		@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:sql/OverageDaysPostTest.sql") })
/**
 * `
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
		List<OverageDays> overageDays = overageDaysRepository.findByLocationidAndProductcodeAndActiveflag("5096",
				"103256", "Y");
		assertEquals(1, overageDays.size());
		assertNotNull(overageDays);

		for (OverageDays overageDay : overageDays) {
			switch (overageDay.getSequencenumber().intValue()) {
			case 557:
				assertEquals((Integer) 10, overageDay.getOverage_days());
				break;

			}
		}
	}
}
