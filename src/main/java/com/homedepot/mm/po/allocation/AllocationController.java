/**
 * 
 */
package com.homedepot.mm.po.allocation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author axd8472
 *
 */
@RestController
public class AllocationController {

	@Autowired
	// AllocationRepository allocationRepository;
	AllocationJpaRepository allocationJpaRepository;

	@RequestMapping("/find")
	public List<BayParmJpa> findAll() {

		System.out.println("Inside Controller");
		// List<BayParmJpa> list = allocationJpaRepository.findAll();
		// List<BayParmJpa> list =
		// allocationJpaRepository.findByLocationid(357);

		List<BayParmJpa> list = allocationJpaRepository.findByLocationidAndActiveflag("0551", "Y");
		// allocationJpaRepository.delete();

		return list;
	}

}
