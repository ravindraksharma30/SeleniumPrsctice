package com.homedepot.mm.po.allocationteamdata.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.homedepot.mm.po.allocationteamdata.constants.AllocationTeamDataConstants;
import com.homedepot.mm.po.allocationteamdata.controller.BayParmController;
import com.homedepot.mm.po.allocationteamdata.controller.SDCTargetInventoryController;
import com.homedepot.mm.po.allocationteamdata.domain.SDCTargetInventoryResource;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.SDCTargetInventory;

/**
 * SDCTargetInventoryAssembler is for implementing HATEOAS design concept and
 * converts the resultset/dataset retrieved from database into output JSON
 * response using SDCTargetInventoryResource.
 * 
 * @see <a href= "https://spring.io/guides/gs/rest-hateoas/">Spring-REST HATEOAS
 *      reference link 1</a>
 * 
 * @see <a href= "https://spring.io/understanding/HATEOAS/">Spring-REST HATEOAS
 *      reference link 2</a>
 * 
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
	 * Returns sdcTargetInventoryResources with HATEOAS selRel reference link in
	 * JSON response.
	 * 
	 * @param sdcTargetInventorys
	 * @return sdcTargetInventoryResources
	 */
	public List<SDCTargetInventoryResource> toResources(final List<SDCTargetInventory> sdcTargetInventorys) {
		List<SDCTargetInventoryResource> sdcTargetInventoryResources = new ArrayList<SDCTargetInventoryResource>();
		sdcTargetInventorys.forEach(sdc -> {
			SDCTargetInventoryResource sdcTargetInventoryResource = new SDCTargetInventoryResource(
					sdc.getSequencenumber(), sdc.getUploadid(), sdc.getLocationid(), sdc.getProductcode(),
					sdc.getTgt_inv_qty(), sdc.getActiveflag());
			sdcTargetInventoryResource.add(linkTo(BayParmController.class)
					.slash(AllocationTeamDataConstants.SDC_TARGET_INVENTORY_PATH).withSelfRel());

			sdcTargetInventoryResources.add(sdcTargetInventoryResource);
		});

		return sdcTargetInventoryResources;
	}

	@Override
	public SDCTargetInventoryResource toResource(final SDCTargetInventory entity) {
		return null;
	}

}
