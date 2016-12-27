package com.homedepot.mm.po.allocationteamdata.assembler;

import com.homedepot.mm.po.allocationteamdata.controller.OverageDaysController;
import com.homedepot.mm.po.allocationteamdata.domain.OverageDaysResource;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDays;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class OverageDaysResourceAssembler extends ResourceAssemblerSupport<OverageDays, OverageDaysResource> {

	OverageDaysResourceAssembler() {
		super(OverageDaysController.class, OverageDaysResource.class);
	}

	/**
	 * Returns OverageDaysResource with HATEOAS reference selRel link in JSON
	 * response
	 * @param overageDays
	 * @return
	 */
	public List<OverageDaysResource> toResources(List<OverageDays> overageDays) {
		List<OverageDaysResource> overageDaysResources = new ArrayList<>();

		overageDays.forEach(overageDay -> {
			OverageDaysResource overageDaysResource = new OverageDaysResource(overageDay.getSequencenumber(), overageDay.getUploadid(),
					overageDay.getLocationid(), overageDay.getProductcode(), overageDay.getOverage_days(),
					overageDay.getActiveflag());

			overageDaysResource.add(linkTo(OverageDaysController.class).slash("findOverageDays").withSelfRel());
			overageDaysResources.add(overageDaysResource);
		});

		return overageDaysResources;
	}
	
	@Override
	public OverageDaysResource toResource(OverageDays entity) {
		// TODO Auto-generated method stub
		return null;
	}


}
