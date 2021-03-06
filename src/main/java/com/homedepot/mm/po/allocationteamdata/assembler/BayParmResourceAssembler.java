/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.homedepot.mm.po.allocationteamdata.constants.AllocationTeamDataConstants;
import com.homedepot.mm.po.allocationteamdata.controller.BayParmController;
import com.homedepot.mm.po.allocationteamdata.domain.BayParmResource;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParm;
import com.homedepot.mm.po.allocationteamdata.response.BayParmResponse;

/**
 * BayParmResourceAssembler is for implementing Spring HATEOAS to ease creating
 * REST representations that follow the HATEOAS principle . It converts the
 * resultset/dataset retrieved from database into output JSON response using
 * {@link BayParmResponse}.
 * 
 * @see <a href= "https://spring.io/guides/gs/rest-hateoas/">Spring-REST HATEOAS
 *      reference link 1</a>
 * 
 * @see <a href= "https://spring.io/understanding/HATEOAS/">Spring-REST HATEOAS
 *      reference link 2</a>
 * 
 * @author axd8472 & @author spv5283
 * 
 */
@Component
public class BayParmResourceAssembler extends ResourceAssemblerSupport<BayParm, BayParmResource> {

	/**
	 * Default Constructor
	 */
	public BayParmResourceAssembler() {
		super(BayParmController.class, BayParmResource.class);
	}

	@Override
	public BayParmResource toResource(final BayParm bayParm) {
		BayParmResource bayParmResource = new BayParmResource(bayParm.getSequencenumber(), bayParm.getUploadid(),
				bayParm.getLocationid(), bayParm.getProductcode(), bayParm.getBay_parm_val(), bayParm.getActiveflag());

		bayParmResource
				.add(linkTo(BayParmController.class).slash(AllocationTeamDataConstants.BAY_PARM_PATH).withSelfRel());
		return bayParmResource;
	}

}
