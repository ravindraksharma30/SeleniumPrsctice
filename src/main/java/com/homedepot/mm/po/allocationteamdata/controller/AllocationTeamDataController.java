package com.homedepot.mm.po.allocationteamdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.mm.po.allocationteamdata.entities.BayParmJPA;
import com.homedepot.mm.po.allocationteamdata.repository.AllocationJpaRepository;

@RestController
public class AllocationTeamDataController {

	@Autowired
	AllocationJpaRepository allocationJpaRepository;

	@RequestMapping("/find")
	public List<BayParmJPA> findAll() {
		List<BayParmJPA> list = allocationJpaRepository.findByLocationidAndActiveflag("0551", "Y");
		return list;
	}

}
