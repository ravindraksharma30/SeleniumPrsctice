package com.homedepot.mm.po.allocationteamdata.teradata.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homedepot.mm.po.allocationteamdata.AllocationTeamDataApplication;
import com.homedepot.mm.po.allocationteamdata.entities.oracle.PeggedOrder;
import com.homedepot.mm.po.allocationteamdata.repository.oracle.PeggedOrderRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { AllocationTeamDataApplication.class })
public class PeggedOrderRepositoryTest {
	
	@Autowired
	PeggedOrderRepository peggedOrderRepository;
	
	@Test
	public void testPeggedOrderRepository() {
		List<PeggedOrder> peggedOrders = peggedOrderRepository.findPeggedOrders("58158922");
		
		for(PeggedOrder peggedOrder : peggedOrders) {
			switch(peggedOrder.getVirt_peg_ord_id().toString()) {
			case "67844":
				assertEquals(new BigDecimal("36"), peggedOrder.getPeg_ord_qty());
				break;
			case "67845":
				assertEquals(new BigDecimal("36"), peggedOrder.getPeg_ord_qty());
				break;
			case "67846":
				assertEquals(new BigDecimal("36"), peggedOrder.getPeg_ord_qty());
				break;
			case "68741":
				assertEquals(new BigDecimal("12"), peggedOrder.getPeg_ord_qty());
				break;
			case "68742":
				assertEquals(new BigDecimal("12"), peggedOrder.getPeg_ord_qty());
				break;
			case "68743":
				assertEquals(new BigDecimal("12"), peggedOrder.getPeg_ord_qty());
				break;
			}
			assertNotNull(peggedOrders);
		}
		
	}
}
