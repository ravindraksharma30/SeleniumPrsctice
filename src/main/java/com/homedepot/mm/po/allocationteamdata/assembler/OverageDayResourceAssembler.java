package com.homedepot.mm.po.allocationteamdata.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.homedepot.mm.po.allocationteamdata.constants.AllocationTeamDataConstants;
import com.homedepot.mm.po.allocationteamdata.controller.OverageDayController;
import com.homedepot.mm.po.allocationteamdata.domain.OverageDayResource;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDay;
import com.homedepot.mm.po.allocationteamdata.response.OverageDaysResponse;

/**
 * OverageDaysResourceAssembler is for implementing Spring HATEOAS to ease
 * creating REST representations that follow the HATEOAS principle . It converts
 * the resultset/dataset retrieved from database into output JSON response using
 * {@link OverageDayResource}.
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
public class OverageDayResourceAssembler extends ResourceAssemblerSupport<OverageDay, OverageDayResource> {

	/**
	 * Default constructor
	 */
	public OverageDayResourceAssembler() {
		super(OverageDayController.class, OverageDayResource.class);
	}

	/**
	 * Returns {@link OverageDaysResponse} with HATEOAS reference selRel link in
	 * JSON response.
	 * 
	 * @param overageDay
	 * @return overageDayResource
	 */
	@Override
	public OverageDayResource toResource(final OverageDay overageDay) {
		OverageDayResource overageDayResource = new OverageDayResource(overageDay.getSequencenumber(),
				overageDay.getUploadid(), overageDay.getLocationid(), overageDay.getProductcode(),
				overageDay.getOverage_days(), overageDay.getActiveflag());

		overageDayResource.add(
				linkTo(OverageDayController.class).slash(AllocationTeamDataConstants.OVERAGE_DAYS_PATH).withSelfRel());

		return overageDayResource;
	}

}
