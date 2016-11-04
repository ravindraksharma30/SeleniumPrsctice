package com.homedepot.mm.po.allocation

import spock.lang.Specification

class AllocationTeamDataApplicationGroovyTests extends Specification {

	def dcmUploadsDAO
	
	def setup() {
		
	}
	
	def "Creating a new DcmUploadsUiDAO object will produce a list of BayParmDTO's." () {
		given: "A DcmUploadsUiDAO object is instantiated."
			dcmUploadsDAO = new DcmUploadsUiDAO()
			
		when: ""
			
		then: "A list of BayParmDTO's will be populated."
			dcmUploadsDAO.bayParmList != null
	}
}
