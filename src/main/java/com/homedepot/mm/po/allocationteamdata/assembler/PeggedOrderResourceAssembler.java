/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.homedepot.mm.po.allocationteamdata.controller.PeggedOrderController;
import com.homedepot.mm.po.allocationteamdata.domain.PeggedOrderResource;
import com.homedepot.mm.po.allocationteamdata.entities.oracle.PeggedOrder;

/**
 * @author axd8472
 *
 */
@Component
public class PeggedOrderResourceAssembler extends ResourceAssemblerSupport<PeggedOrder, PeggedOrderResource> {

	/**
	 * Constructor
	 */
	PeggedOrderResourceAssembler() {
		super(PeggedOrderController.class, PeggedOrderResource.class);
	}

	/**
	 * Returns peggedOrderResources with HATEOAS reference selRel link in JSON
	 * response
	 * 
	 * @param peggedOrders
	 * @return peggedOrderResources
	 */
	public List<PeggedOrderResource> toResources(List<PeggedOrder> peggedOrders) {
		List<PeggedOrderResource> peggedOrderResources = new ArrayList<>();

		peggedOrders.forEach(peggedOrder -> {
			PeggedOrderResource peggedOrderResource = new PeggedOrderResource(peggedOrder.getDest_loc_nbr(),
					peggedOrder.getDest_loc_typ_cd(), peggedOrder.getPeg_ord_qty(), peggedOrder.getPeg_typ_cd());

			peggedOrderResource.add(linkTo(PeggedOrderController.class).slash("findPeggedOrders").withSelfRel());
			peggedOrderResources.add(peggedOrderResource);
		});

		return peggedOrderResources;
	}

	/**
	 * 
	 */
	@Override
	public PeggedOrderResource toResource(PeggedOrder peggedOrder) {
		PeggedOrderResource peggedOrderResource = new PeggedOrderResource(peggedOrder.getDest_loc_nbr(),
				peggedOrder.getDest_loc_typ_cd(), peggedOrder.getPeg_ord_qty(), peggedOrder.getPeg_typ_cd());

		peggedOrderResource.add(linkTo(PeggedOrderController.class).slash("findPeggedOrders").withSelfRel());
		return peggedOrderResource;
	}

}
