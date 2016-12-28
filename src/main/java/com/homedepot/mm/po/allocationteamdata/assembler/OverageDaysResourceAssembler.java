package com.homedepot.mm.po.allocationteamdata.assembler;

import com.homedepot.mm.po.allocationteamdata.constants.AllocationTeamDataConstants;
import com.homedepot.mm.po.allocationteamdata.controller.OverageDaysController;
import com.homedepot.mm.po.allocationteamdata.domain.OverageDaysResource;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDays;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * OverageDaysResourceAssembler is for implementing HATEOAS design concept and
 * converts the resultset/dataset retrieved from database into output JSON
 * response using OverageDaysResource.
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
public class OverageDaysResourceAssembler extends ResourceAssemblerSupport<OverageDays, OverageDaysResource> {

	OverageDaysResourceAssembler() {
		super(OverageDaysController.class, OverageDaysResource.class);
	}

	/**
	 * Returns OverageDaysResource with HATEOAS reference selRel link in JSON
	 * response.
	 * 
	 * @param overageDays
	 * @return overageDaysResources
	 */
	public List<OverageDaysResource> toResources(final List<OverageDays> overageDays) {
		List<OverageDaysResource> overageDaysResources = new ArrayList<>();

		overageDays.forEach(overageDay -> {
			OverageDaysResource overageDaysResource = new OverageDaysResource(overageDay.getSequencenumber(),
					overageDay.getUploadid(), overageDay.getLocationid(), overageDay.getProductcode(),
					overageDay.getOverage_days(), overageDay.getActiveflag());

			overageDaysResource.add(linkTo(OverageDaysController.class)
					.slash(AllocationTeamDataConstants.OVERAGE_DAYS_PATH).withSelfRel());
			overageDaysResources.add(overageDaysResource);
		});

		return overageDaysResources;
	}

	@Override
	public OverageDaysResource toResource(final OverageDays entity) {
		return null;
	}

}
