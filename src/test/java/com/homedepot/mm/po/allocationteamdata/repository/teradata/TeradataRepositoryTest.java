package com.homedepot.mm.po.allocationteamdata.repository.teradata;

import static org.junit.Assert.*;

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
import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParmEntityDTO;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {AllocationTeamDataApplication.class})
@TestPropertySource("/application.properties")

public class TeradataRepositoryTest {

    private static Logger log = LoggerFactory.getLogger(TeradataRepositoryTest.class);
    
    @Autowired
    TeradataAllocationJpaRepository barRepo;
    
    @Test
    public void test() {
    	List<BayParmEntityDTO> bayParmEntityDTOs = null;
        try {
        	bayParmEntityDTOs = barRepo.findByLocationidAndActiveflag("0357","Y");
        } catch (Exception e) {
            log.error("Error saving Bar.", e);
            throw e;
        }
        
        for(BayParmEntityDTO dto: bayParmEntityDTOs){
			switch (dto.getSequencenumber().intValue()) {
			case 491:
				assertEquals((double)4910, dto.getBay_parm_val(),.00000001);
				break;
			case 429:
				assertEquals((double)4290, dto.getBay_parm_val(),.00000001);
				break;
			case 310:
				assertEquals((double)3100, dto.getBay_parm_val(),.00000001);
				break;
			}
		}
        assertNotNull(bayParmEntityDTOs);
    }

}