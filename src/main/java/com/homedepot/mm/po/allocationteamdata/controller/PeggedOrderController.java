/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.mm.po.allocationteamdata.assembler.PeggedOrderResourceAssembler;
import com.homedepot.mm.po.allocationteamdata.domain.PeggedOrderResource;
import com.homedepot.mm.po.allocationteamdata.dto.TransloadSkuDTO;
import com.homedepot.mm.po.allocationteamdata.entities.oracle.PeggedOrder;
import com.homedepot.mm.po.allocationteamdata.services.PeggedOrderService;
import com.homedepot.mm.po.allocationteamdata.validator.PeggedOrderValidator;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author axd8472
 *
 */
@RestController
public class PeggedOrderController {

	@Autowired
	PeggedOrderService peggedOrderService;

	@Autowired
	PeggedOrderResourceAssembler peggedOrderResourceAssembler;

	@Autowired
	PeggedOrderValidator peggedOrderValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(peggedOrderValidator);
	}

	@InitBinder
	public void initBinderDate(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

	}

	@GetMapping(value = "/findPeggedOrders", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve Pegging data based on ASN/PO combination", nickname = "Pegging")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "asnNumber", value = "ASN Number", required = false, dataType = "string", paramType = "query", defaultValue = "0"),
			@ApiImplicitParam(name = "poNumber", value = "PO Number", required = false, dataType = "string", paramType = "query", defaultValue = "0"),
			@ApiImplicitParam(name = "skuNumber", value = "SKU Number", required = false, dataType = "string", paramType = "query", defaultValue = "0") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = PeggedOrderController.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })

	/**
	 * 
	 * @param asnNumber
	 * @param poNumber
	 * @return
	 */
	public ResponseEntity<List<PeggedOrderResource>> findPeggedOrders(@QueryParam("asnNumber") String asnNumber,
			@QueryParam("poNumber") String poNumber, @QueryParam("skuNumber") BigDecimal skuNumber) {

		final List<PeggedOrder> peggedOrders = peggedOrderService.findPeggedOrders(asnNumber, poNumber, skuNumber);
		final List<PeggedOrderResource> resources = peggedOrderResourceAssembler.toResources(peggedOrders);

		return new ResponseEntity<List<PeggedOrderResource>>(resources, HttpStatus.OK);
	}

	@PostMapping(value = "/createPeggedOrders", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create Pegging orders based on AllocationDCDetailsDTO", nickname = "Pegging")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "asnNumber", value = "ASN Number", required = false, dataType = "string", paramType = "query", defaultValue = "0") })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = PeggedOrderController.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })

	/**
	 * 
	 * @param transloadSkuDTO
	 * @return
	 */
	public ResponseEntity<?> createPeggedOrders(@RequestBody TransloadSkuDTO transloadSkuDTO, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		peggedOrderService.createPeggedOrders(transloadSkuDTO);
		return ResponseEntity.noContent().build();
	}

}
