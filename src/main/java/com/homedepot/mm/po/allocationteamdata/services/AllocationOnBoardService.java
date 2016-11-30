package com.homedepot.mm.po.allocationteamdata.services;

import java.util.List;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.AllocationOnBoard;

/**
 * 
 * @author gxk8870
 *
 */
public interface AllocationOnBoardService {
	public List<AllocationOnBoard> getAllocationOnBoard(final Integer transloadAllocationParmTypeCode);
}
