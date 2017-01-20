/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.mm.po.allocationteamdata.constants.AllocationTeamDataConstants;
import com.homedepot.mm.po.allocationteamdata.entities.oracle.PeggedOrder;
import com.homedepot.mm.po.allocationteamdata.repository.oracle.PeggedOrderRepository;
import com.homedepot.mm.po.allocationteamdata.services.PeggedOrderService;

/**
 * Implementation of {@link PeggedOrderService} API by retrieving the result set
 * from the {@link PeggedOrderRepository}.
 * 
 * @author axd8472
 *
 */
@Service("PeggedOrderServiceImpl")
public class PeggedOrderServiceImpl implements PeggedOrderService {

	/**
	 * 
	 */
	@Autowired
	private PeggedOrderRepository peggedOrderRepository;

	/**
	 * @see com.homedepot.mm.po.allocationteamdata.services.PeggedOrderService#
	 *      findPeggedOrder(java.lang.String, java.lang.String,
	 *      java.math.BigDecimal)
	 * 
	 * @param asnNumber
	 * @param poNumber
	 * @param skuNumber
	 * @return peggedOrders
	 */
	@Override
	public List<PeggedOrder> findPeggedOrders(final String asnNumber, final String poNumber,
			final BigDecimal skuNumber) {

		List<PeggedOrder> peggedOrders = peggedOrderRepository.findPeggedOrders(asnNumber, poNumber, skuNumber);

		List<PeggedOrder> resultSet = new ArrayList<>();

		if (!peggedOrders.isEmpty() && peggedOrders.size() > 0) {
			// TODO: follow up that this is the correct criteria / get a code
			// review
			if (null == peggedOrders.get(0).getPeg_typ_cd()) {

				boolean addToList = true;

				for (PeggedOrder peggedOrder : peggedOrders) {
					for (PeggedOrder result : resultSet) {
						if (result.getDest_loc_nbr().equalsIgnoreCase(peggedOrder.getDest_loc_nbr())) {
							result.setPeg_ord_qty(result.getPeg_ord_qty().add(peggedOrder.getPeg_ord_qty()));
							addToList = false;
						}
					}

					if (addToList)
						resultSet.add(peggedOrder);

					addToList = true;
				}
			} else if (AllocationTeamDataConstants.THREE.equals(peggedOrders.get(0).getPeg_typ_cd())) {

				boolean addToList = true;

				for (PeggedOrder peggedOrder : peggedOrders) {
					for (PeggedOrder result : resultSet) {
						if (result.getDest_loc_nbr().equalsIgnoreCase(peggedOrder.getDest_loc_nbr())) {
							if (-1 == result.getVirt_peg_ord_id().compareTo(peggedOrder.getVirt_peg_ord_id())) {
								result.setPeg_ord_qty(peggedOrder.getPeg_ord_qty());
							}
							addToList = false;
						}
					}

					if (addToList)
						resultSet.add(peggedOrder);

					addToList = true;
				}
			}
		}

		return resultSet;
	}

}
