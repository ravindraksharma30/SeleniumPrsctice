/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.mm.po.allocationteamdata.dto.TransloadSkuDTO;
import com.homedepot.mm.po.allocationteamdata.entities.oracle.PeggedOrder;
import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.AllocationDetail;
import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.AllocationHeader;
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
	public List<PeggedOrder> findPeggedOrders(final String asnNumber, final String poNumber,
			final BigDecimal skuNumber) {

		final List<PeggedOrder> peggedOrders = peggedOrderRepository.findPeggedOrders(asnNumber, poNumber, skuNumber);
		return peggedOrders;
	}

	@Override
	public void createPeggedOrders(final TransloadSkuDTO transloadSkuDTO) {
		// TODO Convert AllocationDCDetailDTO into Alheader and AlDetails
		AllocationDetail allocationDetail = new AllocationDetail();
		AllocationHeader allocationHeader = new AllocationHeader();
		//AllocationProduct allocationProduct = new AllocationProduct();

		allocationDetail.setProductNumber(transloadSkuDTO.getSku());
		allocationDetail.setPackSize(new BigDecimal(transloadSkuDTO.getPackSize()));
		allocationDetail.setShippedQty(new BigDecimal(transloadSkuDTO.getShippedQty()));
		allocationHeader.setTransloadNumber(transloadSkuDTO.getTsldNumber());

		transloadSkuDTO.getDcDetailDTOs().forEach(transload -> {
			allocationDetail.setAllocatedQty(new BigDecimal(transload.getAllocQty()));

		});

	}

}
