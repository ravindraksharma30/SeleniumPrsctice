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
import com.homedepot.mm.po.allocationteamdata.entities.oracle.PeggedOrder;
import com.homedepot.mm.po.allocationteamdata.repository.oracle.PeggedOrderRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { H2Configuration.class })
@SqlGroup({ @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/PeggedOrderPreTest.sql"),
		@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:sql/PeggedOrderPostTest.sql") })
public class PeggedOrderRepositoryTest {

	@Autowired
	PeggedOrderRepository peggedOrderRepository;

	@Test
	public void testPeggedOrderRepository() {
		List<PeggedOrder> peggedOrders = peggedOrderRepository.findPeggedOrders("EGLV14369", "58180345",
				new BigDecimal("1000358177"));
		assertEquals(3, peggedOrders.size());
		assertNotNull(peggedOrders);
		for (PeggedOrder peggedOrder : peggedOrders) {
			switch (peggedOrder.getVirt_peg_ord_id().toString()) {

			case "84256":
				assertEquals(new BigDecimal("200"), peggedOrder.getPeg_ord_qty());
				break;

			}
		}

	}

}
