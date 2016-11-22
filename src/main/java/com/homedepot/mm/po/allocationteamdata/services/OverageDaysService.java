package com.homedepot.mm.po.allocationteamdata.services;

import java.util.List;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDays;
import com.homedepot.mm.po.allocationteamdata.exception.DataNotFoundException;

/**
 * Performs CRUD operations on the data retrieved from OverageDaysRepository.
 * 
 * @author gxk8870
 *
 */
public interface OverageDaysService {
	
	public List<OverageDays> getOverageDays(final String locationId, final String activeFlag) throws DataNotFoundException;
}
