package com.homedepot.mm.po.allocationteamdata.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.AllocationOnBoard;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.AllocationOnBoardRepository;
import com.homedepot.mm.po.allocationteamdata.services.AllocationOnBoardService;

/**
 * 
 * @author rjc03
 *
 */
@Service("AllocationOnBoardServiceImpl")
public class AllocationOnBoardServiceImpl implements AllocationOnBoardService {

	@Autowired
	AllocationOnBoardRepository allocationOnBoardRepository;

	@Override
	public List<AllocationOnBoard> getAllocationOnBoard(final Integer transloadAllocationParmTypeCode) {

		List<AllocationOnBoard> allocationOnBoards = allocationOnBoardRepository
				.findByTransloadAllocationParmTypeCode(transloadAllocationParmTypeCode);
		
		return allocationOnBoards;
	}
}
