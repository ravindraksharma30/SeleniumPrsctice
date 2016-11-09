package com.homedepot.mm.po.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.mm.po.dto.BayParmDTO;

@RestController
public class AllocationTeamDataController {

	@RequestMapping(path="/bayParm", method = RequestMethod.GET)
	public List<BayParmDTO> getBayParmMap(){//@RequestBody int locationID) {
		return null;//DcmUploadsUiDAO.getBayParmList(parmTypeID, onbrdParmID);
	}
	@RequestMapping("/hodor")
	public String hodor(@RequestParam String hodor){
		return hodor;
	}
}
