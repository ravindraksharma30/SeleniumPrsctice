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
	BayParmRepository barRepo;

	@Test
	/**
	 * 
	 */
	public void testBayParmRepository() {
		List<BayParm> bayParms = null;
		bayParms = barRepo.findByLocationidAndActiveflag("5068", "Y");

		for (BayParm bayParm : bayParms) {
			switch (bayParm.getSequencenumber().intValue()) {
			case 491:
				assertEquals((double) 4910, bayParm.getBay_parm_val(), .00000001);
				break;
			case 429:
				assertEquals((double) 4290, bayParm.getBay_parm_val(), .00000001);
				break;
			case 310:
				assertEquals((double) 3100, bayParm.getBay_parm_val(), .00000001);
				break;
			}
		}
		assertNotNull(bayParms);
	}

}