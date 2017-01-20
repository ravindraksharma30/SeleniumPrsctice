/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services;

import java.math.BigDecimal;
import java.util.List;

import com.homedepot.mm.po.allocationteamdata.entities.oracle.PeggedOrder;
import com.homedepot.mm.po.allocationteamdata.repository.oracle.PeggedOrderRepository;

/**
 * Defines an API for performing business logic around CRUD operations using
 * {@link PeggedOrderRepository}.
 * 
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
	public List<PeggedOrder> findPeggedOrders(final String asnNumber, final String poNumber,
			final BigDecimal skuNumber);

}
