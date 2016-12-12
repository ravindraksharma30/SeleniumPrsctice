/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services;

import java.util.List;

import com.homedepot.mm.po.allocationteamdata.dto.AllocationDCDetailDTO;
import com.homedepot.mm.po.allocationteamdata.entities.oracle.PeggedOrder;

/**
 * @author axd8472
 *
 */
public interface PeggedOrderService {

	/**
	 * 
	 * This method checks the ASN/PO combination is pegged or not by retrieving
	 * list of VirtualPegOrder using asnNumber(bol_nbr) and
	 * poNumber(inb_ord_nbr)
	 * 
	 * @param asnNumber
	 * @param poNumber
	 * @param skuNumber
	 * @return
	 */
	public List<PeggedOrder> findPeggedOrders(final String asnNumber, final String poNumber, final String skuNumber);
	
	
	public void createPeggedOrders(final AllocationDCDetailDTO allocationDCDetailDTO);

}
