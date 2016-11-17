package com.homedepot.mm.po.allocationteamdata.services;

import java.util.List;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.AllocationOnBoard;
import com.homedepot.mm.po.allocationteamdata.exception.DataNotFoundException;

public interface AllocationOnBoardService {
	public List<AllocationOnBoard> getAllocationOnBoard(final Integer locationId, final String activeFlag) throws DataNotFoundException;
}
