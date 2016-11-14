/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.homedepot.mm.po.allocationteamdata.controller.AllocationTeamDataController;
import com.homedepot.mm.po.allocationteamdata.domain.BayParmResource;
import com.homedepot.mm.po.allocationteamdata.entities.BayParm;

/**
 * @author axd8472
 *
 */
@Component
public class BayParmResourceAssembler extends ResourceAssemblerSupport<BayParm, BayParmResource> {

	/**
	 * 
	 */
	BayParmResourceAssembler() {
		super(AllocationTeamDataController.class, BayParmResource.class);
	}

	/**
	 * 
	 */
	@Override
	public List<BayParmResource> toResources(Iterable<? extends BayParm> arg0) {
		List<BayParmResource> bayParmResources = new ArrayList<>();

		for (BayParm bayParm : arg0) {
			BayParmResource bayParmResource = new BayParmResource(bayParm.getSequencenumber(), bayParm.getUploadid(),
					bayParm.getLocationid(), bayParm.getProductcode(), bayParm.getBay_parm_val(),
					bayParm.getActiveflag());

			bayParmResource.add(linkTo(AllocationTeamDataController.class).slash("find").withSelfRel());
			bayParmResources.add(bayParmResource);
		}

		return bayParmResources;
	}

	@Override
	public BayParmResource toResource(BayParm entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
