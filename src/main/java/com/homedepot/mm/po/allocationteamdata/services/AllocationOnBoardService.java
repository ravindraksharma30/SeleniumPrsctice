package com.homedepot.mm.po.allocationteamdata.services;

import java.util.List;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.AllocationOnBoard;

/**
 * 
 * @author gxk8870
 *
 */
public interface AllocationOnBoardService {

	/**
	 * @see com.homedepot.mm.po.allocationteamdata.services.impl.AllocationOnBoardServiceImpl#findAllocationOnBoards()
	 * @param transloadAllocationParmTypeCode
	 */

	public List<AllocationOnBoard> findAllocationOnBoards(final Integer transloadAllocationParmTypeCode);
}
