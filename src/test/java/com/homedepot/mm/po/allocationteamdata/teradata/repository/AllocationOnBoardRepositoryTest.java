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
import com.homedepot.mm.po.allocationteamdata.entities.teradata.AllocationOnBoard;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.AllocationOnBoardRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { H2Configuration.class })
@SqlGroup({
		@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/AllocationOnBoardPreTest.sql"),
		@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:sql/AllocationOnBoardPostTest.sql") })
/**
 * 
 * @author gxk8870
 *
 */
public class AllocationOnBoardRepositoryTest {

	@Autowired
	AllocationOnBoardRepository allocationOnBoardRepository;

	/**
	 * 
	 */
	@Test
	public void testAllocationOnBoardRepository() {
		List<AllocationOnBoard> allocationOnBoards = null;
		allocationOnBoards = allocationOnBoardRepository.findByTransloadAllocationParmTypeCode(2);
		assertEquals(3, allocationOnBoards.size());
		assertNotNull(allocationOnBoards);
		if (!allocationOnBoards.isEmpty()) {
			for (AllocationOnBoard allocationOnBoard : allocationOnBoards) {
				switch (allocationOnBoard.getId().getTld_alloc_onbrd_parm_id()) {
				case 1299:
					assertEquals((Integer) 2050, allocationOnBoard.getParm_loc_id());
					break;
				case 502:
					assertEquals((Integer) 2448, allocationOnBoard.getParm_loc_id());
					break;
				case 331:
					assertEquals((Integer) 2882, allocationOnBoard.getParm_loc_id());
					break;

				}
			}
		}
	}

}
