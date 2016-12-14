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
import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParm;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.BayParmRepository;

/**
 * 
 * @author gxk8870
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { H2Configuration.class })
@SqlGroup({ @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/BayParmPreTest.sql"),
		@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:sql/BayParmPostTest.sql") })
public class BayParmRepositoryTest {

	@Autowired
	BayParmRepository bayParmRepo;

	@Test
	/**
	 * 
	 */
	public void testBayParmRepository() {
		List<BayParm> bayParms = null;
		bayParms = bayParmRepo.findByLocationidAndProductcodeAndActiveflag("0551", "1000005316", "Y");
		assertEquals(1, bayParms.size());
		assertNotNull(bayParms);

		for (BayParm bayParm : bayParms) {
			switch (bayParm.getSequencenumber().intValue()) {
			case 149:
				assertEquals(new BigDecimal("1490.000"), bayParm.getBay_parm_val());
				break;

			}
		}
	}

}