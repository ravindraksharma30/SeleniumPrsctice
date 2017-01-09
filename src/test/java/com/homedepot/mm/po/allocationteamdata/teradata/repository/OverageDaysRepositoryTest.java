package com.homedepot.mm.po.allocationteamdata.teradata.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homedepot.mm.po.allocationteamdata.configuration.H2Configuration;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDay;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.OverageDayRepository;

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
	OverageDayRepository overageDaysRepository;

	@Test
	/**
	 * 
	 */
	public void testOverageDaysRepository() {
		OverageDay overageDay = overageDaysRepository.findByLocationidAndProductcodeAndActiveflag("5096", "103256",
				"Y");
		assertNotNull(overageDay);
	}
}
