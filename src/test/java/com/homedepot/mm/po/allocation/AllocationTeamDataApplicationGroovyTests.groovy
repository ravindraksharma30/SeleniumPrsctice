package com.homedepot.mm.po.allocation

import com.homedepot.mm.po.dao.DcmUploadsUiDAO;

import spock.lang.Specification

class AllocationTeamDataApplicationGroovyTests extends Specification {

	def dcmUploadsDAO
	def skuList
	def bayParmList
	
	def setup() {
		bayParmList = null
		
		skuList = new ArrayList<String>();
		skuList.add(263842)
		skuList.add(1000308041)
		skuList.add(894169)
	}
	
	def "A Connection, PreparedStatement, and ResultSet are able to be established." () {
		given: "A DcmUploadsUiDAO object is instantiated."
			dcmUploadsDAO = new DcmUploadsUiDAO()
		
		when: "A username and password are entered, and a query is created."
		
		then: "A Connection will be created."
			
	}
	
	def "Running the getBayParmMap method with the Location ID 0357 and a list of SKU's should return a HashMap of size 3." () {
		given: "A DcmUploadsUiDAO object is instantiated."
			dcmUploadsDAO = new DcmUploadsUiDAO()
			
		when: "The getBayParmList() method is run where the location ID is 0357 and the SKU list contains three SKU's."
			bayParmList = dcmUploadsDAO.getBayParmMap("0357", skuList)
			
		then: "A HashMap will be created with the SKU as the key and the DTO as the value."
			dcmUploadsDAO.bayParmMap.size() == 3
	}
	
	/*def "Adding an invalid SKU to the list for the Location ID 0357 should still return a HashMap of size 3." () {
		given: "A DcmUploadsUiDAO object is instantiated."
			dcmUploadsDAO = new DcmUploadsUiDAO()
		and: "An invalid SKU is added to the list for this Location ID."
			skuList.add(123456)
			
		when: "The getBayParmList() method is run where the location ID is 0357 and the SKU list contains four SKU's."
			bayParmList = dcmUploadsDAO.getBayParmMap("0357", skuList)
			
		then: "A HashMap of size three will be created."
			dcmUploadsDAO.bayParmMap.size() == 3
	}
	
	def "Not utilizing all SKU's assigned to a Location ID will still populate the HashMap based on the inputted list." () {
		given: "A DcmUploadsUiDAO object is instantiated."
			dcmUploadsDAO = new DcmUploadsUiDAO()
		and: "A valid SKU is removed from the list."
			skuList.removeAt(skuList.size() - 1)
			
		when: "The getBayParmList() method is run where the location ID is 0357 and the SKU list contains two SKU's."
			bayParmList = dcmUploadsDAO.getBayParmMap("0357", skuList)
			
		then: "A HashMap of size two will be created."
			dcmUploadsDAO.bayParmMap.size() == 2
	}*/
	
	
}
