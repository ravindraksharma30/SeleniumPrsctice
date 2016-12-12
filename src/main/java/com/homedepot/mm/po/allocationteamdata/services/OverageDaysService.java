package com.homedepot.mm.po.allocationteamdata.services;

import java.util.List;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDays;

/**
 * Performs CRUD operations on the data retrieved from OverageDaysRepository.
 * 
 * @author gxk8870
 *
 */
public interface OverageDaysService {

	public List<OverageDays> getOverageDays(final String locationId, final String skuNumber, final String activeFlag);
}
