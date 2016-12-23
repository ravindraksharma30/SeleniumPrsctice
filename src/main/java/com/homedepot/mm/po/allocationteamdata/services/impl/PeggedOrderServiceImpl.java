/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services.impl;

import com.homedepot.mm.po.allocationteamdata.constants.AllocationTeamDataConstants;
import com.homedepot.mm.po.allocationteamdata.entities.oracle.PeggedOrder;
import com.homedepot.mm.po.allocationteamdata.repository.oracle.PeggedOrderRepository;
import com.homedepot.mm.po.allocationteamdata.services.PeggedOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

/**
 * @author axd8472
 *
 */
@Service("PeggedOrderServiceImpl")
public class PeggedOrderServiceImpl implements PeggedOrderService {

	@Autowired
	PeggedOrderRepository peggedOrderRepository;



	/**
	 * 
	 */
	@Override
	public PeggedOrder findPeggedOrder(final String asnNumber, final String poNumber, final BigDecimal skuNumber) {

		final List<PeggedOrder> peggedOrders = peggedOrderRepository.findPeggedOrders(asnNumber, poNumber, skuNumber);

		if (!peggedOrders.isEmpty() && peggedOrders.size() > 0) {
			if (AllocationTeamDataConstants.THREE.equals(peggedOrders.get(0).getPeg_typ_cd())) {
				BigDecimal peggedOrdersSum = new BigDecimal(
						peggedOrders.stream().mapToInt(i -> i.getPeg_ord_qty().intValue()).sum());
				peggedOrders.get(0).setPeg_ord_qty(peggedOrdersSum);
			} else {

				return peggedOrders.stream().max(Comparator.comparing(PeggedOrder::getVirt_peg_ord_id)).get();
			}
		}

		return peggedOrders.get(0);
	}

}
