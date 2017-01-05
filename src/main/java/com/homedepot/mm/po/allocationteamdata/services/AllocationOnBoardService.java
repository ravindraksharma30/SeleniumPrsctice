package com.homedepot.mm.po.allocationteamdata.services;

import java.util.List;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.AllocationOnBoard;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.AllocationOnBoardRepository;

/**
 * Defines an API for performing business logic around CRUD operations using
 * {@link AllocationOnBoardRepository}.
 * 
 * @author gxk8870
 *
 */
public interface AllocationOnBoardService {

	/**
	 * 
	 * @see com.homedepot.mm.po.allocationteamdata.services.impl.AllocationOnBoardServiceImpl#findAllocationOnBoards()
	 * @param transloadAllocationParmTypeCode
	 * @return allocationOnBoard
	 */
	public List<AllocationOnBoard> findAllocationOnBoards(final Integer transloadAllocationParmTypeCode);
}
