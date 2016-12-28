package com.homedepot.mm.po.allocationteamdata.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.homedepot.mm.po.allocationteamdata.constants.AllocationTeamDataConstants;
import com.homedepot.mm.po.allocationteamdata.controller.AllocationOnBoardController;
import com.homedepot.mm.po.allocationteamdata.domain.AllocationOnBoardResource;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.AllocationOnBoard;

/**
 * AllocationOnBoardAssembler is for implementing HATEOAS design concept and
 * converts the resultset/dataset retrieved from database into output JSON
 * response using AllocationOnBoardResource.
 * 
 * @see <a href= "https://spring.io/guides/gs/rest-hateoas/">Spring-REST HATEOAS
 *      reference link 1</a>
 * 
 * @see <a href= "https://spring.io/understanding/HATEOAS/">Spring-REST HATEOAS
 *      reference link 2</a>
 * 
 * 
 * 
 * @author rjc03
 *
 */
@Component
public class AllocationOnBoardAssembler extends ResourceAssemblerSupport<AllocationOnBoard, AllocationOnBoardResource> {

	AllocationOnBoardAssembler() {
		super(AllocationOnBoardController.class, AllocationOnBoardResource.class);
	}

	/**
	 * Returns allocationOnBoardResources with HATEOAS selRel reference link in
	 * JSON response.
	 * 
	 * @param allocationsOnBoard
	 * @return allocationOnBoardResources
	 */
	public List<AllocationOnBoardResource> toResources(final List<AllocationOnBoard> allocationsOnBoard) {
		List<AllocationOnBoardResource> allocationOnBoardResources = new ArrayList<>();

		if (!allocationsOnBoard.isEmpty()) {

			allocationsOnBoard.forEach(allocationOnBoard -> {
				AllocationOnBoardResource allocationOnBoardResource = new AllocationOnBoardResource(
						allocationOnBoard.getId().getTld_alloc_onbrd_parm_id(),
						allocationOnBoard.getId().getTld_alloc_parm_typ_cd(), allocationOnBoard.getParm_mvndr_prty_id(),
						allocationOnBoard.getParm_item_id(), allocationOnBoard.getParm_loc_id(),
						allocationOnBoard.getParm_loc_typ_cd(), allocationOnBoard.getParm_flg_val(),
						allocationOnBoard.getParm_intg_val(), allocationOnBoard.getParm_dt_val(),
						allocationOnBoard.getParm_char_val(), allocationOnBoard.getParm_dec_val(),
						allocationOnBoard.getActv_flg());

				allocationOnBoardResource.add(linkTo(AllocationOnBoardController.class)
						.slash(AllocationTeamDataConstants.ALLOCATION_ON_BOARD_PATH).withSelfRel());
				allocationOnBoardResources.add(allocationOnBoardResource);
			});
		}

		return allocationOnBoardResources;
	}

	/**
	 * 
	 */
	@Override
	public AllocationOnBoardResource toResource(final AllocationOnBoard entity) {
		return null;
	}
}
