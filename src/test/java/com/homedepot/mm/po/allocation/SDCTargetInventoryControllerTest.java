package com.homedepot.mm.po.allocation;

import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.homedepot.mm.po.allocationteamdata.AllocationTeamDataApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AllocationTeamDataApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class SDCTargetInventoryControllerTest {

}
