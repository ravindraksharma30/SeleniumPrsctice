/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.homedepot.mm.po.allocationteamdata.controller.BayParmController;
import com.homedepot.mm.po.allocationteamdata.domain.BayParmResource;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParm;

/**
 * BayParmResourceAssembler is for implementing HATEOAS design
 * 
 * @author axd8472 & @author spv5283
 *
 */
@Component
public class BayParmResourceAssembler extends ResourceAssemblerSupport<BayParm, BayParmResource> {

	/**
	 * Constructor
	 */
	BayParmResourceAssembler() {
		super(BayParmController.class, BayParmResource.class);
	}

	/**
	 * Returns bayParmResources with HATEOAS reference selRel link in JSON
	 * response
	 * 
	 * @param bayParms
	 * @return
	 */
	public List<BayParmResource> toResources(List<BayParm> bayParms) {
		List<BayParmResource> bayParmResources = new ArrayList<>();

		bayParms.forEach(bayParm -> {
			BayParmResource bayParmResource = new BayParmResource(bayParm.getSequencenumber(), bayParm.getUploadid(),
					bayParm.getLocationid(), bayParm.getProductcode(), bayParm.getBay_parm_val(),
					bayParm.getActiveflag());

			bayParmResource.add(linkTo(BayParmController.class).slash("find").withSelfRel());
			bayParmResources.add(bayParmResource);
		});

		return bayParmResources;
	}

	@Override
	public BayParmResource toResource(BayParm entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
