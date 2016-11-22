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
import com.homedepot.mm.po.allocationteamdata.entities.teradata.AllocationOnBoard;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.AllocationOnBoardRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { AllocationTeamDataApplication.class })
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
		allocationOnBoards = allocationOnBoardRepository.findByTransloadAllocationParmTypeCode(5);
		assertNotNull(allocationOnBoards);
		if (!allocationOnBoards.isEmpty()) {
			for (AllocationOnBoard allocationOnBoard : allocationOnBoards) {
				switch (allocationOnBoard.getId().getTld_alloc_onbrd_parm_id()) {
				case 1:
					assertEquals((Integer) 2880, allocationOnBoard.getParm_loc_id());
					break;
				case 2:
					assertEquals((Integer) 2881, allocationOnBoard.getParm_loc_id());
					break;
				case 3:
					assertEquals((Integer) 2882, allocationOnBoard.getParm_loc_id());
					break;
				case 4:
					assertEquals((Integer) 2858, allocationOnBoard.getParm_loc_id());
					break;
				}
			}
		}
	}

}
