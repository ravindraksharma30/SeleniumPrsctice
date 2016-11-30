/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services;

import java.util.List;

import com.homedepot.mm.po.allocationteamdata.entities.oracle.PeggedOrder;
import com.homedepot.mm.po.allocationteamdata.exception.DataNotFoundException;

/**
 * @author axd8472
 *
 */
public interface PeggedOrderService {

	/**
	 * This method checks the ASN/PO combination is pegged or not by retrieving
	 * list of VirtualPegOrder using asnNumber(bol_nbr) and
	 * poNumber(inb_ord_nbr)
	 * 
	 * @param asnNo
	 * @param poNo
	 * @return
	 * @throws DataNotFoundException
	 */
	public List<PeggedOrder> findPeggedOrders(final String asnNo, final String poNo);

}
