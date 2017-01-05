/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.homedepot.mm.po.allocationteamdata.constants.AllocationTeamDataConstants;
import com.homedepot.mm.po.allocationteamdata.controller.PeggedOrderController;
import com.homedepot.mm.po.allocationteamdata.domain.PeggedOrderResource;
import com.homedepot.mm.po.allocationteamdata.entities.oracle.PeggedOrder;

/**
 * PeggedOrderResourceAssembler is for implementing Spring HATEOAS to ease
 * creating REST representations that follow the HATEOAS principle . It converts
 * the resultset/dataset retrieved from database into output JSON response using
 * {@link PeggedOrderResource}.
 * 
 * @see <a href= "https://spring.io/guides/gs/rest-hateoas/">Spring-REST HATEOAS
 *      reference link 1</a>
 * 
 * @see <a href= "https://spring.io/understanding/HATEOAS/">Spring-REST HATEOAS
 *      reference link 2</a>
 * 
 * @author axd8472
 *
 */
@Component
public class PeggedOrderResourceAssembler extends ResourceAssemblerSupport<PeggedOrder, PeggedOrderResource> {

	/**
	 * Default Constructor
	 */
	PeggedOrderResourceAssembler() {
		super(PeggedOrderController.class, PeggedOrderResource.class);
	}

	/**
	 * @param peggedOrder
	 * @return peggedOrderResource
	 */
	@Override
	public PeggedOrderResource toResource(final PeggedOrder peggedOrder) {
		PeggedOrderResource peggedOrderResource = new PeggedOrderResource(peggedOrder.getDest_loc_nbr(),
				peggedOrder.getDest_loc_typ_cd(), peggedOrder.getPeg_ord_qty(), peggedOrder.getPeg_typ_cd());

		peggedOrderResource.add(
				linkTo(PeggedOrderController.class).slash(AllocationTeamDataConstants.PEGGED_ORDER_PATH).withSelfRel());
		return peggedOrderResource;
	}

}
