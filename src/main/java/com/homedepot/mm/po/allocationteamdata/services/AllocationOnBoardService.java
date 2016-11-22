package com.homedepot.mm.po.allocationteamdata.services;

import java.util.List;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.AllocationOnBoard;
import com.homedepot.mm.po.allocationteamdata.exception.DataNotFoundException;

/**
 * 
 * @author gxk8870
 *
 */
public interface AllocationOnBoardService {
	public List<AllocationOnBoard> getAllocationOnBoard(final Integer transloadAllocationParmTypeCode)
			throws DataNotFoundException;
}
