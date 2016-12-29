/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services;

import java.math.BigDecimal;

import com.homedepot.mm.po.allocationteamdata.entities.oracle.PeggedOrder;

/**
 * @author axd8472
 *
 */
public interface PeggedOrderService {

	/**
	 * @see com.homedepot.mm.po.allocationteamdata.services.impl.PeggedOrderServiceImpl#findPeggedOrder()
	 * 
	 *      This method checks the ASN/PO/SKU combination is pegged or not by
	 *      retrieving a VirtualPegOrder using asnNumber(bol_nbr),
	 *      skuNumber(sku_nbr) and poNumber(inb_ord_nbr)
	 * 
	 * @param asnNumber
	 * @param poNumber
	 * @param skuNumber
	 * @return
	 */
	public PeggedOrder findPeggedOrder(final String asnNumber, final String poNumber, final BigDecimal skuNumber);

	

}
