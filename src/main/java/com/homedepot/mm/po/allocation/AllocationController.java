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
	AllocationRepository allocationRepository;

	@RequestMapping("/find")
	public String findAll() {

		System.out.println("Inside ");
		List<BayParm> list = allocationRepository.findAll();

		return "Hello";
	}

}
