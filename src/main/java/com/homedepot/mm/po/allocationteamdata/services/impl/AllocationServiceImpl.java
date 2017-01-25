/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.mm.po.allocationteamdata.dto.TransloadSkuDTO;
import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.AllocationDetail;
import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.AllocationHeader;
import com.homedepot.mm.po.allocationteamdata.repository.tldallocation.oracle.AllocationHeaderRepository;
import com.homedepot.mm.po.allocationteamdata.services.AllocationService;

/**
 * @author axd8472
 *
 */
@Service("AllocationServiceImpl")
public class AllocationServiceImpl implements AllocationService {

	@Autowired
	AllocationHeaderRepository allocationHeaderRepository;

	/**
	 * 
	 */
	@Override
	public void createAllocation(final TransloadSkuDTO transloadSkuDTO) {
		AllocationDetail allocationDetail = new AllocationDetail();
		AllocationHeader allocationHeader = new AllocationHeader();
		List<AllocationDetail> allocationDetails = new ArrayList<>();

		Date etaDate = java.sql.Date.valueOf(transloadSkuDTO.getEtaDate());

		allocationHeader.setAsnNumber(transloadSkuDTO.getAsnNumber());
		// allocationHeader.setDepartmentNumber(departmentNumber);
		allocationHeader.setExpectedArrivalDate(etaDate);
		// allocationHeader.setPoCreationDate(poCreationDate);
		allocationHeader.setPoNumber(transloadSkuDTO.getPoNumber());
		// allocationHeader.setPoTypeCode(poTypeCode);
		// allocationHeader.setStatusCode(statusCode);
		allocationHeader.setTransloadNumber(transloadSkuDTO.getTransloadNumber());
		// allocationHeader.setUserId(userId);
		allocationHeader.setVendorNumber(transloadSkuDTO.getVendorNumber());

		allocationDetail.setPackSize(new BigDecimal(transloadSkuDTO.getPackSize()));
		allocationDetail.setTransloadNumber(transloadSkuDTO.getTransloadNumber());
		allocationDetail.setExpectedArrivalDate(etaDate);
		allocationDetail.setShippedQuantity(transloadSkuDTO.getShippedQty());
		allocationDetail.setSkuNumber(transloadSkuDTO.getSku());
		// allocationDetail.setUserId(userId);
		// allocationDetail.setSkuTypeCode(skuTypeCode);

		transloadSkuDTO.getDcDetailDTOs().forEach(dcDetail -> {
			allocationDetail.setAllocatedQuantity(dcDetail.getAllocQty());
			// allocationDetail.setBuyPackCode(buyPackCode);
			// allocationDetail.setContainerNumber(containerNumber);
			allocationDetail.setDcNumber(dcDetail.getDcNumber());

			allocationDetails.add(allocationDetail);

		});
		allocationHeader.setAllocationDetails(allocationDetails);
		allocationHeaderRepository.save(allocationHeader);
	}
}
