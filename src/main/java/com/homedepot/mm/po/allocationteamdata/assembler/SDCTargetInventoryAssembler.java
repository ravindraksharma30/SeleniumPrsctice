package com.homedepot.mm.po.allocationteamdata.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.homedepot.mm.po.allocationteamdata.controller.BayParmController;
import com.homedepot.mm.po.allocationteamdata.controller.SDCTargetInventoryController;
import com.homedepot.mm.po.allocationteamdata.domain.SDCTargetInventoryResource;
import com.homedepot.mm.po.allocationteamdata.entities.SDCTargetInventory;

/**
 * SDCTargetInventoryAssembler is for implementing HATEOAS design
 * 
 * @author axd8472 & @author spv5283
 *
 */
@Component
public class SDCTargetInventoryAssembler
		extends ResourceAssemblerSupport<SDCTargetInventory, SDCTargetInventoryResource> {

	/**
	 * 
	 */
	public SDCTargetInventoryAssembler() {
		super(SDCTargetInventoryController.class, SDCTargetInventoryResource.class);
	}

	/**
	 * Returns sdcTargetInventoryResources with HATEOAS reference selRel link in
	 * JSON response
	 * 
	 * @param sdcTargetInventorys
	 * @return
	 */
	public List<SDCTargetInventoryResource> toResources(List<SDCTargetInventory> sdcTargetInventorys) {
		List<SDCTargetInventoryResource> sdcTargetInventoryResources = new ArrayList<SDCTargetInventoryResource>();
		sdcTargetInventorys.forEach(sdc -> {
			SDCTargetInventoryResource sdcTargetInventoryResource = new SDCTargetInventoryResource(
					sdc.getSequencenumber(), sdc.getUploadid(), sdc.getLocationid(), sdc.getProductcode(),
					sdc.getTgt_inv_qty(), sdc.getActiveflag());
			sdcTargetInventoryResource
					.add(linkTo(BayParmController.class).slash("findSDCTargetInventory").withSelfRel());

			sdcTargetInventoryResources.add(sdcTargetInventoryResource);
		});

		return sdcTargetInventoryResources;
	}

	@Override
	public SDCTargetInventoryResource toResource(SDCTargetInventory entity) {
		return null;
	}

}
