package com.homedepot.mm.po.allocationteamdata.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDays;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.OverageDaysRepository;
import com.homedepot.mm.po.allocationteamdata.services.OverageDaysService;

@Service("OverageDaysServiceImpl")
public class OverageDaysServiceImpl implements OverageDaysService {

	@Autowired
	OverageDaysRepository overageDaysRepository;

	@Override
	public List<OverageDays> getOverageDays(final String locationId, final String activeFlag) {
		final List<OverageDays> overageDays = overageDaysRepository.findByLocationidAndActiveflag(locationId,
				activeFlag);
		return overageDays;
	}
}
