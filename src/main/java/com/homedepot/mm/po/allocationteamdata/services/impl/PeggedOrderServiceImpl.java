/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.mm.po.allocationteamdata.dto.AllocationDCDetailDTO;
import com.homedepot.mm.po.allocationteamdata.entities.oracle.PeggedOrder;
import com.homedepot.mm.po.allocationteamdata.repository.oracle.PeggedOrderRepository;
import com.homedepot.mm.po.allocationteamdata.services.PeggedOrderService;

/**
 * @author axd8472
 *
 */
@Service("PeggedOrderServiceImpl")
public class PeggedOrderServiceImpl implements PeggedOrderService {

	@Autowired
	PeggedOrderRepository peggedOrderRepository;

	@Override
	/**
	 * 
	 */
	public List<PeggedOrder> findPeggedOrders(final String asnNumber, final String poNumber, final String skuNumber) {
		// final List<PeggedOrder> peggedOrders =
		// peggedOrderRepository.findPeggedOrders(asnNumber, poNumber);
		final List<PeggedOrder> peggedOrders = peggedOrderRepository.findPeggedOrders(poNumber);
		return peggedOrders;
	}

	@Override
	public void createPeggedOrders(final AllocationDCDetailDTO allocationDCDetailDTO) {
		// TODO Convert AllocationDCDetailDTO into Alheader and AlDetails

	}

}
