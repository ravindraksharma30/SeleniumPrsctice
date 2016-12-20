/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services.impl;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.homedepot.mm.po.allocationteamdata.dto.TransloadSkuDTO;
import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.AllocationDetail;
import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.AllocationHeader;
import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.AllocationProduct;
import com.homedepot.mm.po.allocationteamdata.enums.LocationType;
import com.homedepot.mm.po.allocationteamdata.repository.tldallocation.oracle.AllocationHeaderRepository;
import com.homedepot.mm.po.allocationteamdata.services.AllocationService;

/**
 * @author axd8472
 *
 */
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
		AllocationProduct allocationProduct = new AllocationProduct();
		Set<AllocationDetail> allocationDetails = new HashSet<>();
		Set<AllocationProduct> allocationProducts = new HashSet<>();

		// allocationHeader.setAllocationDate(allocationDate);
		// allocationHeader.setAllocationTypeID(allocationTypeID);
		// allocationHeader.setClass1ID(class1ID);
		// allocationHeader.setEtaDate(etaDate);
		// allocationHeader.setLocationId(locationId);
		// allocationHeader.setLocationType(locationType);
		// allocationHeader.setPoNumber(poNumber);
		// allocationHeader.setShipOnDate(shipOnDate);
		// allocationHeader.setStatusID(statusID);
		// allocationHeader.setVendorNumber(vendorNumber);

		allocationDetail.setProductNumber(transloadSkuDTO.getSku());
		allocationDetail.setPackSize(new BigDecimal(transloadSkuDTO.getPackSize()));

		allocationProduct.setOrderQty(new BigDecimal(transloadSkuDTO.getShippedQty()));
		allocationProduct.setReceiptQty(new BigDecimal(transloadSkuDTO.getShippedQty()));
		allocationProduct.setProductNumber(transloadSkuDTO.getSku());
		allocationProduct.setPoPackSize(new BigDecimal(1));
		allocationProduct.setPreDistributed(0);

		transloadSkuDTO.getDcDetailDTOs().forEach(dcDetail -> {
			allocationDetail.setAllocatedQty(new BigDecimal(dcDetail.getAllocQty()));
			// allocationDetail.setAdjustedQty(adjustedQty);
			allocationDetail.setDcNumber(Integer.toString(transloadSkuDTO.getTsldNumber()));
			// allocationDetail.setEtaDate(etaDate);
			allocationDetail.setLocationId("DC");
			allocationDetail.setLocationType(LocationType.S);
			allocationDetails.add(allocationDetail);

			dcDetail.getStores().forEach(store -> {
				//allocationProduct.setAllocateAll(allocateAll);
				//allocationProduct.setDcTransferPct(dcTransferPct);
				//allocationProduct.setDcUseMinMaxPolicy(dcUseMinMaxPolicy);
				//allocationProduct.setIncludeEffectiveInventory(includeEffectiveInventory);
				//allocationProduct.setIncludePromoSales(includePromoSales);
				//allocationProduct.setMaxShelf(maxShelf);
				//allocationProduct.setMinShelf(minShelf);
				//allocationProduct.setMethodWeeks(methodWeeks);
				//allocationProduct.setMethodDays(methodDays);
				//allocationProduct.setMethodClassLevelId(methodClassLevelId);
				//allocationProduct.setMethodEffInvInd(methodEffInvInd);
				//allocationProduct.setMethodId(methodId);
				//allocationProduct.setMethodStartDate(methodStartDate);
				//allocationProduct.setMethodTimeFrame(methodTimeFrame);
				//allocationProduct.setPoInnerPackSize(poInnerPackSize);
				//allocationProduct.setQuantitySource(quantitySource);
				//allocationProduct.setRoundFirstPack(roundFirstPack);
				//allocationProduct.setRoundPackSize(roundPackSize);
				//allocationProduct.setShipLevelInd(shipLevelInd);
				//allocationProduct.setStatusId(statusId);
				//allocationProduct.setUseMinMaxPolicy(useMinMaxPolicy);
				//allocationProduct.setVendorNumber(vendorNumber);
				allocationProducts.add(allocationProduct);
			});
		});
		allocationHeader.setAllocationDetails(allocationDetails);
		allocationHeader.setAllocationProducts(allocationProducts);
		allocationHeaderRepository.save(allocationHeader);
	}
}
