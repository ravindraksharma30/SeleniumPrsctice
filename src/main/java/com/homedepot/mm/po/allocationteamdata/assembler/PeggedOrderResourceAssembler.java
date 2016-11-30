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
			PeggedOrderResource peggedOrderResource = new PeggedOrderResource(peggedOrder.getVirt_peg_ord_id(),
					peggedOrder.getBol_nbr(), peggedOrder.getSrc_loc_nbr(), peggedOrder.getDest_loc_nbr(),
					peggedOrder.getSrc_loc_typ_cd(), peggedOrder.getDest_loc_typ_cd(), peggedOrder.getMvndr_nbr(),
					peggedOrder.getMer_dept_nbr(), peggedOrder.getSku_nbr(), peggedOrder.getPeg_ord_qty(),
					peggedOrder.getInb_ord_nbr(), peggedOrder.getPrnt_peg_ord_id(), peggedOrder.getPeg_ord_wrk_id(),
					peggedOrder.getSoq_ref_id(), peggedOrder.getPeg_ord_stat_cd(), peggedOrder.getPrcsd_flg(),
					peggedOrder.getBuy_uom_qty(), peggedOrder.getPeg_typ_cd(), peggedOrder.getPeg_ord_rsn_typ_cd(),
					peggedOrder.getSku_sub_typ_cd(), peggedOrder.getPort_expctd_arvl_ts());

			peggedOrderResource.add(linkTo(PeggedOrderController.class).slash("findPeggedOrders").withSelfRel());
			peggedOrderResources.add(peggedOrderResource);
		});

		return peggedOrderResources;
	}

	@Override
	public PeggedOrderResource toResource(PeggedOrder entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
