package com.homedepot.mm.po.allocationteamdata.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homedepot.mm.po.allocationteamdata.AllocationTeamDataApplication;

import io.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { AllocationTeamDataApplication.class }, webEnvironment = WebEnvironment.RANDOM_PORT)

public class SDCTargetInventoryControllerTest {

	@LocalServerPort
	int port;

	@Test
	public void testFindSDCTargetInventory_StatusCode_200() throws Exception {

		given().when().get("/findSDCTargetInventory?locationId=5150&activeFlag=Y").then().statusCode(200);

	}

	@Test
	public void testFindSDCTargetInventory_JsonRespnse() throws Exception {
		given().when().get("/findSDCTargetInventory?locationId=5150&activeFlag=Y").then().assertThat()
				.body("productCode[0]", equalTo("1000017968"));
	}

	@Test
	public void testFindSDCTargetInventory_JsonRespnse_ContainsString() throws Exception {
		given().when().get("/findSDCTargetInventory?locationId=5150&activeFlag=Y").then().assertThat()
				.body(containsString("1000017968"));
	}

	@Before
	public void setUp() {

		RestAssured.basePath = "/AllocationTeamData";
		RestAssured.port = port;
	}

}
