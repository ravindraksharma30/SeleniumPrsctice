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
import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParmEntityDTO;

/**
 * BayParmResourceAssembler is for implementing HATEOAS design
 * 
 * @author axd8472
 *
 */
@Component
public class BayParmResourceAssembler extends ResourceAssemblerSupport<BayParmEntityDTO, BayParmResource> {

	/**
	 * 
	 */
	BayParmResourceAssembler() {
		super(BayParmController.class, BayParmResource.class);
	}

	/**
	 * 
	 */
	@Override
	public List<BayParmResource> toResources(Iterable<? extends BayParmEntityDTO> arg0) {
		List<BayParmResource> bayParmResources = new ArrayList<>();

		arg0.forEach(BayParmEntityDTO -> {
			BayParmResource bayParmResource = new BayParmResource(BayParmEntityDTO.getSequencenumber(), BayParmEntityDTO.getUploadid(),
					BayParmEntityDTO.getLocationid(), BayParmEntityDTO.getProductcode(), BayParmEntityDTO.getBay_parm_val(),
					BayParmEntityDTO.getActiveflag());

			bayParmResource.add(linkTo(BayParmController.class).slash("find").withSelfRel());
			bayParmResources.add(bayParmResource);
		});

		return bayParmResources;
	}

	/**
	 * 
	 */
	@Override
	public BayParmResource toResource(BayParmEntityDTO entity) {
		return null;
	}

}
