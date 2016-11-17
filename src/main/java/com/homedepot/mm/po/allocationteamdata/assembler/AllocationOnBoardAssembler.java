package com.homedepot.mm.po.allocationteamdata.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.homedepot.mm.po.allocationteamdata.controller.AllocationOnBoardController;
import com.homedepot.mm.po.allocationteamdata.domain.AllocationOnBoardResource;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.AllocationOnBoard;

/**
 * AllocationOnBoardAssembler is for implementing HATEOAS design
 * @author rjc03
 *
 */
@Component
public class AllocationOnBoardAssembler extends ResourceAssemblerSupport<AllocationOnBoard, AllocationOnBoardResource> {
	
	AllocationOnBoardAssembler() {
		super(AllocationOnBoardController.class, AllocationOnBoardResource.class);
	}
	
	public List<AllocationOnBoardResource> toResources(List<AllocationOnBoard> allocationsOnBoard) {
		List<AllocationOnBoardResource> allocationOnBoardResources = new ArrayList<>();
		
		allocationsOnBoard.forEach(allocationOnBoard -> {
			AllocationOnBoardResource allocationOnBoardResource = new AllocationOnBoardResource(allocationOnBoard.getTld_alloc_onbrd_parm_id(), 
					allocationOnBoard.getTld_alloc_parm_typ_cd(), 
					allocationOnBoard.getParm_mvndr_prty_id(), 
					allocationOnBoard.getParm_item_id(), 
					allocationOnBoard.getParm_loc_id(), 
					allocationOnBoard.getParm_loc_type_cd(), 
					allocationOnBoard.getParm_flg_val(),
					allocationOnBoard.getParm_intg_val(), 
					allocationOnBoard.getParm_dt_val(), 
					allocationOnBoard.getParm_char_val(), 
					allocationOnBoard.getParm_dec_val(), 
					allocationOnBoard.getActv_flg());
			
			allocationOnBoardResource.add(linkTo(AllocationOnBoardController.class).slash("find").withSelfRel());
			allocationOnBoardResources.add(allocationOnBoardResource);
		});
		
		return allocationOnBoardResources;
	}
	
	@Override
	public AllocationOnBoardResource toResource(AllocationOnBoard entity) {
		return null;
	}
}
